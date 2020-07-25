package com.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, String>{


}
