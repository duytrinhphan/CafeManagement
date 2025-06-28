package com.viettridao.cafe.controller;

import com.viettridao.cafe.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final TaiKhoanService taikhoanService;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Onii-chan");
        return "home";
    }

}
