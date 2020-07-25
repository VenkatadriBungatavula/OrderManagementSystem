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

import com.oms.model.OrderItem;
import com.oms.service.OrderItemService;

@Controller
@RequestMapping("oms")

public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@RequestMapping("/getItems")
	@ResponseBody
	public List<OrderItem> getItems() {
		
		List<OrderItem> items = orderItemService.getOrderItems();
		
		return items;
	}
	
	@PostMapping("/createItem")
	public ResponseEntity<Object> createItem(@Valid @RequestBody OrderItem item) {
		OrderItem itemSaved = new OrderItem();
		
		itemSaved = orderItemService.createOrderItem(item);
		return ResponseEntity.noContent().build();
		
	}

}
