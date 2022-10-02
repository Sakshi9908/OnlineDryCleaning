package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Address;


@Service
public interface IAddressService {
	public Address addAddress(Address address);


//	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword;

	public Address updateAddress(Address address);

	public List<Address> deleteAddress(int addressId);
	
	public List<Address> getAllAddress();
}
