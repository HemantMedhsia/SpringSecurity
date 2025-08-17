package com.hemant.springsecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SecurityTest {
    @GetMapping("public/view")
    public String test(HttpServletRequest request) {
        return "Welcome to <h2>Spring Security</h2>. You are now <h1>Authenticated</h1>." + request.getSession().getId();
    }

    @GetMapping("/open/view")
    public String open(HttpServletRequest request) {
        return "Welcome to <h2>Open Security</h2>. You are now <h1>Able to Inter openly</h1>." + request.getSession().getId();
    }

    @GetMapping("csrf-token/view")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("open/post")
    public String postTesting(@RequestBody String H) {
        return H;
    }
}
