package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
@Service
public interface IOrderService {
	public Order addOrder(Order order);
	
	public Order viewOrder(int bookingId);
	
	public List<Order> viewAllOrders();
	
	public Order updateOrder(Order order, long orderId);

	public List<Order> deleteOrderById(long orderId) throws OrderIdNotFoundException;

	public List<Order> deleteAllOrders();
	
	public Page<Order> getOrderPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}
