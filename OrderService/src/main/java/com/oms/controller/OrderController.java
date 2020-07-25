package com.oms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.OrderItemServiceProxy;
import com.oms.model.Order;
import com.oms.service.OrderService;

@RestController
@RequestMapping("oms")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemServiceProxy proxy;
	
	@RequestMapping("/getOrder")
	public List<Order> getOrder() {
		
		List<Order> orders = orderService.getOrder();
		return orders;
	}
	
	@PostMapping("/createOrder")
	public ResponseEntity<Object> createOrder(@Valid @RequestBody Order order) {
		Order orderSaved = new Order();
		
		orderService.createOrder(order);
		return ResponseEntity.noContent().build();
	}

}
