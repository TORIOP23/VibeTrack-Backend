package com.vibetrack.identity.mapper;


import com.vibetrack.identity.dto.request.PermissionRequest;
import com.vibetrack.identity.dto.response.PermissionResponse;
import com.vibetrack.identity.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
