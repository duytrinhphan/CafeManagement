package com.viettridao.cafe.controller;

import com.viettridao.cafe.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        RedirectAttributes redirectAttributes) {
        try {
            boolean result = authService.login(username, password);
            if (result) {
                redirectAttributes.addFlashAttribute("success", "Đăng nhập thành công!");
                return "redirect:/home";
            }
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/auth/login";
        }
        redirectAttributes.addFlashAttribute("error", "Đăng nhập thất bại");
        return "redirect:/auth/login";
    }
}
