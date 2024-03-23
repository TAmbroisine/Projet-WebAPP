package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.BuyerDao;
import com.takima.backskeleton.DTO.BuyerDto;
import com.takima.backskeleton.DTO.BuyerMapper;
import com.takima.backskeleton.models.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BuyerService {
    private final BuyerDao buyerDao;

    public List<Buyer> findAll() {
        Iterable<Buyer> it = buyerDao.findAll();
        List <Buyer> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Buyer getById(Long id) {
        return buyerDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        buyerDao.deleteById(id);
    }

    @Transactional
    public void addBuyer(BuyerDto buyerDto) {
        Buyer buyer;
        try {
            buyer = BuyerMapper.fromDto(buyerDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Buyer image", e);
        }

        buyerDao.save(buyer);
    }

    @Transactional
    public void updateBuyer(BuyerDto buyerDto, Long id) {
        buyerDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Buyer doesn't exist"));
        Buyer buyer;
        try {
            buyer = BuyerMapper.fromDto(buyerDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Buyer image", e);
        }
        buyerDao.save(buyer);
    }

    public List<Buyer> searchByMajorAndSeller(int majorId, int sellerId) {
        return buyerDao.findByMajorIdAndSellerId(majorId, sellerId);
    }
}
