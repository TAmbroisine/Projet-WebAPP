package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.MajorDao;
import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MajorService {
    private final MajorDao majorDao;
    public List<Major> findAll() {
        Iterable<Major> it = majorDao.findAll();
        List <Major> majors = new ArrayList<>();
        it.forEach(majors::add);
        return majors;
    }

    public List<Buyer> getBuyersOfMajor(Long id) {
        return majorDao.getAllBuyersFromMajor(id);
    }
}
