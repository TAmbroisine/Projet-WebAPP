package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Admin;

import java.io.IOException;

public class AdminMapper {
    public static Admin fromDto(AdminDto dto, Long id) throws IOException {
        return new Admin.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    public static AdminDto toDto (Admin admin){
        return AdminDto.builder()
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .build();
    }
}
