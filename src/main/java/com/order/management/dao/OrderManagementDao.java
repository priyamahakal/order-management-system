package com.order.management.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.management.model.OrderModel;

@Repository
public interface OrderManagementDao extends CrudRepository<OrderModel, Integer> {

}
