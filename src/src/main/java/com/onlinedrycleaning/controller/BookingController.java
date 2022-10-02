package com.onlinedrycleaning.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.onlinedrycleaning.entity.Booking;
import com.onlinedrycleaning.exception.BookingDateNotFound;
import com.onlinedrycleaning.exception.BookingNotFoundException;
import com.onlinedrycleaning.service.IBookingService;

@RestController
@RequestMapping("/drycleaning")
public class BookingController {
	@Autowired
	IBookingService bookingService;

	// GetMapping

	/*
	 * Method: getAllBooking() Description: It allows to get all the Seats.
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

	@GetMapping("/booking/getAllBookings")
	public ResponseEntity<List<Booking>> getAllBooking() {

		return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(), HttpStatus.OK);
	}

	// PostMapping

	/*
	 * Method:addBooking(@RequestBody Booking booking) Description: It allows to
	 * update the Seats.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */

	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.OK);

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

	@PutMapping("/updateBooking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.OK);
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

	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") long bookingId)
			throws BookingNotFoundException {
		return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId), HttpStatus.OK);
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

	@DeleteMapping("/deletBooking/{bookingId}")
	public ResponseEntity<List<Booking>> deleteBookingById(@PathVariable("bookingId") long bookingId)
			throws BookingNotFoundException {
		try {
			// List<Booking> bookingList = bookingService.deleteBookingById(bookingId);
			return new ResponseEntity<List<Booking>>(bookingService.deleteBookingById(bookingId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/byDate/{bookingDate}")
	public ResponseEntity<List<Booking>> findAllByBookingDate(
			@PathVariable("bookingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bookingDate)
			throws BookingDateNotFound {

		return new ResponseEntity<List<Booking>>(bookingService.findAllByBookingDate(bookingDate), HttpStatus.OK);
	}
	
	@GetMapping("/pagingAndSortingBooking/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Booking> bookingPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return bookingService.getBookingPagination(pageNumber, pageSize, sortProperty);
	}
}
