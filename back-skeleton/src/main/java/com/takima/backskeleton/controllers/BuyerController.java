package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.BuyerDto;
import com.takima.backskeleton.models.Buyer;
import com.takima.backskeleton.services.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("buyer")
@RestController
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;
    @GetMapping("")
    public List<Buyer> listBuyers() {
        return buyerService.findAll();
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable Long id) {
        return buyerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.deleteById(id);
    }

    @PostMapping("")
    public void addBuyer(@RequestBody BuyerDto buyerDto) {
        buyerService.addBuyer(buyerDto);
    }

    @PostMapping("/{id}")
    public void updateBuyer(@RequestBody BuyerDto buyerDto, @PathVariable Long id) {
        buyerService.updateBuyer(buyerDto, id);
    }
}
