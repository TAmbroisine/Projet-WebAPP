package com.takima.backskeleton.DTO;


import com.takima.backskeleton.models.In_Cart;

import java.io.IOException;

public class InCartMapper {
    public static In_Cart fromDto(InCartDto dto, Long id) throws IOException {
        return new In_Cart.Builder()
                .id(id)
                .products(dto.getProducts())
                .buyer(dto.getBuyer())
                .build();
    }

    public static InCartDto toDto (In_Cart inCart){
        return InCartDto.builder()
                .products(inCart.getProducts())
                .buyer(inCart.getBuyer())
                .build();
    }
}
