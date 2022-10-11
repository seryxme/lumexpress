package com.hotsystemsng.lumexpress.data.repositories;

import com.hotsystemsng.lumexpress.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
