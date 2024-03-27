package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.In_Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AdminDto {
    private String firstName;
    private String lastName;
    private String email;
}
