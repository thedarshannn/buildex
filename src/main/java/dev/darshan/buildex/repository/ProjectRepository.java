package dev.darshan.buildex.repository;

import dev.darshan.buildex.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT p
            FROM Project p
            JOIN ProjectMember pm ON pm.project = p
            WHERE pm.user.id = :userId
              AND p.deletedAt IS NULL
            """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);


    @Query("""
            SELECT p
            FROM Project p
            JOIN ProjectMember pm ON pm.project = p
            WHERE p.id = :projectId
              AND pm.user.id = :userId
              AND p.deletedAt IS NULL
            """)
    Optional<Project> findAccessibleProjectById(
            @Param("projectId") Long projectId,
            @Param("userId") Long userId
    );
}
