package com.viettridao.cafe.common;

import com.viettridao.cafe.model.AccountEntity;
import com.viettridao.cafe.service.account.IAccountService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalModelAttribute {

    private final IAccountService accountService;

    @ModelAttribute("currentPath")
    public String populateCurrentPath(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @ModelAttribute("user")
    public AccountEntity addUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()
                && !(auth instanceof AnonymousAuthenticationToken)) {
            return (AccountEntity) auth.getPrincipal();
        }
        return null;
    }

    @ModelAttribute("user")
    public AccountEntity currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof AccountEntity) {
            return (AccountEntity) auth.getPrincipal();
        }
        return null;
    }


}
