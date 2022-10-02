package com.onlinedrycleaning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Card;
import com.onlinedrycleaning.exception.IdNotFoundException;

@Service
public interface ICardService {
	
public Card addCard(Card card);
	
	public String deleteCard(long id);
	
	public Card getCardDetails(long id) throws IdNotFoundException;
	
	public List<Card> getAllCardDetails();
}
