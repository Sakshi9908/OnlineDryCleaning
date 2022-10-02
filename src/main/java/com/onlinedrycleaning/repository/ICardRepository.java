package com.onlinedrycleaning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinedrycleaning.entity.Card;

public interface ICardRepository extends JpaRepository<Card, Long> {

}
