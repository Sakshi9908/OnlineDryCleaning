package com.onlinedrycleaning.controller;

import java.util.List;

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
import com.onlinedrycleaning.entity.Order;
import com.onlinedrycleaning.exception.OrderIdNotFoundException;
import com.onlinedrycleaning.service.IOrderService;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/drycleaning")
public class Ordercontroller {

	@Autowired
	private IOrderService orderService;

	/*
	 * Method: addOrder Description: It allows to add the order.
	 * 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC
	 * and REST controllers.
	 * 
	 * @RestController: It is used to create RESTful web services using MVC.
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 * 
	 * @Autowired: It enables to inject object dependency implicitly.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */

	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}

//	@DeleteMapping("/deleteOrder/id/{bookingId}")
//	public ResponseEntity<Order> deleteOrder(@PathVariable int bookingId) throws OrderIdNotFoundException {
//		// logger.trace("deleting the whole plant");
//		return new ResponseEntity<Order>(orderService.deleteOrder(bookingId), HttpStatus.OK);
//	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<List<Order>> deleteOrderById(@PathVariable("orderId") int orderId)
			throws OrderIdNotFoundException {
		List<Order> orderList = orderService.deleteOrderById(orderId);
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}

	@GetMapping("/viewOrder/id/{bookingId}")
	public ResponseEntity<Order> viewOrder(@PathVariable int bookingId) {
		return new ResponseEntity<Order>(orderService.viewOrder(bookingId), HttpStatus.OK);
	}

//*********************************************************************************************************************	

	/*
	 * Method: removeOrder Description: It allows to remove the Order.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with
	 * given URL expression.
	 */

	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> viewAllorders() {
		return new ResponseEntity<List<Order>>(orderService.viewAllOrders(), HttpStatus.OK);
	}

//*********************************************************************************************************************	

	/*
	 * Method: updateOrder Description: It allows to update the order.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given
	 * URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 */

	@PutMapping({ "/updateOrder/id/{bookingId}" })
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable int bookingId) {
		// logger.trace("updating the whole plant having id "+ id);
		orderService.updateOrder(order, bookingId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/pagingAndSortingOrder/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Order> orderPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return orderService.getOrderPagination(pageNumber, pageSize, sortProperty);
	}

}
