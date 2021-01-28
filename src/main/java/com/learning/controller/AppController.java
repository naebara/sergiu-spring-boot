package com.learning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${nae.code}")
    private String code;

    @GetMapping
    public String getAppName() {
        return appName + " " + code;
    }
}
