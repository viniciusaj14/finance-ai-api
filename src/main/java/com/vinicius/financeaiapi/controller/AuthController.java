package com.vinicius.financeaiapi.controller;

import com.vinicius.financeaiapi.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login() {
        return jwtService.generateToken("vinicius");
    }
}