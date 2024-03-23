package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorDao extends JpaRepository<Major, Long> {
    @Query("SELECT m.buyers FROM Major m WHERE m.id= :majorId")
    List<Buyer> getAllBuyersFromMajor(Long majorId);
}
