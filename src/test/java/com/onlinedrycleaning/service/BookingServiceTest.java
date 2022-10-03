package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinedrycleaning.entity.Booking;
import com.onlinedrycleaning.exception.BookingNotFoundException;
import com.onlinedrycleaning.repository.IBookingRepository;

@SpringBootTest
public class BookingServiceTest {
	@InjectMocks
	private BookingService bookingService;

	@Mock
	private IBookingRepository bookingRepository;

	@InjectMocks
	private Booking booking;

	@BeforeEach
	public void setUp() {

		booking.setBookingId(1);
		booking.setServiceType("DryCleaning");

	}

	@Test
	public void getAllBookingTest() {
		Mockito.doReturn(Stream.of(booking, booking).collect(Collectors.toList())).when(bookingRepository).findAll();
		assertEquals(Stream.of(booking, booking).collect(Collectors.toList()), bookingService.getAllBooking());
		assertEquals(2, bookingService.getAllBooking().size());

	}

	@Test
	public void addBookingTest() {

		Mockito.doReturn(booking).when(bookingRepository).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.addBooking(booking).getBookingId());
		assertEquals(booking.getServiceType(), bookingService.addBooking(booking).getServiceType());

	}

	@Test
	public void updateBookingTest() {

		Mockito.doReturn(booking).when(bookingRepository).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.updateBooking(booking).getBookingId());
		assertEquals(booking.getServiceType(), bookingService.updateBooking(booking).getServiceType());

	}

	@Test
	public void getBookingByIdTest() throws BookingNotFoundException {
		long bookingId = 1;
		Mockito.when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));
		assertEquals(booking, bookingService.getBookingById(bookingId));
		assertEquals(booking.getBookingId(), bookingService.getBookingById(bookingId).getBookingId());
	}

	@Test
	public void deleteBookingByIdTest() throws BookingNotFoundException {
		long bookingId = 1001;
		bookingService.deleteBookingById(bookingId);
		Mockito.verify(bookingRepository, Mockito.atLeastOnce()).deleteById(Mockito.anyLong());
	}

}
