package com.onlinedrycleaning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedrycleaning.entity.Card;
import com.onlinedrycleaning.exception.IdNotFoundException;
//import com.onlinedrycleaning.entity.Payment;
import com.onlinedrycleaning.repository.ICardRepository;

@Service
public class CardService implements ICardService {

	@Autowired
	private ICardRepository cardRepo;

	public CardService(ICardRepository cardRepo) {
		super();
		this.cardRepo = cardRepo;
	}

	@Override
	public Card addCard(Card card) {
		return cardRepo.save(card);
	}

	@Override
	public String deleteCard(long id) {
		if (cardRepo.existsById(id)) {
			try {
				cardRepo.deleteById(id);
				return "Deleted Successfully.";
			} catch (Exception o) {
				return "Please delete all dependencies and try again.";
			}
		}

		return "No record found to delete.";
	}

	@Override
	public Card getCardDetails(long id) throws IdNotFoundException {
		Optional<Card> card = cardRepo.findById(id);
		if (card.isPresent())
			return card.get();
		throw new IdNotFoundException("Card");
	}

	@Override
	public List<Card> getAllCardDetails() {
		return cardRepo.findAll();
	}

}
