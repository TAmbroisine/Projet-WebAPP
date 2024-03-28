package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Buyer;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeliveryDetailsDto {
    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private String country;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private Buyer buyer;
    private String city;
}
