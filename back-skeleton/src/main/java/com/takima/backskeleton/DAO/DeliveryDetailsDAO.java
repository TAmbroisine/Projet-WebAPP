package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Admin;
import com.takima.backskeleton.models.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDetailsDAO extends JpaRepository<DeliveryDetails, Long> {

}
