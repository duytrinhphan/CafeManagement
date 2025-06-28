package com.viettridao.cafe.repository;

import com.viettridao.cafe.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {

    @Query("select TenDangNhap, MatKhau from TaiKhoan t where TenDangNhap = :username and MatKhau = :password")
    boolean login(@Param("username") String username, @Param("password") String password);
}
