package com.vibetrack.identity.mapper;

import com.vibetrack.identity.dto.request.RoleRequest;
import com.vibetrack.identity.dto.response.RoleResponse;
import com.vibetrack.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
