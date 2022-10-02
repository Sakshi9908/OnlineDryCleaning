package com.onlinedrycleaning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
import com.onlinedrycleaning.repository.IOrderRepository;

@Service

 class OrderService implements IOrderService{
	@Autowired
	IOrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order, long orderId) {
		Optional<Order> orderToBeUpdated = orderRepository.findById(order.getOrderId());
		if (orderToBeUpdated.isPresent()) {
			orderRepository.save(order);
		}
		return orderToBeUpdated.orElseThrow(
				() -> new OrderIdNotFoundException("Order with id: " + order.getOrderId() + " is not found"));
	}

	@Override
	public List<Order> deleteOrderById(long orderId) throws OrderIdNotFoundException {
		try {
			orderRepository.deleteById(orderId);
			return orderRepository.findAll();
		} catch (Exception e) {
			throw new OrderIdNotFoundException("Id is not present, enter correct Id");
		}
	}
	
	@Override
	public List<Order> deleteAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order viewOrder(int bookingId) throws OrderIdNotFoundException{
		Optional<Order> orderOptional = orderRepository.findById(bookingId);
		return orderOptional
				.orElseThrow(() -> new OrderIdNotFoundException("Order with id: " + bookingId + " is not found"));
	}

	@Override
	public List<Order> viewAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order deleteOrder(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
