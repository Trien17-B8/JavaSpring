package com.example.asm.repository.Impl;

import com.example.asm.models.Account;
import com.example.asm.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRepositoryImpl {
    @Autowired
    private IAccountRepository accountRepository;

    public void addAccount(){
        accountRepository.save(new Account(null,"Ac01", "Đoàn Tiến Triển", "triendoan4432@gmail.com", "triendt", "trien", "KHACH_HANG"));
        accountRepository.save(new Account(null,"Ac02", "Nguyễn Đình Cao", "cao@gmail.com", "tuan", "trien", "ADMIN"));
        accountRepository.save(new Account(null,"Ac03", "Nguyễn Phúc Lâm", "lam@gmail.com", "cao", "trien", "ADMIN"));
        accountRepository.save(new Account(null,"Ac04", "Nguyễn Quốc Tuấn", "tuan@gmail.com", "lam", "trien", "KHACH_HANG"));
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account byId(String id){
        return accountRepository.findAllById(id);
    }

    public Account login(String username, String password){
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
