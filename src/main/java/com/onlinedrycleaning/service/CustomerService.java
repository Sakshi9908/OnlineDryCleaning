package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.repository.ICustomerRepository;
import com.onlinedrycleaning.entity.Customer;
import com.onlinedrycleaning.exception.CustomerNameAlreadyExistException;
import com.onlinedrycleaning.exception.CustomerNotFoundException;
import com.onlinedrycleaning.exception.WrongPasswordException;
import com.onlinedrycleaning.exception.WrongUsernameAndPassword;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNameAlreadyExistException {

		Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
		if (customer1 != null) {
			throw new CustomerNameAlreadyExistException("Customer Name already exists.");
		} else {
			customerRepo.save(customer);
			return customer;
		}
	}

	@Override
	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException {

		Customer customer = customerRepo.findByCustomerName(customerName);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("No Record Found.");
		}
	}

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerRepo.findByCustomerName(customer.getCustomerName());
		if (customer1 != null) {
			if (customer.getPassword().equals(customer1.getPassword())) {
				return customer1;
			} else {
				throw new WrongPasswordException("Wrong Password.");
			}
		} else {
			throw new WrongUsernameAndPassword("Wrong Username or Password.");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}


	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		try {
			Customer customer = customerRepo.findById(customerId).get();
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present, Enter correct Id");
		}
	}

	@Override
	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException {
		try {
			customerRepo.deleteById(customerId);
			return customerRepo.findAll();
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present,Enter correct Id");
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerNotFoundException {

		if (customerRepo.findAll().isEmpty())
			throw new CustomerNotFoundException("No Records Found.");

		return customerRepo.findAll();

	}
	
//	public Page<Customer> getCustomerPagination(Integer pageNumber, Integer pageSize) {
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		return customerRepo.findAll(pageable);
//	}
	
	@Override
	public Page<Customer> getCustomerPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"customerName");
        }
        return customerRepo.findAll(pageable);
    }

}
