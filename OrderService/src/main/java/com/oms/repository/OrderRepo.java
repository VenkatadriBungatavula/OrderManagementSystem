package com.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, String>{

}
