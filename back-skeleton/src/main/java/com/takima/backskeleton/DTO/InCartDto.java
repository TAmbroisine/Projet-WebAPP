package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Buyer;
import com.takima.backskeleton.models.In_Cart;
import com.takima.backskeleton.models.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class InCartDto {
    private Long id;
    private Buyer buyer;
    private List<Product> products;
}
