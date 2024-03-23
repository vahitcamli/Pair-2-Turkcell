package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.requests.creates.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateCorporateCustomerResponse;

public interface CorporateCustomerService {
	CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
	List<UpdateCorporateCustomerResponse> getall();
	UpdateCorporateCustomerResponse getById(int id);
	void delete(int id);
	UpdateCorporateCustomerResponse update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
}
