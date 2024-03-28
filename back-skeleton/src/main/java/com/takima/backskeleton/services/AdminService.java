package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.AdminDao;
import com.takima.backskeleton.DTO.AdminDto;
import com.takima.backskeleton.DTO.AdminMapper;
import com.takima.backskeleton.models.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminDao adminDao;

    public List<Admin> findAll() {
        Iterable<Admin> it = adminDao.findAll();
        List <Admin> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Admin getById(Long id) {
        return adminDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        adminDao.deleteById(id);
    }

    @Transactional
    public void addAdmin(AdminDto adminDto) {
        Admin admin;
        try {
            admin = AdminMapper.fromDto(adminDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Admin image", e);
        }

        adminDao.save(admin);
    }

    @Transactional
    public void updateAdmin(AdminDto adminDto, Long id) {
        adminDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin doesn't exist"));
        Admin admin;
        try {
            admin = AdminMapper.fromDto(adminDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Admin image", e);
        }
        adminDao.save(admin);
    }

}
