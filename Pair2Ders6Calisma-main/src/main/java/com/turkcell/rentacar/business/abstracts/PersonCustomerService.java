package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.requests.creates.CreatePersonCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdatePersonCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedPersonCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatePersonCustomerResponse;

public interface PersonCustomerService {
	CreatedPersonCustomerResponse add(CreatePersonCustomerRequest createPersonCustomerRequest);
	List<UpdatePersonCustomerResponse> getall();
	UpdatePersonCustomerResponse getById(int id);
	void delete(int id);
	UpdatePersonCustomerResponse update(UpdatePersonCustomerRequest updatePersonCustomerRequest);

}
