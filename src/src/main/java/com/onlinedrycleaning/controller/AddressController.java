package com.onlinedrycleaning.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinedrycleaning.entity.Address;
import com.onlinedrycleaning.exception.CustomerNotFoundException;
import com.onlinedrycleaning.service.IAddressService;

@RestController
@RequestMapping("/drycleaning")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> addCustomer(@Valid @RequestBody Address address) {
		addressService.addAddress(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	@PutMapping("/updateaddress")
	public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address address) {
		return new ResponseEntity<Address>(addressService.updateAddress(address), HttpStatus.OK);
	}
	
	@GetMapping("/address/viewAllAddress")
	public ResponseEntity<List<Address>> viewAllAddress() throws CustomerNotFoundException {
		return new ResponseEntity<List<Address>>(addressService.getAllAddress(), HttpStatus.OK);
	}
}
