package com.vibetrack.identity.mapper;


import com.vibetrack.identity.dto.request.UserCreationRequest;
import com.vibetrack.identity.dto.request.UserUpdateRequest;
import com.vibetrack.identity.dto.response.UserResponse;
import com.vibetrack.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // Spring is used as the component model
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
