package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.User;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Bai 6 SpringMVC
 * */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/api/form/fill")
    public ResponseEntity<List> fillTheForm(
            @Valid @RequestBody AccountDto accountParams,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {

            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/account/orders")
    public ResponseEntity<List<String>> getOrders(
            @RequestParam String userId
    ){
        List<String> orders = accountService.getOrders(userId);
        return new ResponseEntity<List<String>>(orders, HttpStatus.OK);
    }

    @PostMapping("/api/account/signUp")
    public ResponseEntity signUpAccount(@RequestParam String emailAddress) {
        User user = User.builder().
                username("worker").
                name("John").
                email(emailAddress).
                build();

        Boolean isValidEmail = accountService.validEmailFormat(emailAddress);
        return new ResponseEntity<>(isValidEmail, HttpStatus.OK);
    }
}
