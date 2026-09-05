package dev.darshan.buildex.repository;

import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember>  findByProjectId(Long projectId);

    Optional<ProjectMember> findByUserId(Long memberId);
}