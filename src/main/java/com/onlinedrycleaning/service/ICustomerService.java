package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Customer;
import com.onlinedrycleaning.exception.CustomerNameAlreadyExistException;
import com.onlinedrycleaning.exception.CustomerNotFoundException;
import com.onlinedrycleaning.exception.WrongPasswordException;
import com.onlinedrycleaning.exception.WrongUsernameAndPassword;

@Service
public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws CustomerNameAlreadyExistException;

	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException;

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException;
	
	List<Customer> getAllCustomers() throws CustomerNotFoundException;

	public Page<Customer> getCustomerPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}
