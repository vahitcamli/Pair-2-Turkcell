package com.turkcell.rentacar.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.rentacar.entities.customers.CorporateCustomer;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer>{
	Optional<CorporateCustomer> findByTaxIdNumber(String taxIdNumber);
}
