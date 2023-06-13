package com.example.asm.controller;

import com.example.asm.models.ChiTietSanPham;
import com.example.asm.repository.ISanPhamRepository;
import com.example.asm.service.IGioHangService;
import com.example.asm.service.ISanPhamService;
import com.example.asm.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product/shop-trien")
public class TrangChuController {
    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Autowired
    private UploadFile uploadFileUtil;


    @Autowired
    private IGioHangService gioHangService;

    @GetMapping("/trang-chu")
    public String viewTrangChu(Model model){
        Map<String, Integer> sanPhamTrongGio = gioHangService.laySanPhamTrongGio();
        model.addAttribute("soSPGH", sanPhamTrongGio.size());
        return danhSachByPageNumber(model, 1);
    }

    @GetMapping(value = "/trang-chu/page/{pageNumber}")
    public String danhSachByPageNumber(Model model, @PathVariable(name = "pageNumber") int currentPage) {

        Page<ChiTietSanPham> page = sanPhamService.listAllPagin(currentPage);
        Map<String, Integer> sanPhamTrongGio = gioHangService.laySanPhamTrongGio();
        model.addAttribute("soSPGH", sanPhamTrongGio.size());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listSanPham", page.getContent());
        return "trang-chu";
    }

    @GetMapping("/product-manager")
    public String viewQuanLySanPham(Model model){
        List<ChiTietSanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("listSanPham", sanPhamList);
        return "quan-ly-sp";
    }

    @PostMapping("/new")
    public String save(Model model,
                       @RequestParam(name = "nhaSanXuat") String nhaSanXuat,
                       @RequestParam(name = "tenSP") String tenSP,
                       @RequestParam(name = "moTa") String moTa,
                       @RequestParam(name = "img") MultipartFile uploadFile,
                       @RequestParam(name = "soLuongTon") Integer soLuongTon,
                       @RequestParam(name = "giaBan") BigDecimal giaBan) throws IOException {
        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                .img(uploadFile.getOriginalFilename())
                .tenSP(tenSP)
                .nhaSanXuat(nhaSanXuat)
                .soLuongTon(soLuongTon)
                .moTa(moTa)
                .giaBan(giaBan)
                .build();
        uploadFileUtil.handerUpLoadFile(uploadFile);
        sanPhamService.save(chiTietSanPham);
        model.addAttribute("listSanPham", sanPhamService.getAll() );
        return "redirect:/product/shop-trien/product-manager";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") String id){
        sanPhamService.delete(id);
        return "redirect:/product/shop-trien/product-manager";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable("id") String id){
        model.addAttribute("detail", sanPhamService.detail(id));
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateId(Model model,@PathVariable("id") String id){
        model.addAttribute("listSanPham", sanPhamService.detail(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @RequestParam(name = "id") String id,
                         @RequestParam(name = "nhaSanXuat") String nhaSanXuat,
                         @RequestParam(name = "tenSP") String tenSP,
                         @RequestParam(name = "moTa") String moTa,
//                         @RequestParam(name = "img") MultipartFile uploadFile,
                         @RequestParam(name = "soLuongTon") Integer soLuongTon,
                         @RequestParam(name = "giaBan") BigDecimal giaBan){
        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
//                .img(String.valueOf(uploadFile.getOriginalFilename()))
                .tenSP(tenSP)
                .nhaSanXuat(nhaSanXuat)
                .soLuongTon(soLuongTon)
                .moTa(moTa)
                .giaBan(giaBan)
                .build();
//        uploadFileUtil.handerUpLoadFile(uploadFile);
        sanPhamService.update(id, chiTietSanPham);
        model.addAttribute("listSanPham", sanPhamService.getAll() );
        return "redirect:/product/shop-trien/product-manager";
    }


    @GetMapping(value = {"/trang-chu/tim-kiem"})
    public String searchByName(@RequestParam(name = "tenSP") String tenSP, Model model) {
        List<ChiTietSanPham> chiTietSanPhamTimKiem;
        if (tenSP.isEmpty()) {
            chiTietSanPhamTimKiem = sanPhamService.getAll();
            model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
        } else {
            if (sanPhamService.search(tenSP).isEmpty()) {
                model.addAttribute("err", "Không tìm thấy đối tượng");
            } else {
                chiTietSanPhamTimKiem = sanPhamService.search(tenSP);
                model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
            }
        }
        return "trang-chu";
    }

    @GetMapping(value = {"/product-manager/tim-kiem"})
    public String searchProductManager(@RequestParam(name = "tenSP") String tenSP, Model model) {
        List<ChiTietSanPham> chiTietSanPhamTimKiem;
        if (tenSP.isEmpty()) {
            chiTietSanPhamTimKiem = sanPhamService.getAll();
            model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
        } else {
            if (sanPhamService.search(tenSP).isEmpty()) {
                model.addAttribute("err", "Không tìm thấy đối tượng");
            } else {
                chiTietSanPhamTimKiem = sanPhamService.search(tenSP);
                model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
            }
        }
        return "quan-ly-sp";
    }

    @GetMapping(value = {"/trang-chu/tim-kiem-price"})
    public String searchByPrice(@RequestParam(name = "min") BigDecimal min, @RequestParam(name = "max") BigDecimal max, Model model) {
        List<ChiTietSanPham> chiTietSanPhamTimKiem;
        if (min==null || max == null) {
            chiTietSanPhamTimKiem = sanPhamService.getAll();
            model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
        } else {
            if (sanPhamService.searchPrice(min, max).isEmpty()) {
                model.addAttribute("err", "Không tìm thấy đối tượng");
            } else {
                chiTietSanPhamTimKiem = sanPhamService.searchPrice(min, max);
                model.addAttribute("listSanPham", chiTietSanPhamTimKiem);
            }
        }
        return "trang-chu";
    }

    @GetMapping("/cart")
    public String viewAddToCart(){
        return "cart";
    }

    @GetMapping("/bill")
    public String viewBill(){
        return "bill";
    }

    @GetMapping("/detail")
    public String viewDetail(){
        return "detail";
    }

}
