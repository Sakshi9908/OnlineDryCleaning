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

import com.onlinedrycleaning.entity.Card;
import com.onlinedrycleaning.service.ICardService;
import com.onlinedrycleaning.exception.IdNotFoundException;

@RestController
@RequestMapping("/drycleaning")
public class CardController {

	@Autowired
	private ICardService cardService;

	@PostMapping("/addcard")
	public ResponseEntity<Card> addCard(@Valid @RequestBody Card card) {

		Card obj = cardService.addCard(card);
		return new ResponseEntity<Card>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/deletecard/{cardId}")
	public ResponseEntity<String> deleteCard(@PathVariable long cardId) {
		String status = cardService.deleteCard(cardId);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@PutMapping("/updateCard")
	public ResponseEntity<Card> updateCard(@Valid @RequestBody Card card) {
		return new ResponseEntity<Card>(cardService.updateCard(card), HttpStatus.OK);
	}

	@GetMapping("/viewcard/{cardId}")
	public ResponseEntity<Card> getCardDetails(@PathVariable long cardId) throws IdNotFoundException {
		Card val = cardService.getCardDetails(cardId);
		if (val == null)
			throw new IdNotFoundException("Card");

		return new ResponseEntity<Card>(val, HttpStatus.OK);
	}

	@GetMapping("/viewallcards")
	public ResponseEntity<List<Card>> getAllCardDetails() throws IdNotFoundException {
		List<Card> list = cardService.getAllCardDetails();
		if (list.isEmpty())
			throw new IdNotFoundException("Card");
		return new ResponseEntity<List<Card>>(list, HttpStatus.OK);
	}

}
