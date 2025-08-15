package com.hemant.springsecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SecurityTest {
    @GetMapping
    public String test(HttpServletRequest request) {
        return "Welcome to <h2>Spring Security</h2>. You are now <h1>Authenticated</h1>." + request.getSession().getId();
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping
    public String postTesting(@RequestBody String H) {
        return H;
    }
}
