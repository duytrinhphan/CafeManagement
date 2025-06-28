package com.viettridao.cafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "layout";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }
}
