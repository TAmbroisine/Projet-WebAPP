package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Buyer;

import java.io.IOException;

public class BuyerMapper {
    public static Buyer fromDto(BuyerDto dto, Long id) throws IOException {
        return new Buyer.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .inCart(dto.getInCart())
                .build();
    }

    public static BuyerDto toDto (Buyer buyer){
        return BuyerDto.builder()
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .email(buyer.getEmail())
                .inCart(buyer.getInCart())
                .build();
    }
}
