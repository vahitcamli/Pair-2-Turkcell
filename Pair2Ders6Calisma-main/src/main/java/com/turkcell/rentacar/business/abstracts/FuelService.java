package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.business.dtos.requests.creates.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateFuelResponse;
import com.turkcell.rentacar.entities.concretes.Fuel;

import java.util.List;

public interface FuelService {
    CreateFuelResponse add(CreateFuelRequest createFuelRequest);
    List<Fuel> getAll();
    Fuel getById(int id);

    UpdateFuelResponse update(int id, UpdateFuelRequest updateFuelRequest);
    void delete (int id);
}
