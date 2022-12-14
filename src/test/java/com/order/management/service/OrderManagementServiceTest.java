package com.order.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.dao.OrderManagementDao;
import com.order.management.model.OrderModel;
@SpringBootTest
public class OrderManagementServiceTest {
	@Autowired
	OrderManagementService orderManagementService;
	@Mock
	OrderManagementDao orderManagementDao;

	@Test
	public void getOrdersTest() {
		when(orderManagementDao.findAll()).thenReturn(new ArrayList<OrderModel>());
		List<OrderModel>  orders = orderManagementService.getOrders();
		assertEquals(new ArrayList<OrderModel>(), orders);
	}
	@Test
	public void getOrdersByIdTest() {
		when(orderManagementDao.findAll()).thenReturn(new ArrayList<OrderModel>());
		try {
			OrderModel  order = orderManagementService.getOrders(101);
		} catch (Exception e) {
			assertEquals("No value present", e.getMessage());
		}
		
	}

}
