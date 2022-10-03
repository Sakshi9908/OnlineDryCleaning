package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinedrycleaning.entity.Booking;
import com.onlinedrycleaning.entity.Customer;

import com.onlinedrycleaning.entity.Order;

import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
import com.onlinedrycleaning.repository.IOrderRepository;

@SpringBootTest
public class OrderServiceTest {
	
	@InjectMocks
	private OrderService orderService;
	
	@Mock
	private IOrderRepository iOrderRepository;
	
	@InjectMocks
	private Order order;
	
	@BeforeEach
	public void setUp() {
		
		Payment payment = new Payment();
		Customer customer = new Customer();
		Booking booking = new Booking();
		
		payment.setCard(null);
		//payment.setPaymentId(101);
		payment.setStatus("Active");
		payment.setType("DebitCard");
		
		customer.setAddress(null);
		customer.setContactNo("9637672598");
		customer.setCustomerId(51);
		customer.setCustomeritem(null);
		customer.setCustomerName("Onkar");
		customer.setEmail("onkarskulkarni09.58@gmail.com");
		customer.setPassword("Pass@123");
		customer.setRole("User");
		
		booking.setBookingId(1);
		booking.setServiceType("DryCleaning");
		
		order.setAmount(5000);
		order.setOrderId(201);
		order.setPaymentMethod("Netbanking");
		


		
	
		
		
		
		
	}
	
	@Test
	public void getAllOrdersTest() {
		Mockito.doReturn(Stream.of(order,order).collect(Collectors.toList())).when(iOrderRepository).findAll();
		assertEquals(Stream.of(order,order).collect(Collectors.toList()),orderService.getAllOrders());
		assertEquals(2,orderService.getAllOrders().size());
		
	}
	

	/*
	@Test
	public void addOrderTest() {
		
		
		Mockito.doReturn(order).when(iOrderRepository).save(Mockito.any());
		assertEquals(order.getAmount(), orderService.addOrder(order).getAmount());
		assertEquals(order.getOrderId(), orderService.addOrder(order).getOrderId());
        assertEquals(order.getPaymentMethod(), orderService.addOrder(order).getPaymentMethod());
        
        assertEquals(order.getPayment().getPaymentId(), orderService.addOrder(order).getPayment().getPaymentId());
        assertEquals(order.getPayment().getStatus(), orderService.addOrder(order).getPayment().getStatus());
        assertEquals(order.getPayment().getType(), orderService.addOrder(order).getPayment().getType());
        
        assertEquals(order.getCustomer().getAddress(), orderService.addOrder(order).getCustomer().getAddress());
        assertEquals(order.getCustomer().getContactNo(), orderService.addOrder(order).getCustomer().getContactNo());
        assertEquals(order.getCustomer().getCustomerId(), orderService.addOrder(order).getCustomer().getCustomerId());
        assertEquals(order.getCustomer().getCustomerName(), orderService.addOrder(order).getCustomer().getCustomerName());
        assertEquals(order.getCustomer().getEmail(), orderService.addOrder(order).getCustomer().getEmail());
        assertEquals(order.getCustomer().getPassword(), orderService.addOrder(order).getCustomer().getPassword());
        assertEquals(order.getCustomer().getRole(), orderService.addOrder(order).getCustomer().getRole());
        
        assertEquals(order.getBooking().get(0).getBookingId(), orderService.addOrder(order).getBooking().get(0).getBookingId());
        assertEquals(order.getBooking().get(0).getServiceType(), orderService.addOrder(order).getBooking().get(0).getServiceType());
       
        
        
       
	   
		
}
	/*
	
	@Test
	public void  updateOrderTest() {
		
		
		Mockito.doReturn(order).when(iOrderRepository).save(Mockito.any());
		assertEquals(order.getAmount(), orderService.updateOrder(order).getAmount());
		assertEquals(order.getOrderId(), orderService.updateOrder(order).getOrderId());
        assertEquals(order.getPaymentMethod(), orderService.updateOrder(order).getPaymentMethod());
        
        assertEquals(order.getPayment().getPaymentId(), orderService.updateOrder(order).getPayment().getPaymentId());
        assertEquals(order.getPayment().getStatus(), orderService.updateOrder(order).getPayment().getStatus());
        assertEquals(order.getPayment().getType(), orderService.updateOrder(order).getPayment().getType());
        
        assertEquals(order.getCustomer().getAddress(), orderService.updateOrder(order).getCustomer().getAddress());
        assertEquals(order.getCustomer().getContactNo(), orderService.updateOrder(order).getCustomer().getContactNo());
        assertEquals(order.getCustomer().getCustomerId(), orderService.updateOrder(order).getCustomer().getCustomerId());
        assertEquals(order.getCustomer().getCustomerName(), orderService.updateOrder(order).getCustomer().getCustomerName());
        assertEquals(order.getCustomer().getEmail(), orderService.updateOrder(order).getCustomer().getEmail());
        assertEquals(order.getCustomer().getPassword(), orderService.updateOrder(order).getCustomer().getPassword());
        assertEquals(order.getCustomer().getRole(), orderService.updateOrder(order).getCustomer().getRole());
        
        assertEquals(order.getBooking().get(0).getBookingId(), orderService.updateOrder(order).getBooking().get(0).getBookingId());
        assertEquals(order.getBooking().get(0).getServiceType(), orderService.updateOrder(order).getBooking().get(0).getServiceType());
	
	}
	*/
	
	
	@Test
	public void getOrderByIdTest() throws OrderIdNotFoundException {
		long orderId = 201;
		Mockito.when(iOrderRepository.findById(orderId)).thenReturn(Optional.of(order));
		assertEquals(order, orderService.getOrderById(orderId));
		assertEquals(order.getOrderId(), orderService.getOrderById(orderId).getOrderId());
	}
	
	
	
	

	@Test
	public void deleteOrderByIdTest() throws OrderIdNotFoundException {
		long  orderId = 201;
		orderService.deleteOrderById(orderId);
		Mockito.verify(iOrderRepository, Mockito.atLeastOnce()).deleteById(Mockito.anyLong());
	}


}
