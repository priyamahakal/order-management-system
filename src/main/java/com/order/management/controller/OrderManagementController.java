package com.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.OrderModel;
import com.order.management.service.OrderManagementService;

@RestController
public class OrderManagementController {
	@Autowired
	OrderManagementService orderManagementService;

	@PostMapping("/order/create")
	public ResponseEntity<List<OrderModel>> createOrder(@RequestBody List<OrderModel> orderModels) {
		return new ResponseEntity<List<OrderModel>>(orderManagementService.createOrder(orderModels),
				HttpStatus.CREATED);
	}

	@GetMapping("/order/{order_id}")
	public ResponseEntity<OrderModel> getOrderById(@PathVariable("order_id") Integer orderId) {
		return new ResponseEntity<OrderModel>(orderManagementService.getOrders(orderId), HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<OrderModel>> getOrders() {
		return new ResponseEntity<List<OrderModel>>(orderManagementService.getOrders(), HttpStatus.OK);
	}
}
