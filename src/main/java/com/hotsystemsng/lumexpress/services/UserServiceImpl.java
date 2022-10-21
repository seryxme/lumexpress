package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.LoginResponse;
import com.hotsystemsng.lumexpress.data.models.LumExpressUser;
import com.hotsystemsng.lumexpress.data.repositories.AdminRepository;
import com.hotsystemsng.lumexpress.data.repositories.CustomerRepository;
import com.hotsystemsng.lumexpress.data.repositories.VendorRepository;
import com.hotsystemsng.lumexpress.exceptions.UserNotFoundException;
import com.hotsystemsng.lumexpress.services.notification.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final VendorRepository vendorRepository;

    @Override
    public LoginResponse login(LoginRequest request) {
        var foundCustomer = customerRepository.findByEmail(request.getEmail());
        if (foundCustomer.isPresent() && foundCustomer.get().getPassword().equals(request.getPassword()))
            return buildSuccessfulLoginResponse(foundCustomer.get());

        var foundAdmin = adminRepository.findByEmail(request.getEmail());
        if (foundAdmin.isPresent() && foundAdmin.get().getPassword().equals(request.getPassword()))
            return buildSuccessfulLoginResponse(foundAdmin.get());

        var foundVendor = vendorRepository.findByEmail(request.getEmail());
        if (foundVendor.isPresent() && foundVendor.get().getPassword().equals(request.getPassword()))
            return buildSuccessfulLoginResponse(foundVendor.get());

        return LoginResponse.builder()
                .code(400)
                .message("Login failed. Bad credentials.")
                .build();
    }

    @Override
    public LumExpressUser getUserByUsername(String email) {
        var foundCustomer = customerRepository.findByEmail(email);
        if (foundCustomer.isPresent()) return foundCustomer.get();

        var foundAdmin = adminRepository.findByEmail(email);
        if (foundAdmin.isPresent()) return foundAdmin.get();

        var foundVendor = vendorRepository.findByEmail(email);
        if (foundVendor.isPresent()) return foundVendor.get();

        throw new UserNotFoundException("No such user!");
    }

    private LoginResponse buildSuccessfulLoginResponse(LumExpressUser user) {
        return LoginResponse.builder()
                .code(200)
                .message("Login successful.")
                .build();
    }
}
