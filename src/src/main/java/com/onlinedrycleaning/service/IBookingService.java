package com.onlinedrycleaning.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Booking;
import com.onlinedrycleaning.exception.BookingDateNotFound;
import com.onlinedrycleaning.exception.BookingNotFoundException;


@Service
public interface IBookingService {
	
	//Get Mapping

	public List<Booking> getAllBooking();
	
    //Post Mapping
	public Booking addBooking(Booking booking);
	
    //Put Mapping
	Booking updateBooking(Booking booking) throws BookingNotFoundException;

	//Get Mapping By I'd
	public Booking getBookingById(long bookingId) throws BookingNotFoundException;

	//Delete Booking 
	public List<Booking> deleteBookingById(long bookingId) throws BookingNotFoundException;

	//Get Mapping By bookingDate
	public List<Booking> findAllByBookingDate(LocalDate bookingDate)throws BookingDateNotFound  ;

	public Page<Booking> getBookingPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}
