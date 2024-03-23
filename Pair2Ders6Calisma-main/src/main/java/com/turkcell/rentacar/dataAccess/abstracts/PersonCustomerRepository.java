package com.turkcell.rentacar.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentacar.entities.customers.PersonCustomer;

public interface PersonCustomerRepository extends JpaRepository<PersonCustomer, Integer>{
	Optional<PersonCustomer> findByNationalId(String nationalId);
}
