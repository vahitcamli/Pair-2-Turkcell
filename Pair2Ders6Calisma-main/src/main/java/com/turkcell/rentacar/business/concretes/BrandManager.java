package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.exceptions.problemDetails.BusinessProblemDetails;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    /*@Override
    public void add(Brand brand) {
        this.brandRepository.save(brand);
    }
     *///AOP nedir?

    @Override
    public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand = brandRepository.save(brand);

        CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(createdBrand, CreateBrandResponse.class);
        return createBrandResponse;
    }

    @Override
    public Brand getById(int id) {
        brandBusinessRules.idIsNotExists(id);
        return brandRepository.findById(id).get();
    }

    @Override
    public List<Brand> getAll() {

        return this.brandRepository.findAll();
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.idIsNotExists(id);
        Brand existsBrand = this.brandRepository.findById(id).get();
        existsBrand.setName(updateBrandRequest.getName());
        existsBrand.setUpdatedDate(LocalDateTime.now());
        Brand updatedBrand = this.brandRepository.save(existsBrand);
        UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(updatedBrand, UpdateBrandResponse.class);
        return updateBrandResponse;
    }

    @Override
    public Brand delete(int id) {
        brandBusinessRules.idIsNotExists(id);
		return brandRepository.delete(id).;;
        
    }
}


//ioc nedir?