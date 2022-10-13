package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRegistrationRequest {
    @NotNull (message = "Country cannot be null.")
    @NotEmpty (message = "Country field cannot be empty.")
    private String country;

    @NotNull (message = "Name cannot be null.")
    @NotEmpty (message = "Name field cannot be empty.")
    private String firstName;

    @NotNull (message = "Email cannot be null.")
    @Email (message = "Email is invalid.", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @NotEmpty (message = "Email field cannot be empty.")
    private String email;

    @NotNull (message = "Password cannot be null.")
    @NotEmpty (message = "Password field cannot be empty.")
    private String password;
}
