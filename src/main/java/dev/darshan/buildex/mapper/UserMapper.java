package dev.darshan.buildex.mapper;

import dev.darshan.buildex.dto.auth.SignUpRequest;
import dev.darshan.buildex.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntiy(SignUpRequest signUpRequest);
}
