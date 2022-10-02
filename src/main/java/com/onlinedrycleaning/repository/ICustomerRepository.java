package com.onlinedrycleaning.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinedrycleaning.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
	
//	@Query("from Customer as c where c.customer.customerId=:customerId")
//	public Page<Customer> findAllCustomers(@Param("customerId") int customerId, Pageable pageable);
	public Customer findByCustomerName(String customerName);

}
