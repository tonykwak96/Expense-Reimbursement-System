package com.example.EmailApplication.Repo;

import com.example.EmailApplication.Models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepo extends JpaRepository<Email, Integer> {
    
}
