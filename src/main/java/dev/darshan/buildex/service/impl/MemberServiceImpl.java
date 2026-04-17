package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;
import dev.darshan.buildex.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public List<ProjectMemberResponse> getAllMembers(Long projectId, Long userId) {
        return List.of();
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
}
