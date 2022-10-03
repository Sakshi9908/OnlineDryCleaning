package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinedrycleaning.entity.CustomerItem;
import com.onlinedrycleaning.exception.ItemNotFoundException;
import com.onlinedrycleaning.repository.ICustomerItemRepository;


@SpringBootTest
public class CustomerItemSeviceTest {
	@InjectMocks
	private CustomerItemService customerItemService;
	
	@Mock
	private ICustomerItemRepository customerItemRepository;
	
	@InjectMocks
	private CustomerItem customerItem;
	
	@BeforeEach
	public void setUp() {
	   
		customerItem.setItemId(101);
		customerItem.setName("Kurta");
		customerItem.setColor("Red");
		customerItem.setCategory("Treditional Wear");
		customerItem.setQuantity(3);
		customerItem.setMaterial("Silk");
		customerItem.setDescription("Deliver It ASAP");
		
	}
	
	
	@Test
	public void addSeatTypeTest() {
		
		
		Mockito.doReturn(customerItem).when(customerItemRepository).save(Mockito.any());
		assertEquals(customerItem.getCategory(), customerItemService.addCustomerItem(customerItem).getCategory());
		assertEquals(customerItem.getColor(),    customerItemService.addCustomerItem(customerItem).getColor());
		assertEquals(customerItem.getDescription(), customerItemService.addCustomerItem(customerItem).getDescription());
		assertEquals(customerItem.getItemId(), customerItemService.addCustomerItem(customerItem).getItemId());
		assertEquals(customerItem.getMaterial(), customerItemService.addCustomerItem(customerItem).getMaterial());
		assertEquals(customerItem.getName(), customerItemService.addCustomerItem(customerItem).getName());
		assertEquals(customerItem.getQuantity(), customerItemService.addCustomerItem(customerItem).getQuantity());
	}
	
	
	@Test
	public void updateSeatTypeTest() {

		Mockito.doReturn(customerItem).when(customerItemRepository).save(Mockito.any());
		assertEquals(customerItem.getCategory(), customerItemService.updateCustomerItem(customerItem).getCategory());
		assertEquals(customerItem.getColor(),    customerItemService.updateCustomerItem(customerItem).getColor());
		assertEquals(customerItem.getDescription(), customerItemService.updateCustomerItem(customerItem).getDescription());
		assertEquals(customerItem.getItemId(), customerItemService.updateCustomerItem(customerItem).getItemId());
		assertEquals(customerItem.getMaterial(), customerItemService.updateCustomerItem(customerItem).getMaterial());
		assertEquals(customerItem.getName(), customerItemService.updateCustomerItem(customerItem).getName());
		assertEquals(customerItem.getQuantity(), customerItemService.updateCustomerItem(customerItem).getQuantity());
		
	}
	
	
	@Test
	public void getCustomerItemByIdTest() throws ItemNotFoundException  {
		long itemId = 101;
		Mockito.when(customerItemRepository.findById(itemId)).thenReturn(Optional.of(customerItem));
		assertEquals(customerItem, customerItemService.getCustomerItemById(itemId));
		assertEquals(customerItem.getItemId(), customerItemService.getCustomerItemById(itemId).getItemId());
	}

    
	@Test
	public void deleteCustomerItemByIdTest() throws ItemNotFoundException {
		long itemId = 101;
		customerItemService.deleteCustomerItemById(itemId);
		Mockito.verify(customerItemRepository, Mockito.atLeastOnce()).deleteById(Mockito.anyLong());
	}

}
