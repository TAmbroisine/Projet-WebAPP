package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.ProductDao;
import com.takima.backskeleton.DTO.ProductDto;
import com.takima.backskeleton.DTO.ProductMapper;
import com.takima.backskeleton.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<Product> findAll() {
        Iterable<Product> it = productDao.findAll();
        List <Product> products = new ArrayList<>();
        it.forEach(products::add);
        return products ;
    }

    public Product getById(Long id) {
        return productDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    @Transactional
    public void addProduct(ProductDto productDto) {
        Product product;
        try {
            product = ProductMapper.fromDto(productDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Product image", e);
        }

        productDao.save(product);
    }

    @Transactional
    public void updateProduct(ProductDto productDto, Long id) {
        productDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product doesn't exist"));
        Product product;
        try {
            product = ProductMapper.fromDto(productDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Product image", e);
        }
        productDao.save(product);
    }

    public List<Product> searchBySeller(Integer sellerId) {
        return productDao.findBySellerId(sellerId);
    }
}
