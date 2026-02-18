package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* Bai 5 SpringMVC
* */
@RestController
@RequestMapping("/api/demo/")
public class DemoController {

    @DeleteMapping("/orders/detail/body")
    public ResponseEntity deleteOrdersFromBody(
            @RequestBody Object ids
    ){
        System.out.println("Body data: " + ids.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/order/detail")
    public ResponseEntity deleteOrder(
            @RequestParam String id
    ){
        System.out.println("Id value: " + id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/category/detail/body")
    public ResponseEntity updateCategoryFromBody(
            @RequestBody Object productDetail
    ){
        System.out.println("Body data: " + productDetail.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category/detail")
    public ResponseEntity updateCategory(
            @RequestParam String name,
            @RequestParam(required = false) String price,
            @RequestParam(defaultValue = "red") String color
    ){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/product/detail")
    public ResponseEntity createNewProduct(
            @RequestParam String name,
            @RequestParam(required = false) String price,
            @RequestParam(defaultValue = "yellow") String color
    ){
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @PostMapping("/product/detail/body")
    public ResponseEntity createNewProductFromBodyParam(
            @RequestBody Object productDetail
    ){
        System.out.println("Body data: " + productDetail.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/product/detail")
//    public ResponseEntity getProductById(@RequestParam String id){
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(@RequestHeader Map<String, String> headers){
        System.out.println(headers);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

//    @GetMapping("/products")
//    public ResponseEntity getAllProducts(){
//        List<String> productNames = new ArrayList<>();
//        productNames.add("Samsung");
//        return new ResponseEntity<>(productNames, HttpStatus.OK);
//    }

    @GetMapping("/product/{id}/detail")
    public ResponseEntity<String> getProductByIdFromPath(@PathVariable String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

