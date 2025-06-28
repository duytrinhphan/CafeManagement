package com.viettridao.cafe.service.impl;

import com.viettridao.cafe.repository.TaiKhoanRepository;
import com.viettridao.cafe.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public boolean login(String username, String password) {
        return taiKhoanRepository.login(username, password);
    }
}
