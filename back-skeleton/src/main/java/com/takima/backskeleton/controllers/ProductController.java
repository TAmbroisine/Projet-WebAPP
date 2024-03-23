package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Product;
import com.takima.backskeleton.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("Product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    //private final ProductService productService;
}
