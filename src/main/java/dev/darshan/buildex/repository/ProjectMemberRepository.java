package dev.darshan.buildex.repository;

import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
}