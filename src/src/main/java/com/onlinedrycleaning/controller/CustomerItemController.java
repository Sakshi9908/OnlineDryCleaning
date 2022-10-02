package com.onlinedrycleaning.controller;

import java.util.List;

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
import com.onlinedrycleaning.entity.CustomerItem;
import com.onlinedrycleaning.exception.BookingNotFoundException;
import com.onlinedrycleaning.exception.ItemNotFoundException;
import com.onlinedrycleaning.service.ICustomerItemService;

@RestController
@RequestMapping("/drycleaning")
public class CustomerItemController {
	@Autowired
	ICustomerItemService customerItemService;

	@PostMapping("/addCustomerItem")
	public ResponseEntity<CustomerItem> addCustomerItem(@Valid @RequestBody CustomerItem customerItem) {
		return new ResponseEntity<CustomerItem>(customerItemService.addCustomerItem(customerItem), HttpStatus.OK);

	}

	// Update(Put) Mapping

	/*
	 * Method: updateBooking(@RequestBody Booking booking) Description: It allows to
	 * update the Seat.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PutMapping("/updateCustomerItem")
	public ResponseEntity<CustomerItem> updateCustomerItem(@RequestBody CustomerItem customerItem) {
		return new ResponseEntity<CustomerItem>(customerItemService.updateCustomerItem(customerItem), HttpStatus.OK);
	}

	// GetMapping By I'd

	/*
	 * Method: getBookingById(@PathVariable("bookingId") Long bookingId)
	 * Description: It allows you to get the Seat by I'd.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 * 
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL
	 * Expression.
	 */

	@GetMapping("/getCustomerItem/{itemId}")
	public ResponseEntity<CustomerItem> getCustomerItemById(@PathVariable("itemId") long itemId)
			throws ItemNotFoundException {
		return new ResponseEntity<CustomerItem>(customerItemService.getCustomerItemById(itemId), HttpStatus.OK);
	}

	// DeleteMapping

	/*
	 * Method: deleteBookingById(@PathVariable("bookingId") Long bookingId)
	 * Description: It allows to remove the Seats.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@DeleteMapping("/deleteCustomerItem/{itemId}")
	public ResponseEntity<List<CustomerItem>> deleteCustomerItemById(@PathVariable("itemId") long itemId)
			throws BookingNotFoundException {
		try {

			return new ResponseEntity<List<CustomerItem>>(customerItemService.deleteCustomerItemById(itemId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/pagingAndSortingCustomerItem/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<CustomerItem> customerItemPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return customerItemService.getCustomerItemPagination(pageNumber, pageSize, sortProperty);
	}
}
