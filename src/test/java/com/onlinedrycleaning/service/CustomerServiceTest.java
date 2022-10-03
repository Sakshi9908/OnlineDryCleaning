package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinedrycleaning.exception.WrongPasswordException;
import com.onlinedrycleaning.entity.Address;
import com.onlinedrycleaning.entity.Customer;
import com.onlinedrycleaning.entity.CustomerItem;
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

		Address address = new Address();

		CustomerItem customerItem = new CustomerItem();

		address.setAddressId(102);
		address.setArea("Modikhana");
		address.setCity("Jalna");
		address.setDoorNo("1-5-37");
		address.setPincode(431203);
		address.setState("Maharashtra");
		address.setStreet("Last Lane");

		customer.setCustomerId(101);
		customer.setCustomerName("Karan");
		customer.setEmail("ram@gmail.com");
		customer.setContactNo("8765432098");
		customer.setPassword("Ramayam@34");

		customerItem.setItemId(101);
		customerItem.setName("Kurta");
		customerItem.setColor("Red");
		customerItem.setCategory("Treditional Wear");
		customerItem.setQuantity(3);
		customerItem.setMaterial("Silk");
		customerItem.setDescription("Deliver It ASAP");

		List<Address> addresslist = new ArrayList<>();
		addresslist.add(address);
		customer.setAddress(addresslist);

		List<CustomerItem> customerlist = new ArrayList<>();
		customerlist.add(customerItem);
		customer.setCustomeritem(customerlist);
	}

	@Test
	public void testAddCustomer() throws CustomerNameAlreadyExistException {
		Mockito.doReturn(customer).when(repository).save(Mockito.any());
		assertEquals(customer.getCustomerId(), service.addCustomer(customer).getCustomerId());
		assertEquals(customer.getCustomerName(), service.addCustomer(customer).getCustomerName());
		assertEquals(customer.getEmail(), service.addCustomer(customer).getEmail());
		assertEquals(customer.getContactNo(), service.addCustomer(customer).getContactNo());
		assertEquals(customer.getAddress().get(0).getAddressId(),
				service.addCustomer(customer).getAddress().get(0).getAddressId());
		assertEquals(customer.getAddress().get(0).getArea(),
				service.addCustomer(customer).getAddress().get(0).getArea());
		assertEquals(customer.getAddress().get(0).getCity(),
				service.addCustomer(customer).getAddress().get(0).getCity());
		assertEquals(customer.getAddress().get(0).getDoorNo(),
				service.addCustomer(customer).getAddress().get(0).getDoorNo());
		assertEquals(customer.getAddress().get(0).getPincode(),
				service.addCustomer(customer).getAddress().get(0).getPincode());
		assertEquals(customer.getAddress().get(0).getState(),
				service.addCustomer(customer).getAddress().get(0).getState());
		assertEquals(customer.getAddress().get(0).getStreet(),
				service.addCustomer(customer).getAddress().get(0).getStreet());

		assertEquals(customer.getCustomeritem().get(0).getItemId(),
				service.addCustomer(customer).getCustomeritem().get(0).getItemId());
		assertEquals(customer.getCustomeritem().get(0).getCategory(),
				service.addCustomer(customer).getCustomeritem().get(0).getCategory());
		assertEquals(customer.getCustomeritem().get(0).getColor(),
				service.addCustomer(customer).getCustomeritem().get(0).getColor());
		assertEquals(customer.getCustomeritem().get(0).getDescription(),
				service.addCustomer(customer).getCustomeritem().get(0).getDescription());
		assertEquals(customer.getCustomeritem().get(0).getMaterial(),
				service.addCustomer(customer).getCustomeritem().get(0).getMaterial());
		assertEquals(customer.getCustomeritem().get(0).getName(),
				service.addCustomer(customer).getCustomeritem().get(0).getName());
		assertEquals(customer.getCustomeritem().get(0).getQuantity(),
				service.addCustomer(customer).getCustomeritem().get(0).getQuantity());

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

	@Test
	public void testDeleteCustomer() throws CustomerNotFoundException {
		int customerId = 101;
		service.deleteCustomer(customerId);
		Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

	@Test
	public void testUpdateCustomer() throws CustomerNotFoundException, CustomerNameAlreadyExistException {
		Mockito.doReturn(customer).when(repository).save(Mockito.any());
		assertEquals(customer.getCustomerId(), service.updateCustomer(customer).getCustomerId());
		assertEquals(customer.getCustomerName(), service.updateCustomer(customer).getCustomerName());
		assertEquals(customer.getEmail(), service.updateCustomer(customer).getEmail());
		assertEquals(customer.getContactNo(), service.updateCustomer(customer).getContactNo());
		assertEquals(customer.getAddress().get(0).getAddressId(),
				service.updateCustomer(customer).getAddress().get(0).getAddressId());
		assertEquals(customer.getAddress().get(0).getArea(),
				service.updateCustomer(customer).getAddress().get(0).getArea());
		assertEquals(customer.getAddress().get(0).getCity(),
				service.updateCustomer(customer).getAddress().get(0).getCity());
		assertEquals(customer.getAddress().get(0).getDoorNo(),
				service.updateCustomer(customer).getAddress().get(0).getDoorNo());
		assertEquals(customer.getAddress().get(0).getPincode(),
				service.updateCustomer(customer).getAddress().get(0).getPincode());
		assertEquals(customer.getAddress().get(0).getState(),
				service.updateCustomer(customer).getAddress().get(0).getState());
		assertEquals(customer.getAddress().get(0).getStreet(),
				service.updateCustomer(customer).getAddress().get(0).getStreet());
		
		assertEquals(customer.getCustomeritem().get(0).getItemId(),
				service.updateCustomer(customer).getCustomeritem().get(0).getItemId());
		assertEquals(customer.getCustomeritem().get(0).getCategory(),
				service.updateCustomer(customer).getCustomeritem().get(0).getCategory());
		assertEquals(customer.getCustomeritem().get(0).getColor(),
				service.updateCustomer(customer).getCustomeritem().get(0).getColor());
		assertEquals(customer.getCustomeritem().get(0).getDescription(),
				service.updateCustomer(customer).getCustomeritem().get(0).getDescription());
		assertEquals(customer.getCustomeritem().get(0).getMaterial(),
				service.updateCustomer(customer).getCustomeritem().get(0).getMaterial());
		assertEquals(customer.getCustomeritem().get(0).getName(),
				service.updateCustomer(customer).getCustomeritem().get(0).getName());
		assertEquals(customer.getCustomeritem().get(0).getQuantity(),
				service.updateCustomer(customer).getCustomeritem().get(0).getQuantity());
	}

}
