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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private int customerId;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "email")
	@Email(message = "Email should be in valid format")
	private String email;

	@Pattern(regexp = "^[0-9]{10}$", message = "Number should contain only 10 digits ")
	@Column(name = "contactNo")
	private String contactNo;

	@Column(name = "dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$", message = "Password should be in valid format")
	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@NotBlank(message = "Role should not be blank")
	private String role = "customer";

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private List<Address> address = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private List<CustomerItem> customeritem = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
//	private List<Booking> booking = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "cusomerId", referencedColumnName = "cusomerId")
//	private List<Order> order = new ArrayList<>();


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerName, String email, String contactNo, LocalDate dob, String password,
			String role, List<Address> address, List<CustomerItem> customeritem) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.password = password;
		this.role = role;
		this.address = address;
		this.customeritem = customeritem;
//		this.booking = booking;
//		this.order = order;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<CustomerItem> getCustomeritem() {
		return customeritem;
	}

	public void setCustomeritem(List<CustomerItem> customeritem) {
		this.customeritem = customeritem;
	}

//	public List<Booking> getBooking() {
//		return booking;
//	}
//
//	public void setBooking(List<Booking> booking) {
//		this.booking = booking;
//	}

//	public List<Order> getOrder() {
//		return order;
//	}
//
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}

}
