package com.onlinedrycleaning.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinedrycleaning.entity.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>  {
	
	public List<Booking> findAllByBookingDate(LocalDate bookingDate);


}
