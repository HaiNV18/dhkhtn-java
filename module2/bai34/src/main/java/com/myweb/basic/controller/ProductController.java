package com.myweb.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/demo/unit1_1")
    public String unit1_1() {
        return "unit1_1";
    }
}
