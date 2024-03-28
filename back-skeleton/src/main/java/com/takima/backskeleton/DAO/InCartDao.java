package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Buyer;
import com.takima.backskeleton.models.In_Cart;
import com.takima.backskeleton.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InCartDao extends JpaRepository<In_Cart, Long> {

    @Query("SELECT p FROM In_Cart ic JOIN ic.product p WHERE ic.buyer.id = :buyerid")
    List<Product> getCartForBuyer(int buyerId);
}
