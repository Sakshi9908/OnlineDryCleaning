package com.onlinedrycleaning.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId")
	private long bookingId;

	@Column(name = "bookingDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate = LocalDate.now();

	@Column(name = "serviceType")
	@NotBlank(message = "Service Type should not be empty.")
	private String serviceType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "customerItem_booking_map", 
		joinColumns = @JoinColumn(
				name = "bookingId", referencedColumnName = "bookingId"), 
				inverseJoinColumns = @JoinColumn(
					name = "itemId", referencedColumnName = "itemId")
	)
	private List<CustomerItem> customerItem = new ArrayList<>();
	


	public Booking(long bookingId, LocalDate bookingDate, String serviceType, Customer customer, List<CustomerItem> customerItem) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.serviceType = serviceType;
		this.customer = customer;
		// this.customerDetails = customerDetails;
		this.customerItem = customerItem;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerItem> getCustomerItem() {
		return customerItem;
	}

	public void setCustomerItem(List<CustomerItem> customerItem) {
		this.customerItem = customerItem;
	}
	
}

//private String dateFormat = bookingDate.toString();

//@Column(name = "bookingTime")
////@NotBlank(message = "Booking time should not be empty")
//@JsonFormat(pattern = "HH:mm:ss")
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//private String bookingTime = LocalTime.now().format(formatter);
////System.out.println(time.format(formatter));
////private LocalTime bookingTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
//

//@Column(name = "bookingTime")
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
//
//LocalDateTime now = LocalDateTime.now();
//
//String dateTimeString = now.format(formatter);

//@Column(name = "bookingTime")
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//LocalTime localTime = LocalTime.now();
//private String bookingTime = dtf.format(localTime);
////System.out.println(dtf.format(localTime)); 

//@Temporal(TemporalType.TIME)
//@DateTimeFormat(style = "hh:mm")
//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
//private Date bookingTime;
//
