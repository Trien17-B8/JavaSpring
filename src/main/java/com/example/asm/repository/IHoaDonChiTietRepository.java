package com.example.asm.repository;

import com.example.asm.models.ChiTietSanPham;
import com.example.asm.models.HoaDonChiTiet;
import com.example.asm.models.customer.Top10BanChay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, String> {

    String str_AnyFindByName = "SELECT TOP 10 sum(so_luong) as 'tong', id_chi_tiet_sp as 'idsanpham'\n" +
            "    FROM hoa_don_chi_tiet\n" +
            "    group by id_chi_tiet_sp\n" +
            "    order by sum(so_luong) DESC";

    @Query(value = str_AnyFindByName, nativeQuery = true )
    List<Top10BanChay> top10SPBanChay();

    String str_hang_ton = "SELECT TOP 10 sum(so_luong) as 'tong', id_chi_tiet_sp as 'idsanpham'\n" +
            "    FROM hoa_don_chi_tiet\n" +
            "    group by id_chi_tiet_sp\n" +
            "    order by sum(so_luong) DESC";

    @Query(value = str_hang_ton, nativeQuery = true )
    List<Top10BanChay> top10SPton();
}
