package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    public List<String> getHistoricalOrders(String userId){
        List<String> orders = Arrays.asList("pencil", "book", "ruler");
        return orders;
    }
}
