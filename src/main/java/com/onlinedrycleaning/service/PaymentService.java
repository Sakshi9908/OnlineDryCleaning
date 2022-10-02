package com.onlinedrycleaning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.exception.IdNotFoundException;
import com.onlinedrycleaning.repository.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	private IPaymentRepository paymentRepo;
	
	
//	public PaymentService(IPaymentRepository paymentRepo) {
//		super();
//		this.paymentRepo = paymentRepo;
//	}

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	@Override
	public String deletePayment(long id) {
		if(paymentRepo.existsById(id))
		{
			try {
			paymentRepo.deleteById(id);
			return "Deleted successfully.";
			}
			catch(Exception o)
			{
				return "Please delete all dependencies and try again.";
			}
		}
		
		return "No record found to delete";
	}
	
	@Override
	public Payment updatePayment(Payment payment) {
		
		return paymentRepo.save(payment);
	
	}
	
	@Override
	public Payment getPaymentDetails(long id) throws IdNotFoundException
	{
		Optional<Payment> payment = paymentRepo.findById(id);
		  if(payment.isPresent())
				return payment.get();
		  throw new IdNotFoundException("Payment");
		
	}
	
	@Override
	public List<Payment> getAllPaymentDetails() throws IdNotFoundException{
		
		return paymentRepo.findAll();
		
	}
	
}
