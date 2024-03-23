package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.SellerDao;
import com.takima.backskeleton.models.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SellerService {
    private final SellerDao sellerDao;

    public List<Seller> findAll() {
        return sellerDao.findAll();
    }
}
