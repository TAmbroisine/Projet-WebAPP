package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.In_Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Builder
@Getter
public class BuyerDto {
    private String firstName;
    private String lastName;
    private String email;
    private List<In_Cart> inCart;
}
