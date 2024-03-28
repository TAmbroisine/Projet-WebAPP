package com.takima.backskeleton.services;


import com.takima.backskeleton.DAO.DeliveryDetailsDAO;
import com.takima.backskeleton.DTO.DeliveryDetailsDto;
import com.takima.backskeleton.DTO.DeliveryDetailsMapper;
import com.takima.backskeleton.models.DeliveryDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DeliveryDetailsService {
    private final DeliveryDetailsDAO deliveryDetailsDao;

    public List<DeliveryDetails> findAll() {
        Iterable<DeliveryDetails> it = deliveryDetailsDao.findAll();
        List <DeliveryDetails> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public DeliveryDetails getById(Long id) {
        return deliveryDetailsDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        deliveryDetailsDao.deleteById(id);
    }

    @Transactional
    public void addDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto) {
        DeliveryDetails deliveryDetails;
        try {
            deliveryDetails = DeliveryDetailsMapper.fromDto(deliveryDetailsDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with DeliveryDetails image", e);
        }

        deliveryDetailsDao.save(deliveryDetails);
    }

    @Transactional
    public void updateDeliveryDetails(DeliveryDetailsDto deliveryDetailsDto, Long id) {
        deliveryDetailsDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("DeliveryDetails doesn't exist"));
        DeliveryDetails deliveryDetails;
        try {
            deliveryDetails = DeliveryDetailsMapper.fromDto(deliveryDetailsDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with DeliveryDetails image", e);
        }
        deliveryDetailsDao.save(deliveryDetails);
    }

}
