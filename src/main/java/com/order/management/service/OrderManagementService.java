package com.order.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.dao.OrderManagementDao;
import com.order.management.model.OrderModel;

@Service
public class OrderManagementService {
	@Autowired
	OrderManagementDao orderManagementDao;

	public List<OrderModel> getOrders() {
		return (List<OrderModel>) orderManagementDao.findAll();
	}

	public List<OrderModel> createOrder(List<OrderModel> orderModel) {
		return (List<OrderModel>) orderManagementDao.saveAll(orderModel);
	}

	public OrderModel getOrders(Integer orderId) {
		return orderManagementDao.findById(orderId).get();
		
	}
}
