package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.creates.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest createBrandRequest);
    List<Brand> getAll();
    Brand getById(int id);
    UpdateBrandResponse update(int id, UpdateBrandRequest updateBrandRequest);
    Brand delete (int id);
}
