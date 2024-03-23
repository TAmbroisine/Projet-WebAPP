package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Buyer;
import com.takima.backskeleton.services.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("majors")
@RestController
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;

    @GetMapping("")
    public List<Major> findAll() {
        return majorService.findAll();
    }

    @GetMapping("/{id}/buyers")
    public List<Buyer> getBuyersOfMajor(@PathVariable Long id) {
        return majorService.getBuyersOfMajor(id);
    }
}
