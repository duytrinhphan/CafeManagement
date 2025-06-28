package com.viettridao.cafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.viettridao.cafe.dto.request.account.AccountCreateRequest;
import com.viettridao.cafe.dto.request.account.AccountUpdateRequest;
import com.viettridao.cafe.dto.response.profile.ProfileResponse;
import com.viettridao.cafe.service.account.IAccountService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final IAccountService accountService;

    @GetMapping
    public String listAccount(Model model) {
        model.addAttribute("accounts", accountService.getAllAccount());
        return "account/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("account", new AccountCreateRequest());
        return "account/form-create";
    }

    @PostMapping
    public String createAccount(@ModelAttribute("account") AccountCreateRequest request) {
        accountService.createAccount(request);
        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        AccountUpdateRequest updateRequest = accountService.getUpdateForm(id);
        model.addAttribute("account", updateRequest);
        model.addAttribute("accountId", id);
        return "account/form-edit";
    }

    @PostMapping("/{id}")
    public String updateAccount(@PathVariable Integer id, @ModelAttribute("account") AccountUpdateRequest request) {
        accountService.updateAccount(id, request);
        return "redirect:/account";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
        return "redirect:/account";
    }

    @GetMapping("/profile/{id}")
    public String viewAccountProfile(@PathVariable Integer id, Model model) {
        ProfileResponse profile = accountService.getProfileByAccountId(id);
        if (profile == null) {
            throw new RuntimeException("Không tìm thấy hồ sơ cho tài khoản có ID = " + id);
        }
        model.addAttribute("profile", profile);
        return "account/profile";
    }
}
