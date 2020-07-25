package com.oms;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oms.model.OrderItem;

@FeignClient(name="oms")
public interface OrderItemServiceProxy {
	
	@RequestMapping("/getItems")
	public List<OrderItem> getItems();
	

}
