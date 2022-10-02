package com.onlinedrycleaning.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinedrycleaning.entity.CustomerItem;



@Repository
public interface CustomerItemRepository extends JpaRepository<CustomerItem, Long>{
	//public List<CustomerItem> findByAllCustomerId(Long customerId);

}
