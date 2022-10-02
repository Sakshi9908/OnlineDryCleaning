package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.exception.IdNotFoundException;

@Service
public interface IPaymentService {

	public Payment addPayment(Payment payment);

	public String deletePayment(long id);

	public Payment updatePayment(Payment payment);

	public Payment getPaymentDetails(long id) throws IdNotFoundException;

	public List<Payment> getAllPaymentDetails() throws IdNotFoundException;

	public Page<Payment> getPaymentPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}
