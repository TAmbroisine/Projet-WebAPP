package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.DeliveryDetails;

import java.io.IOException;

public class DeliveryDetailsMapper {
    public static DeliveryDetails fromDto(DeliveryDetailsDto dto, Long id) throws IOException {
        return new DeliveryDetails.Builder()
                .id(id)
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .postCode(dto.getPostCode())
                .country(dto.getCountry())
                .phoneNumber(dto.getPhoneNumber())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .buyer(dto.getBuyer())
                .city(dto.getCity())
                .build();
    }

    public static DeliveryDetailsDto toDto (DeliveryDetails deliveryDetails){
        return DeliveryDetailsDto.builder()
                .addressLine1(deliveryDetails.getAddressLine1())
                .addressLine2(deliveryDetails.getAddressLine2())
                .postCode(deliveryDetails.getPostCode())
                .country(deliveryDetails.getCountry())
                .phoneNumber(deliveryDetails.getPhoneNumber())
                .firstName(deliveryDetails.getFirstName())
                .lastName(deliveryDetails.getLastName())
                .city(deliveryDetails.getCity())
                .buyer(deliveryDetails.getBuyer())
                .build();
    }
}
