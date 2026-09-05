package dev.darshan.buildex.entity;

import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    Boolean isPublic;

    @CreationTimestamp
    Instant createAt;

    @UpdateTimestamp
    Instant updateAt;

    Instant deletedAt;
}
