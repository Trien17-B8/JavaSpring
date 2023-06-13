package com.example.asm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;


@Entity
@Table(name = "chi_tiet_sp")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ChiTietSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "ten_sp", nullable = false)
    private String tenSP;

    @Column(name = "nsx", nullable = false)
    private String nhaSanXuat;

    @Column(name = "mo_ta", nullable = false)
    private String moTa;

    @Column(name = "img",nullable = false)
    private String img;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

}
