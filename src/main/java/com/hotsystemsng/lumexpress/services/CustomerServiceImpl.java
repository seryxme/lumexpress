package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateCustomerDetail;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.LoginResponse;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public String completeProfile(UpdateCustomerDetail updateCustomerDetail) {
        return null;
    }
}
