package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateModelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return this.modelService.add(createModelRequest);
    }
    @GetMapping("/getById/{id}")
    public Model getById(@PathVariable int id){
        return this.modelService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Model> getAll(){
        return this.modelService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest updateModelRequest){
        return this.modelService.update(id, updateModelRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.modelService.delete(id);
    }


}
