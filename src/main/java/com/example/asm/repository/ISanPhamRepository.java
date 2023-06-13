package com.example.asm.repository;

import com.example.asm.models.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ISanPhamRepository extends JpaRepository<ChiTietSanPham, String> {

    List<ChiTietSanPham> findByTenSPContains(String keyword);

    List<ChiTietSanPham> findByGiaBanBetween(BigDecimal min, BigDecimal max);
}
