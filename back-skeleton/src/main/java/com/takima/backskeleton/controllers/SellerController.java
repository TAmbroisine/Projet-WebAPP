package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Seller;
import com.takima.backskeleton.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("sellers")
@RestController
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("")
    public List<Seller> getAllSellers() {
        return sellerService.findAll();
    }
}
