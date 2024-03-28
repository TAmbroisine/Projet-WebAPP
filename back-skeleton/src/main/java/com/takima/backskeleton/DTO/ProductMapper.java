package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Product;

import java.io.IOException;

public class ProductMapper {
    public static Product fromDto(ProductDto dto, Long id) throws IOException {
        return new Product.Builder()
                .id(id)
                .name(dto.getName())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .inCarts(dto.getInCarts())
                .build();
    }

    public static ProductDto toDto (Product product){
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .inCarts(product.getInCarts())
                .build();
    }
}
