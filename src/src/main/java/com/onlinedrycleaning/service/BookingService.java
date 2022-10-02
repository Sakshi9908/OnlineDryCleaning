package com.onlinedrycleaning.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Booking;
import com.onlinedrycleaning.exception.BookingDateNotFound;
import com.onlinedrycleaning.exception.BookingNotFoundException;
import com.onlinedrycleaning.repository.BookingRepository;

@Service
public class BookingService implements IBookingService{
	
	@Autowired
	private BookingRepository bookingRepo;
	
    //Get Mapping
	@Override
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}
	
   //Post Mapping
	@Override
	public Booking addBooking(Booking booking) {
		bookingRepo.save(booking);
		return booking;
	}

	//Put Mapping
	
	@Override
	public Booking updateBooking(Booking booking) {
		bookingRepo.save(booking);
		return booking;
	}
	

	@Override
	public Booking getBookingById(long bookingId ) throws BookingNotFoundException {
		try {
			return bookingRepo.findById(bookingId).get();
		} catch (Exception e) {
			throw new BookingNotFoundException("Booking not found...");
		}
	}

	@Override
	public List<Booking> deleteBookingById(long bookingId) throws BookingNotFoundException {
		try {
			bookingRepo.deleteById(bookingId);
			return bookingRepo.findAll();
		} catch (Exception e) {
			throw new BookingNotFoundException("Id is not present, enter correct Id.");
		}
	}
	
	@Override
	public List<Booking> findAllByBookingDate(LocalDate bookingDate) throws BookingDateNotFound {
		try {
		return bookingRepo.findAllByBookingDate(bookingDate);
		}
		catch(Exception e) {
			throw new BookingDateNotFound("Booking for this date is not Available.");
		}
	}
	
	@Override
	public Page<Booking> getBookingPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"bookingId");
        }
        return bookingRepo.findAll(pageable);
    }
}
