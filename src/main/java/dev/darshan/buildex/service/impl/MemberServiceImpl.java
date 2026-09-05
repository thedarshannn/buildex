package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;
import dev.darshan.buildex.entity.Project;
import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.ProjectMemberId;
import dev.darshan.buildex.entity.User;
import dev.darshan.buildex.enums.ProjectMemberRole;
import dev.darshan.buildex.error.exceptions.ForbiddenException;
import dev.darshan.buildex.error.exceptions.ResourceNotFoundException;
import dev.darshan.buildex.mapper.ProjectMemberMapper;
import dev.darshan.buildex.repository.ProjectMemberRepository;
import dev.darshan.buildex.repository.ProjectRepository;
import dev.darshan.buildex.repository.UserRepository;
import dev.darshan.buildex.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<ProjectMemberResponse> getAllMembers(Long projectId, Long userId) {

        getAccessibleProjectById(projectId, userId);

        return projectMemberRepository.findByProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();

    }

    @Override
    public ProjectMemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        requireOwner(projectId, userId);

        User invitee = userRepository.findByEmail(inviteMemberRequest.email()).orElseThrow();

        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself!");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite again!");
        }

        ProjectMember projectMember = ProjectMember.builder()
                .projectMemberId(projectMemberId)
                .project(project)
                .user(invitee)
                .memberRole(inviteMemberRequest.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public ProjectMemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest, Long userId) {

        getAccessibleProjectById(projectId, userId);

        requireOwner(projectId, userId);

        if (memberId.equals(userId)) {
            throw new ForbiddenException("The owner cannot change their own role");
        }

        ProjectMember memberToUpdate = getProjectMember(projectId, memberId);
        memberToUpdate.setMemberRole(updateMemberRoleRequest.role());

        projectMemberRepository.save(memberToUpdate);

        return projectMemberMapper.toProjectMemberResponseFromMember(memberToUpdate);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {

        getAccessibleProjectById(projectId, userId);

        requireOwner(projectId, userId);

        if (memberId.equals(userId)) {
            throw new ForbiddenException("The owner cannot be removed from the project");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("User is not in the project members");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }


    /// Internal Methods

    private Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }

    private ProjectMember getProjectMember(Long projectId, Long userId) {
        return projectMemberRepository.findById(new ProjectMemberId(projectId, userId))
                .orElseThrow(() -> new ResourceNotFoundException("Project member", userId.toString()));
    }

    /**
     * Ownership now lives on {@link ProjectMember} instead of {@link Project},
     * so member management is gated on the caller holding the OWNER role.
     */
    private void requireOwner(Long projectId, Long userId) {
        ProjectMember caller = getProjectMember(projectId, userId);

        if (caller.getMemberRole() != ProjectMemberRole.OWNER) {
            throw new ForbiddenException("Only the project owner can manage members");
        }
    }
}
