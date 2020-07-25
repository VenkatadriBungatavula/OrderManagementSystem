package com.oms.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oms.OrderItemServiceProxy;
import com.oms.exception.OrderItemNotFoundException;
import com.oms.exception.OrderNotFoundException;
import com.oms.model.Order;
import com.oms.model.OrderItem;
import com.oms.repository.OrderRepo;

@Service
@FeignClient(url = "http://localhost:8081/oms/getItems")
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	OrderItemServiceProxy proxy;

	public List<Order> getOrder() {
		List<Order> orders = orderRepo.findAll();
		if(orders.size()==0) {
			throw new OrderNotFoundException("No Orders found");
		}
		return orders;
	}


	public void createOrder(Order order) {
		Order orderSaved = new Order();
//		RestTemplate rt = new RestTemplate();
//		String url = "http://localhost:8081/oms/getItems";
//		OrderItem [] items =  rt.getForObject(url, OrderItem [].class);
		List<OrderItem> itemsList = proxy.getItems();
		
		order.getOrderItems().stream().forEach((item) -> {
			itemsList.stream().forEach(itemService -> {
				if(item.getProductCode().equalsIgnoreCase(itemService.getProductCode())) {
					orderRepo.save(order);
				}else {
					throw new OrderItemNotFoundException("Order Item that you are ordering is not found.");
				}
			});
			
		});
		
	}

}
