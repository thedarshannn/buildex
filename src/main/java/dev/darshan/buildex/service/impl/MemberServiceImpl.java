package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;
import dev.darshan.buildex.entity.Project;
import dev.darshan.buildex.mapper.ProjectMemberMapper;
import dev.darshan.buildex.repository.ProjectMemberRepository;
import dev.darshan.buildex.repository.ProjectRepository;
import dev.darshan.buildex.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public ProjectMemberResponse updateMemberRole(Long projectId, UpdateMemberRoleRequest updateMemberRoleRequest, Long memberId) {
        return null;
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
