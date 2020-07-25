package com.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.exception.OrderItemNotFoundException;
import com.oms.model.OrderItem;
import com.oms.repository.OrderItemRepo;

@Service
public class OrderItemService {
	
	@Autowired
	OrderItemRepo orderItemRepo;
	
	public List<OrderItem> getOrderItems(){
		List<OrderItem> items =  orderItemRepo.findAll();
		if(items.size()==0) {
			throw new OrderItemNotFoundException("No Order Items found");
		}
		return items;
	}
	
	
	public OrderItem createOrderItem(OrderItem item){
		OrderItem savedItem =  orderItemRepo.save(item);
		return savedItem;
	}
	

}
