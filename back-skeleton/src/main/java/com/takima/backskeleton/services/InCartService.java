package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.InCartDao;
import com.takima.backskeleton.DTO.InCartDto;
import com.takima.backskeleton.DTO.InCartMapper;
import com.takima.backskeleton.models.In_Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InCartService {
    private final InCartDao inCartDao;

    public List<In_Cart> findAll() {
        Iterable<In_Cart> it = inCartDao.findAll();
        List <In_Cart> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public In_Cart getById(Long id) {
        return inCartDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        inCartDao.deleteById(id);
    }

    @Transactional
    public void addInCart(InCartDto inCartDto) {
        In_Cart inCart;
        try {
            inCart = InCartMapper.fromDto(inCartDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with InCart image", e);
        }

        inCartDao.save(inCart);
    }

    @Transactional
    public void updateInCart(InCartDto inCartDto, Long id) {
        inCartDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("InCart doesn't exist"));
        In_Cart inCart;
        try {
            inCart = InCartMapper.fromDto(inCartDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with InCart image", e);
        }
        inCartDao.save(inCart);
    }

}
