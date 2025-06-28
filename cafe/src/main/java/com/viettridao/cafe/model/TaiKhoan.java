package com.viettridao.cafe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer MaTaiKhoan;

    private String TenDangNhap;

    private String MatKhau;

    private String QuyenHan;

    private String Anh;
}
