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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String email;

    String passwordHash;

    @Column(nullable = false)
    String name;

    String avatarUrl;

    @CreationTimestamp
    Instant createAt;

    @UpdateTimestamp
    Instant updateAt;

    Instant deletedAt; // Used for soft delete, keeping the record of a user


}
