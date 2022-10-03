package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
@Service
public interface IOrderService {
	public Order addOrder(Order order);
	
	public Order getOrderById(long orderId);
	
	public List<Order> getAllOrders();
	
	public Order updateOrder(Order order);

	public List<Order> deleteOrderById(long orderId) throws OrderIdNotFoundException;

	public List<Order> deleteAllOrders();
	
	public Page<Order> getOrderPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}
