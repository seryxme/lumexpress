package com.hotsystemsng.lumexpress.data.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class LumExpressUser {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String imageUrl;
    private boolean isEnabled;
}
