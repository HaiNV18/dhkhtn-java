package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TemplateController {

    private final TemplateEngine templateEngine;

    public TemplateController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @GetMapping(value = "/product/list_view_2", produces = MediaType.TEXT_HTML_VALUE)
    public String showListView2() {
        Context context = new Context();
        List<Product> aList = new ArrayList<>();
        aList.add(new Product(1, "Paper HP", 67.9));
        aList.add(new Product(2, "Monitor Dell", 73.8));
        aList.add(new Product(3, "Keyboard Mac", 122.0));
        context.setVariable("productList", aList);
        return templateEngine.process("product_management/list_2", context);
    }

    @GetMapping(value = "/product/list_view", produces = MediaType.TEXT_HTML_VALUE)
    public String showListView() {
        Context context = new Context();
        List<String> aList = new ArrayList<>();
        aList.add("Superior Sound Quality");
        aList.add("Long Battery Life");
        aList.add("Bluetooth 5.0 Connectivity");
        aList.add("Portable Design");
        context.setVariable("myList", aList);
        return templateEngine.process("product_management/list", context);
    }

    @GetMapping(value = "/product/detail_page", produces = MediaType.TEXT_HTML_VALUE)
    public String showProductDetails() {
        Context context = new Context();
        context.setVariable("productName", "Marshall speaker 111");
        return templateEngine.process("product_management/product_detail", context);
    }
}
