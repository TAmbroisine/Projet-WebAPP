package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    @Query("SELECT s FROM Admin s JOIN s.inCarts c WHERE c.id= :sellerId AND s.major.id = :majorId ")
    List<Admin> findByMajorIdAndSellerId(int majorId, int sellerId);
}
