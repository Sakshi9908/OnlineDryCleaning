package com.onlinedrycleaning.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinedrycleaning.exception.CustomerNotFoundException;
import com.onlinedrycleaning.exception.WrongPasswordException;
import com.onlinedrycleaning.exception.WrongUsernameAndPassword;
import com.onlinedrycleaning.entity.Customer;
import com.onlinedrycleaning.exception.CustomerNameAlreadyExistException;
import com.onlinedrycleaning.service.ICustomerService;

@RestController
@RequestMapping("/drycleaning")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNameAlreadyExistException {
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PostMapping("/customer/login")
	public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer, HttpSession session)
			throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerService.loginCustomer(customer);
		session.setAttribute("customer", customer1);
		return new ResponseEntity<>(customer1, HttpStatus.OK);
	}

	@GetMapping("/customer/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.getAttribute("customer") != null) {
			session.invalidate();
			return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@GetMapping("/viewCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@GetMapping("/customer/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerNotFoundException {
		
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/viewByPaging/{pageNumber}/{pageSize}", method = RequestMethod.GET)
//	public Page<Customer> customerPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
//		return customerService.getCustomerPagination(pageNumber, pageSize);
//	}
	@GetMapping("/pagingAndSortingCustomer/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Customer> employeePagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return customerService.getCustomerPagination(pageNumber, pageSize, sortProperty);
    }

	
}
