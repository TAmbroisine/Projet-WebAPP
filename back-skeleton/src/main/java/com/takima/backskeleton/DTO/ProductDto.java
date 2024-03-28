package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.In_Cart;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductDto {
    private String name;
    private float price;
    private String category;
    private List<In_Cart> inCarts;
}
