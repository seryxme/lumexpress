package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateCustomerDetail;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.LoginResponse;
import com.hotsystemsng.lumexpress.data.models.Address;
import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final CartService cartService;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        customer.setCart(new Cart());
        Address customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddress().add(customerAddress);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db::{}", savedCustomer);

        return responseBuilder(savedCustomer);
    }

    private CustomerRegistrationResponse responseBuilder(Customer customer) {
        return CustomerRegistrationResponse.builder()
                .message("Success!")
                .userId(customer.getId())
                .code(201)
                .build();
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
