package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateCustomerDetail;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.exceptions.LumExpressException;
import com.hotsystemsng.lumexpress.exceptions.UserNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) throws LumExpressException;
    String updateProfile(UpdateCustomerDetail updateCustomerDetail) throws UserNotFoundException;

    List<Customer> getAllCustomers();
}
