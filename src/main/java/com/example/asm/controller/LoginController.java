package com.example.asm.controller;

import com.example.asm.models.Account;
import com.example.asm.repository.IAccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
@RequestMapping("product/shop-trien")
public class LoginController {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/login")
    public String viewLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        Account account = accountRepository.findByUsernameAndPassword(username, password);
        session.setAttribute("account", account);
        if (account != null) {
//            model.addAttribute("thongBao", "Đăng Nhập Thành Công");
            return "redirect:/product/shop-trien/trang-chu";
        } else {
            model.addAttribute("thongBao", "Đăng Nhập Thất Bại");
            model.addAttribute("username", username);
            model.addAttribute("passs", password);
            return "login";
        }

    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/product/shop-trien/trang-chu";
    }
}
