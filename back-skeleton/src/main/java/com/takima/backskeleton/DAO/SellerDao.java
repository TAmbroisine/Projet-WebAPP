package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDao extends JpaRepository<Seller, Long> {
}
