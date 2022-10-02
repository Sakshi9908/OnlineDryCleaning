package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.CustomerItem;
import com.onlinedrycleaning.exception.ItemNotFoundException;
import com.onlinedrycleaning.repository.CustomerItemRepository;

@Service
public class CustomerItemService implements ICustomerItemService {
	
	@Autowired
	private CustomerItemRepository customerItemRepo;

	//Post Mapping
	@Override
	public CustomerItem addCustomerItem(CustomerItem customerItem) {
		return customerItemRepo.save(customerItem);
	}

	//Put Mapping
	@Override
	public CustomerItem updateCustomerItem(CustomerItem customerItem) {
		customerItemRepo.save(customerItem);
		return customerItem;
	}

	//Get Mapping By I'd 
	@Override
	public CustomerItem getCustomerItemById(long itemId) throws ItemNotFoundException {
		try {
			return customerItemRepo.findById(itemId).get();
		} catch (Exception e) {
			throw new ItemNotFoundException("Customer Item not found...");
		}
	}

	//Delete Mapping By I'd
	@Override
	public List<CustomerItem> deleteCustomerItemById(long itemId) throws ItemNotFoundException {
		try {
			customerItemRepo.deleteById(itemId);
			return customerItemRepo.findAll();
		} catch (Exception e) {
			throw new ItemNotFoundException("Id is not present, Enter correct Id");
		}
	}

	@Override
	public Page<CustomerItem> getCustomerItemPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"customerName");
        }
        return customerItemRepo.findAll(pageable);
    }

//	@Override
//	public List<CustomerItem> findAllByCustomerId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

}
