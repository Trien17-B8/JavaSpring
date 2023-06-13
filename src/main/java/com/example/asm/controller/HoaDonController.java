package com.example.asm.controller;

import com.example.asm.models.Account;
import com.example.asm.models.ChiTietSanPham;
import com.example.asm.models.HoaDon;
import com.example.asm.models.HoaDonChiTiet;
import com.example.asm.models.customer.Top10BanChay;
import com.example.asm.repository.IHoaDonChiTietRepository;
import com.example.asm.repository.IHoaDonRepository;
import com.example.asm.repository.Impl.AccountRepositoryImpl;
import com.example.asm.service.IGioHangService;
import com.example.asm.service.ISanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("product/shop-trien")
public class HoaDonController {

    @Autowired
    private AccountRepositoryImpl accountRepository;

    @Autowired
    private IHoaDonRepository iHoaDonRepository;

    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private HttpSession session;

    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;

    @PostMapping({"/add-bill"})
    public String viewGioHang(Model model,
                              @RequestParam(name = "tenNguoiNhan") String tenNguoiNhan,
                              @RequestParam(name = "diaChi") String diaChi,
                              @RequestParam(name = "sdt") String sdt) {
        Account account = (Account) session.getAttribute("account");
        Date date = new Date();
        String maHD = "HD"+Math.random();
        HoaDon hoaDon = new HoaDon(null,account,maHD, new java.sql.Date(date.getTime()),new java.sql.Date(date.getTime()),new java.sql.Date(date.getTime()),new java.sql.Date(date.getTime()), 0, tenNguoiNhan, diaChi, sdt);
        iHoaDonRepository.save(hoaDon);
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
            chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon()-soLuongSanPhamTrongGioHang);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(null, hoaDon, chiTietSP, soLuongSanPhamTrongGioHang, BigDecimal.valueOf((long) chiTietSP.getGiaBan().intValue() * value));
            hoaDonChiTietRepository.save(hoaDonChiTiet);

        }
//        System.out.println(sanPhamTrongGio.size());
        model.addAttribute("sanPhamTrongGio", danhSachGH);
        model.addAttribute("soSPGH", sanPhamTrongGio.size());
        model.addAttribute("soLuong", soLuongSanPhamTrongGioHang);
        model.addAttribute("tongTienHang", tongTienHang);
        model.addAttribute("hoaDon", "Thanh Cong");
        return "bill";
    }

    @GetMapping(value = {"/manager/hoa-don"})
    public String searchByName(Model model) {
        List<HoaDon> hoaDonList = iHoaDonRepository.findAll();
        System.out.println(hoaDonChiTietRepository.top10SPBanChay());
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.findAll();
        model.addAttribute("hoaDon", hoaDonList);
        model.addAttribute("hoaDonChiTiet", hoaDonChiTietList);
        return "hoa-don";
    }

    @GetMapping(value = {"/thong-ke/san-pham"})
    public String thongKe(Model model) {
        List<Top10BanChay> thongKe = hoaDonChiTietRepository.top10SPBanChay();
        System.out.println(hoaDonChiTietRepository.top10SPBanChay());
        model.addAttribute("thongKe", thongKe);
        return "thong-ke";
    }
}
