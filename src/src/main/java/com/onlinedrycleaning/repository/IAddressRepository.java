package com.onlinedrycleaning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinedrycleaning.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer>{

}
