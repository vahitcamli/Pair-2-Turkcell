package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.business.dtos.requests.creates.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;

import java.util.List;

public interface TransmissionService {
    CreateTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    List<Transmission> getAll();
    Transmission getById(int id);
    UpdateTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest);
    void delete (int id);
}
