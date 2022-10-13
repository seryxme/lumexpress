package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.EmailNotificationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateCustomerDetail;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import com.hotsystemsng.lumexpress.data.models.Address;
import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.models.VerificationToken;
import com.hotsystemsng.lumexpress.data.repositories.CustomerRepository;
import com.hotsystemsng.lumexpress.exceptions.UserNotFoundException;
import com.hotsystemsng.lumexpress.services.notification.EmailNotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper();
    private final CartService cartService;
    private final EmailNotificationService emailNotificationService;
    private final VerificationTokenService verificationTokenService;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        customer.setCart(new Cart());
        Address customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddress().add(customerAddress);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db::{}", savedCustomer);
        var token = verificationTokenService.createToken(savedCustomer.getEmail());
        emailNotificationService.sendHtmlEmail(buildEmailNotificationRequest(token, savedCustomer.getFirstName()));
        return responseBuilder(savedCustomer);
    }

    private EmailNotificationRequest buildEmailNotificationRequest(VerificationToken token, String firstName) {
        String email = getEmailTemplate();
        String message = null;
        if (email != null) message = String.format(email, firstName,
                "http://localhost:8080/api/v1/customer/verify/" + token.getToken(), token.getToken());
        return EmailNotificationRequest.builder()
                .userEmail(token.getUserEmail())
                .emailBody(message)
                .subject("Welcome")
                .build();
    }

    private String getEmailTemplate() {
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("C:\\Users\\DELL\\IdeaProjects\\lumexpress\\src\\main\\resources\\welcome.txt"))) {
            return bufferedReader.lines().collect(Collectors.joining());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private CustomerRegistrationResponse responseBuilder(Customer customer) {
        return CustomerRegistrationResponse.builder()
                .message("Success!")
                .userId(customer.getId())
                .code(201)
                .build();
    }

    @Override
    public String updateProfile(UpdateCustomerDetail customerDetail) {
        var customerToUpdate = customerRepository.findById(customerDetail.getCustomerId())
                .orElseThrow(()-> new UserNotFoundException(
                        String.format("Customer with ID %d is not found", customerDetail.getCustomerId())));

        mapper.map(customerDetail, customerToUpdate);

        var updateCustomerAddresses = customerToUpdate.getAddress().stream().findFirst();
        log.info("before address update -> {}", updateCustomerAddresses);
        if(updateCustomerAddresses.isPresent()) applyAddressUpdate(customerDetail, updateCustomerAddresses.get());

        customerToUpdate.getAddress().add(updateCustomerAddresses.get());
        Customer savedCustomer = customerRepository.save(customerToUpdate);

        log.info("Updated customer -> {}", customerToUpdate);
        return "Details updated successfully!";
    }

    private void applyAddressUpdate(UpdateCustomerDetail customerDetail, Address address) {
        address.setBuildingNumber(customerDetail.getBuildingNumber());
        address.setStreet(customerDetail.getStreet());
        address.setCity(customerDetail.getCity());
        address.setState(customerDetail.getState());
    }
}
