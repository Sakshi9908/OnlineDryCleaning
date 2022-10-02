package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
@Service
public interface IOrderService {
	public Order addOrder(Order order);
	
	public Order deleteOrder(int bookingId);
	
	public Order viewOrder(int bookingId);
	
	public List<Order> viewAllOrders();
	
	public Order updateOrder(Order order, long orderId);

	public List<Order> deleteOrderById(long orderId) throws OrderIdNotFoundException;

	public List<Order> deleteAllOrders();

}
