package com.onlinedrycleaning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
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
import com.onlinedrycleaning.entity.CustomerItem;
import com.onlinedrycleaning.exception.BookingNotFoundException;
import com.onlinedrycleaning.repository.BookingRepository;

@SpringBootTest
public class BookingServiceTest {
	@InjectMocks
	private BookingService bookingService;
	
	@Mock
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private Booking booking;
	
	@BeforeEach
	public void setUp() {
		
		CustomerItem customerItem = new CustomerItem();
		
		//final LocalDate bookingDate = Mockito.mock(LocalDate.class);
		//final LocalTime bookingTime = Mockito.mock(LocalTime.class);
		
		customerItem.setItemId(101);
		customerItem.setName("Kurta");
		customerItem.setColor("Red");
		customerItem.setCategory("Treditional Wear");
		customerItem.setQuantity(3);
		customerItem.setMaterial("Silk");
		customerItem.setDescription("Deliver It ASAP");
		
		//booking = new Booking();
		booking.setBookingId(1);
		booking.setServiceType("DryCleaning");
		
		List<CustomerItem> customerlist = new ArrayList<>();
		customerlist.add(customerItem);
		booking.setCustomerItem(customerlist);
		
		
	}
	
	@Test
	public void getAllBookingTest() {
		Mockito.doReturn(Stream.of(booking,booking).collect(Collectors.toList())).when(bookingRepository).findAll();
		assertEquals(Stream.of(booking,booking).collect(Collectors.toList()),bookingService.getAllBooking());
		assertEquals(2,bookingService.getAllBooking().size());
		
	}
	

	@Test
	public void addBookingTest() {
		
		
		Mockito.doReturn(booking).when(bookingRepository).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.addBooking(booking).getBookingId());
		assertEquals(booking.getServiceType(), bookingService.addBooking(booking).getServiceType());
        assertEquals(booking.getCustomerItem().get(0).getItemId(), bookingService.addBooking(booking).getCustomerItem().get(0).getItemId());
//        assertEquals(booking.getCustomerItem().get(0).getCategory(), bookingService.addBooking(booking).getCustomerItem().get(0).getCategory());
//        assertEquals(booking.getCustomerItem().get(0).getColor(), bookingService.addBooking(booking).getCustomerItem().get(0).getColor());
//        assertEquals(booking.getCustomerItem().get(0).getDescription(), bookingService.addBooking(booking).getCustomerItem().get(0).getDescription());
//        assertEquals(booking.getCustomerItem().get(0).getMaterial(), bookingService.addBooking(booking).getCustomerItem().get(0).getMaterial());
//        assertEquals(booking.getCustomerItem().get(0).getName(), bookingService.addBooking(booking).getCustomerItem().get(0).getName());
//        assertEquals(booking.getCustomerItem().get(0).getQuantity(), bookingService.addBooking(booking).getCustomerItem().get(0).getQuantity());
//        
//        
//       
	   
		
}
	
	@Test
	public void  updateBookingTest() {
		
		
		Mockito.doReturn(booking).when(bookingRepository).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.updateBooking(booking).getBookingId());
		assertEquals(booking.getServiceType(), bookingService.updateBooking(booking).getServiceType());
		assertEquals(booking.getCustomerItem(), bookingService.addBooking(booking).getCustomerItem());
		
		
		
		
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
		long  bookingId = 1001;
		bookingService.deleteBookingById(bookingId);
		Mockito.verify(bookingRepository, Mockito.atLeastOnce()).deleteById(Mockito.anyLong());
	}
	
	
	
 
 /*
  * @Test
	public void testDeleteSunGlass() throws NoSuchSunGlassFoundException {
		int sunGlassId = 101;
		service.deleteSunGlass(sunGlassId);
		Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}
	
  * findById(bookingTypeId)).thenReturn(Optional.of(booking));
  * 
  assertEquals(booking.getSeatType().getSeatTypeDesc(), bookingService.addBooking(booking).getSeatType().getSeatTypeDesc());
		assertEquals(booking.getHall().getHallId(), bookingService.addBooking(booking).getHall().getHallId());
		assertEquals(booking.getHall().getHallDesc(), bookingService.addBooking(booking).getHall().getHallDesc());
		assertEquals(booking.getHall().getTotalCapacity(), bookingService.addBooking(booking).getHall().getTotalCapacity());
	 * 
	 * 
	 * addHallCapacity(hallCapacity).getHallCapId()
	
	 */
}
	
