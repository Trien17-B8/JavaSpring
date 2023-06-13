package com.example.asm.service.Impl;

import com.example.asm.models.ChiTietSanPham;
import com.example.asm.repository.ISanPhamRepository;
import com.example.asm.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SanPhamServiceImpl implements ISanPhamService {

    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> listAllPagin(int pageNumber) {
        Pageable pageable = PageRequest.of(
                pageNumber - 1,
                4
        );
        return sanPhamRepository.findAll(pageable);
    }


    @Override
    public ChiTietSanPham save(ChiTietSanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }


    @Override
    public void delete(String id) {
        ChiTietSanPham chiTietSanPham = sanPhamRepository.findById(id).get();
        sanPhamRepository.delete(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham detail(String id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public ChiTietSanPham update(String id, ChiTietSanPham sanPham) {
        ChiTietSanPham idSP  = sanPhamRepository.findById(id).get();
        idSP.setTenSP(sanPham.getTenSP());
        idSP.setNhaSanXuat(sanPham.getNhaSanXuat());
        idSP.setSoLuongTon(sanPham.getSoLuongTon());
        idSP.setMoTa(sanPham.getMoTa());
        idSP.setGiaBan(sanPham.getGiaBan());
        return sanPhamRepository.save(idSP);
    }

    @Override
    public List<ChiTietSanPham> search(String keyword) {
        return sanPhamRepository.findByTenSPContains(keyword);
    }

    @Override
    public List<ChiTietSanPham> searchPrice(BigDecimal min, BigDecimal max) {
        return sanPhamRepository.findByGiaBanBetween(min, max);
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return sanPhamRepository.findById(id).get();
    }


}
