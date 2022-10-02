package com.onlinedrycleaning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinedrycleaning.entity.Order;


@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findById(long bookingId);
}
