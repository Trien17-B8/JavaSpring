package com.example.asm.repository;

import com.example.asm.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, String> {
    Account findAllById(String id);

    Account findByUsernameAndPassword(String username, String password);
}
