package com.turkcell.rentacar.business.rules;

import java.util.Optional;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.PersonCustomerRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.customers.PersonCustomer;

public class PersonCustomerBusinessRules {
	PersonCustomerRepository personCustomerRepository;
	
	 public void nationalIdCanNotBeDuplicated(String nationalId){
	        Optional<PersonCustomer> personCustomer=this.personCustomerRepository.findByNationalId(nationalId);
	        if (personCustomer.isPresent()){
	            throw new BusinessException("Person Exists");
	        }
	    }
	    public void idIsNotExists(int id){
	        Optional<PersonCustomer> personCustomer = this.personCustomerRepository.findById(id);
	        if (personCustomer.isEmpty()){
	            throw new BusinessException("Veri tabanında bu idye karşılık bir veri mevcut değil");
	        }
	    }
}
