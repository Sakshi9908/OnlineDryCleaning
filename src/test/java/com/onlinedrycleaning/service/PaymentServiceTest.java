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

import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.exception.IdNotFoundException;
import com.onlinedrycleaning.repository.IPaymentRepository;

@SpringBootTest
public class PaymentServiceTest {

	@InjectMocks
	private PaymentService service;

	@Mock
	private IPaymentRepository repository;

	@InjectMocks
	private Payment payment;
	

	@BeforeEach
	public void setUp() {
		payment.setStatus("pending");
		payment.setType("UPI");
		
	}

	@Test
	public void testUpdatePayment() throws IdNotFoundException {
		Mockito.doReturn(payment).when(repository).save(Mockito.any());
		assertEquals(payment.getPaymentId(), service.updatePayment(payment).getPaymentId());
		assertEquals(payment.getStatus(), service.updatePayment(payment).getStatus());
		assertEquals(payment.getType(), service.updatePayment(payment).getType());
	}
	
	@Test
	public void testGetPaymentDetails() throws IdNotFoundException {
		long paymentId= 4;
		Mockito.when(repository.findById(paymentId)).thenReturn(Optional.of(payment));
		assertEquals(payment, service.getPaymentDetails(paymentId));
		assertEquals(payment.getPaymentId(), service.getPaymentDetails(paymentId).getPaymentId());
	}
	
	@Test
	public void testGetAllPayment() throws IdNotFoundException {
		Mockito.doReturn(Stream.of(payment, payment).collect(Collectors.toList())).when(repository).findAll();
		assertEquals(Stream.of(payment, payment).collect(Collectors.toList()), service.getAllPaymentDetails());
		assertEquals(2, service.getAllPaymentDetails().size());
	}
}
