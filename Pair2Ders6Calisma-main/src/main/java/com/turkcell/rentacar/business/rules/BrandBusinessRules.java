package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;
    public void brandNameCanNotBeDuplicated(String brandname){
        Optional<Brand> brand=this.brandRepository.findByNameIgnoreCase(brandname);
        if (brand.isPresent()){
            throw new BusinessException("BrandExists");
        }
    }
    public void idIsNotExists(int id){
        Optional<Brand> existsBrand = this.brandRepository.findById(id);
        if (existsBrand.isEmpty()){
            throw new BusinessException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

}
