package com.example.asm.service.Impl;

import com.example.asm.service.IGioHangService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class GioHangServiceImpl implements IGioHangService {
    private Map<String, Integer> sanPhamTrongGio = new HashMap<>();


    private Map<String, Integer> sanPhamTrongGio() {
        return sanPhamTrongGio;
    }


    public void setSanPhamTrongGio(Map<String, Integer> sanPhamTrongGio) {
        this.sanPhamTrongGio = sanPhamTrongGio;
    }

    @Override
    public Map<String, Integer> getSanPhamTrongGio() {

        return sanPhamTrongGio;
    }

    @Override
    public Map<String, Integer> laySanPhamTrongGio(){
        return getSanPhamTrongGio();
    }


    @Override
    public void themSanPhamVaoGio(String maSanPham, Integer soLuongChoVao){
        Map<String, Integer> sanPhamTrongGio = getSanPhamTrongGio();
        if(sanPhamTrongGio.containsKey(maSanPham)){
            // nếu có rồi thì cộng dồn

            //Lấy số lượng sản phẩm hiện có
            Integer soLuongHienCo = sanPhamTrongGio.get(maSanPham);
            // Cộng dồn
            Integer soLuongMoi = soLuongHienCo + soLuongChoVao;

            //Cập nhật lại giỏ hàng
            sanPhamTrongGio.put(maSanPham, soLuongMoi);
        }else {
            //Sản phẩm không có trong giỏ, thêm mới vào
            sanPhamTrongGio.put(maSanPham, soLuongChoVao);
        }
    }
}
