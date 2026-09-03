package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;


import java.util.List;


public interface MemberService {
    List<ProjectMemberResponse> getAllMembers(Long projectId, Long userId);

    ProjectMemberResponse inviteMember(Long projectId, InviteMemberRequest inviteMemberRequest, Long userId);

    ProjectMemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest, Long userId);

    void removeProjectMember(Long projectId, Long memberId, Long userId);
}
