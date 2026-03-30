package dev.darshan.buildex.dto.auth;

/**
 * Represents an immutable data carrier for a User. </br>
 * A <b>Java Record</b> automatically generates the constructor, </br>
 * getters (e.g., name(), age()), equals(), hashCode(), and toString().
 */
public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
