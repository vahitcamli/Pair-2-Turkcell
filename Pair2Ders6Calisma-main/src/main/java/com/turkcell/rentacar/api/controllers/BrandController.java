package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {
    private BrandService brandService; //Ioc
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest){

        return this.brandService.add(createBrandRequest);
    }

    @GetMapping("/getById/{id}")
    public Brand gsetById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Brand> getAll(){
        return this.brandService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest){
        return this.brandService.update(id, updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.brandService.delete(id);
    }
}
