package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transmissions")
@AllArgsConstructor
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTransmissionResponse add(@Valid @RequestBody CreateTransmissionRequest createTransmissionRequest){

        return this.transmissionService.add(createTransmissionRequest);
    }

    @GetMapping("/getById/{id}")
    public Transmission getById(@PathVariable int id){
        return this.transmissionService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Transmission> getAll(){
        return this.transmissionService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public UpdateTransmissionResponse update(@PathVariable int id, @RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return this.transmissionService.update(id, updateTransmissionRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.transmissionService.delete(id);
    }
}
