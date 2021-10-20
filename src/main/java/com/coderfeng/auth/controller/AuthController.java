package com.coderfeng.auth.controller;

import com.coderfeng.auth.dto.AuthRequestDTO;
import com.coderfeng.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:04
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @Resource
    private AuthService authService;

    @GetMapping("/auth")
    public String auth(AuthRequestDTO request){
        Boolean auth = authService.auth(request);
        return "res + " + auth;
    }
}
