package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;
import dev.darshan.buildex.entity.Project;
import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.ProjectMemberId;
import dev.darshan.buildex.entity.User;
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
import java.util.ArrayList;
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

        Project project = getAccessibleProjectById(projectId, userId);
        List<ProjectMemberResponse> memberResponse = new ArrayList<>();

        memberResponse.add(projectMemberMapper.toProjectMemberResponse(project.getOwner()));

        memberResponse.addAll(
                projectMemberRepository.findByProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList()
        );

        return memberResponse;
    }

    @Override
    public ProjectMemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not Allowed!");
        }

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
    public ProjectMemberResponse updateMemberRole(Long projectId, UpdateMemberRoleRequest updateMemberRoleRequest, Long memberId) {

        Project project = getAccessibleProjectById(projectId, memberId);

        if (!project.getOwner().getId().equals(memberId)) {
            throw new RuntimeException("Not Allowed!");
        }

        ProjectMember memberToUpdate = projectMemberRepository.findById(new ProjectMemberId(projectId, memberId)).orElseThrow();
        memberToUpdate.setMemberRole(updateMemberRoleRequest.role());

        projectMemberRepository.save(memberToUpdate);

        return projectMemberMapper.toProjectMemberResponseFromMember(memberToUpdate);
    }

    @Override
    public ProjectMemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }


    /// Internal Methods

    private Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
