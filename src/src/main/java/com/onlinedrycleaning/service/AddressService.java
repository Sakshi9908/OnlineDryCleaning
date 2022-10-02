package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Address;
import com.onlinedrycleaning.repository.IAddressRepository;

@Service
public class AddressService implements IAddressService {
	@Autowired
	private IAddressRepository addressRepo;

	@Override
	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepo.findAll();
	}

	@Override
	public List<Address> deleteAddress(int addressId) {
		addressRepo.deleteById(addressId);
		return addressRepo.findAll();

	}
}
