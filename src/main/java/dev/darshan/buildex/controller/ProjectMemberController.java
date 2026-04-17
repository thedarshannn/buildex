package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.member.InviteMemberRequest;
import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.dto.member.UpdateMemberRoleRequest;
import dev.darshan.buildex.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects/{projectId}/members")
public class ProjectMemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<ProjectMemberResponse>> getAllMembers(
            @PathVariable Long projectId
    ){
        Long userId = 1L;
        return ResponseEntity.ok(memberService.getAllMembers(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<ProjectMemberResponse> inviteMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest inviteMemberRequest
    ){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                memberService.inviteMember(projectId, inviteMemberRequest, userId)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<ProjectMemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                memberService.updateMemberRole(projectId, updateMemberRoleRequest, memberId)
        );
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ProjectMemberResponse> deleteMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    ){
        Long userId = 1L;
        return ResponseEntity.ok(memberService.deleteProjectMember(projectId, memberId, userId));
    }
}
