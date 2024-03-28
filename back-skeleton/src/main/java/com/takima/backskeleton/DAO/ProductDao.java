package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Buyer;
import com.takima.backskeleton.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.seller s WHERE s.id= :sellerId ")
    List<Product> findBySellerId(int sellerId);
}
