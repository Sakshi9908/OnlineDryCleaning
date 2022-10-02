package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinedrycleaning.exception.WrongPasswordException;
import com.onlinedrycleaning.entity.Customer;
import com.onlinedrycleaning.exception.CustomerNotFoundException;
import com.onlinedrycleaning.exception.CustomerNameAlreadyExistException;
import com.onlinedrycleaning.repository.ICustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	private CustomerService service;

	@Mock
	private ICustomerRepository repository;

	@InjectMocks
	private Customer customer;

	@BeforeEach
	public void setUp() {
		customer.setCustomerName("Karan");
		customer.setEmail("ram@gmail.com");
		customer.setContactNo("8765432098");
		customer.setPassword("Ramayam@34");
	}

	@Test
	public void testAddCustomer() throws CustomerNameAlreadyExistException {
		Mockito.doReturn(customer).when(repository).save(Mockito.any());
		assertEquals(customer.getCustomerName(), service.addCustomer(customer).getCustomerName());
		assertEquals(customer.getEmail(), service.addCustomer(customer).getEmail());
		assertEquals(customer.getContactNo(), service.addCustomer(customer).getContactNo());
	}
	
	@Test
	public void testGetCustomerByName() throws CustomerNotFoundException {
		String customerName = "Karan";
		Mockito.when(repository.findByCustomerName(customerName)).thenReturn(customer);
		assertEquals(customerName, service.getCustomerByName(customerName).getCustomerName());

	}
	
	@Test
	public void testLogin() throws CustomerNotFoundException, WrongPasswordException {
		String customerName = "Karan";
		String password = "Ramayam@34";
		Mockito.when(repository.findByCustomerName(customerName)).thenReturn(customer);
		assertEquals(customerName, service.getCustomerByName(customerName).getCustomerName());
		assertEquals(password, service.getCustomerByName(customerName).getPassword());

	}
	
	
}
