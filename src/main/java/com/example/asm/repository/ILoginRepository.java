package com.example.asm.repository;

import com.example.asm.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Account, String> {
}
