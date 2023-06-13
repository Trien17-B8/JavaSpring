package com.example.asm.service;

import java.util.Map;

public interface IGioHangService {

    Map<String, Integer> getSanPhamTrongGio();

    Map<String, Integer> laySanPhamTrongGio();

    abstract void themSanPhamVaoGio(String maSanPham, Integer soLuongChoVao);

}
