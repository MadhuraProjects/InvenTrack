package com.program.order_service.controller;

import com.program.order_service.orderDTO.OderRequest;
import com.program.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OderRequest orderRequest)
    {
        return orderService.placeOrder(orderRequest);
    }
}
