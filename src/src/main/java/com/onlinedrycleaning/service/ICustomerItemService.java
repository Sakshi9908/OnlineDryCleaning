package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.CustomerItem;
import com.onlinedrycleaning.exception.ItemNotFoundException;

@Service
public interface ICustomerItemService {
	
		
	    //Post Mapping
		public CustomerItem addCustomerItem(CustomerItem customerItem);
		
	    //Put Mapping
		CustomerItem updateCustomerItem(CustomerItem customerItem);

		//Get Mapping By I'd
		public CustomerItem getCustomerItemById(long itemId) throws ItemNotFoundException;

		//Delete Booking 
		public List<CustomerItem> deleteCustomerItemById(long itemId)throws ItemNotFoundException;
		
//		
//		//Get Mapping By CustomerId
//				public List<CustomerItem> findAllByCustomerId();

		public Page<CustomerItem> getCustomerItemPagination(Integer pageNumber, Integer pageSize, String sortProperty);
}
