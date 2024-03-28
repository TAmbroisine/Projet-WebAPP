package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.InCartDto;
import com.takima.backskeleton.models.In_Cart;
import com.takima.backskeleton.services.InCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("inCart")
@RestController
@RequiredArgsConstructor
public class InCartController {
    private final InCartService inCartService;
    @GetMapping("")
    public List<In_Cart> listInCarts() {
        return inCartService.findAll();
    }

    @GetMapping("/{id}")
    public In_Cart getInCartById(@PathVariable Long id) {
        return inCartService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInCart(@PathVariable Long id) {
        inCartService.deleteById(id);
    }

    @PostMapping("")
    public void addInCart(@RequestBody InCartDto inCartDto) {
        inCartService.addInCart(inCartDto);
    }

    @PostMapping("/{id}")
    public void updateInCart(@RequestBody InCartDto inCartDto, @PathVariable Long id) {
        inCartService.updateInCart(inCartDto, id);
    }
}
