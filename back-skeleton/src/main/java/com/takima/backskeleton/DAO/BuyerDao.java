package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerDao extends JpaRepository<Buyer, Long> {
    @Query("SELECT s FROM Buyer s JOIN s.inCarts c WHERE c.id= :sellerId AND s.major.id = :majorId ")
    List<Buyer> findByMajorIdAndSellerId(int majorId, int sellerId);
}
