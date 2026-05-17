package dev.darshan.buildex.repository;

import dev.darshan.buildex.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("""
           SELECT  p FROM Project p     
           WHERE p.deletedAt IS NULL 
           AND p.owner.id = :userId
           ORDER BY p.updateAt DESC 
           """
    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);
}