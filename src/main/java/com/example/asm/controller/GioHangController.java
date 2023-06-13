package com.example.asm.controller;

import com.example.asm.models.Account;
import com.example.asm.models.ChiTietSanPham;
import com.example.asm.repository.IAccountRepository;
import com.example.asm.repository.Impl.AccountRepositoryImpl;
import com.example.asm.service.IGioHangService;
import com.example.asm.service.ISanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("product/shop-trien")
public class GioHangController {

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private AccountRepositoryImpl accountRepository;

    @Autowired
    private HttpSession session;

    @GetMapping({"/cart-all"})
    public String viewGioHang(Model model){
        Map<String, Integer> sanPhamTrongGio = gioHangService.laySanPhamTrongGio();
        Set<String> key = sanPhamTrongGio.keySet();
        Map<ChiTietSanPham,Integer> danhSachGH = new HashMap<>();
        int tongTienHang  = 0;
        int soLuongSanPhamTrongGioHang = 0;
        for (String keySP: key) {
            Integer value = sanPhamTrongGio.get(keySP);
            ChiTietSanPham chiTietSP = sanPhamService.getOne(keySP);
            danhSachGH.put(chiTietSP,value);
            tongTienHang += chiTietSP.getGiaBan().intValue()* value;
            soLuongSanPhamTrongGioHang += value;
        }
//        System.out.println(sanPhamTrongGio.size());
        model.addAttribute("sanPhamTrongGio", danhSachGH);
        model.addAttribute("soSPGH", sanPhamTrongGio.size());
        model.addAttribute("soLuong", soLuongSanPhamTrongGioHang);
        model.addAttribute("tongTienHang", tongTienHang);
        return "cart";
    }

    @RequestMapping("/add/{maSanPham}")
    public String themSanPhamVaoGio(@PathVariable(name = "maSanPham") String sanPhamId){
        gioHangService.themSanPhamVaoGio(sanPhamId, 1);
        return "redirect:/product/shop-trien/cart-all";
    }

}
