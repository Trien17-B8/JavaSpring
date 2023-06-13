package com.example.asm.repository;

import com.example.asm.models.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGioHangRepository extends JpaRepository<ChiTietSanPham, String> {
}
