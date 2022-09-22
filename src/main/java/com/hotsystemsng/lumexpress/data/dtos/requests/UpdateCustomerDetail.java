package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerDetail {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String imageUrl;
    private int buildingNumber;
    private String street;
    private String city;
    private String state;
    private String country;
}
