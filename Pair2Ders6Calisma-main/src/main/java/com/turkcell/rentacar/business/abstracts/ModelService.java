package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.business.dtos.requests.creates.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateModelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    CreateModelResponse add(CreateModelRequest createModelRequest);
    List<Model> getAll();
    Model getById(int id);
    UpdateModelResponse update(int id, UpdateModelRequest updateModelRequest);
    void delete (int id);
}

