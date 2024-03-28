package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ProductDto;
import com.takima.backskeleton.models.Product;
import com.takima.backskeleton.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("")
    public List<Product> listProducts(@RequestParam(required = false) Integer sellerId) {
        if (sellerId !=null) {
            return productService.searchBySeller(sellerId);
        }
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @PostMapping("/{id}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        productService.updateProduct(productDto, id);
    }
}
