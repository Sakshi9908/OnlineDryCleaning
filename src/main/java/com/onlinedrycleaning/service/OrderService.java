package com.onlinedrycleaning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
import com.onlinedrycleaning.repository.IOrderRepository;

@Service

class OrderService implements IOrderService {
	@Autowired
	IOrderRepository orderRepo;

	@Override
	public Order addOrder(Order order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public List<Order> deleteOrderById(long orderId) throws OrderIdNotFoundException {
		try {
			orderRepo.deleteById(orderId);
			return orderRepo.findAll();
		} catch (Exception e) {
			throw new OrderIdNotFoundException("Id is not present, enter correct Id");
		}
	}

	@Override
	public List<Order> deleteAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long orderId) throws OrderIdNotFoundException {
		Optional<Order> orderOptional = orderRepo.findById(orderId);
		return orderOptional
				.orElseThrow(() -> new OrderIdNotFoundException("Order with id: " + orderId + " is not found"));
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Page<Order> getOrderPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
		Pageable pageable = null;
		if (null != sortProperty) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
		} else {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "orderId");
		}
		return orderRepo.findAll(pageable);
	}

}
