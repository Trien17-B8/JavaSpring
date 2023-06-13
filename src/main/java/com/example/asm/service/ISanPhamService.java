package com.example.asm.service;

import com.example.asm.models.ChiTietSanPham;
import org.springframework.data.domain.Page;
import java.math.BigDecimal;
import java.util.List;

public interface ISanPhamService {
    List<ChiTietSanPham> getAll();

    Page<ChiTietSanPham> listAllPagin(int pageNumber);

    ChiTietSanPham save(ChiTietSanPham sanPham);

    void delete(String id);

    ChiTietSanPham detail(String id);

    ChiTietSanPham update(String id, ChiTietSanPham sanPham);

    List<ChiTietSanPham> search(String keyword);

    List<ChiTietSanPham> searchPrice(BigDecimal min, BigDecimal max);

    ChiTietSanPham getOne(String id);

}
