package com.example.asm.controller;


import com.example.asm.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/list-all")
public class SanPhamController {

    @Autowired
    private ISanPhamService sanPhamService;

    public String view(Model model){
        System.out.println(sanPhamService.getAll());
        return "trang-chu";
    }
}
