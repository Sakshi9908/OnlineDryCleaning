package com.onlinedrycleaning.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.exception.IdNotFoundException;

import com.onlinedrycleaning.service.IPaymentService;


@RestController
@RequestMapping("/drycleaning")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment pay)
	{
		paymentService.addPayment(pay);
		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment pay) throws IdNotFoundException 
	{
		Payment val = paymentService.getPaymentDetails(pay.getPaymentId());
		if(val!=null) {
			throw new IdNotFoundException("Payment");
		}
		Payment obj = paymentService.updatePayment(pay);
		return new ResponseEntity<Payment>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePayment/{paymentId}")
	public ResponseEntity<String> deletePayment (@PathVariable long paymentId)
	{
		String status=paymentService.deletePayment(paymentId);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
	@GetMapping("/viewPayment/{paymentId}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable long paymentId) throws com.onlinedrycleaning.exception.IdNotFoundException 
	{
		Payment val=paymentService.getPaymentDetails(paymentId);
		if(val==null)
			throw new IdNotFoundException("Payment");
		
		return new ResponseEntity<Payment>(val,HttpStatus.OK);
	}
	
	@GetMapping("/viewallPayments")
	public ResponseEntity<List<Payment>> getAllPaymentDetails() throws IdNotFoundException {
		List<Payment> list=paymentService.getAllPaymentDetails();
		if(list.isEmpty())
			throw new IdNotFoundException("Payment");;
		return new ResponseEntity<List<Payment>>(list,HttpStatus.OK);
	}
		
}
