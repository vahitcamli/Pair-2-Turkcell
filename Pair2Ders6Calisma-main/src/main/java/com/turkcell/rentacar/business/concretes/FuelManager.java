package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateFuelResponse;
import com.turkcell.rentacar.business.rules.FuelBusinessRules;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;
    @Override
    public CreateFuelResponse add(CreateFuelRequest createFuelRequest)
    {
        fuelBusinessRules.fuelNameCanNotBeDuplicated(createFuelRequest.getName());
        Fuel fuel=this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel =this.fuelRepository.save(fuel);
        CreateFuelResponse createFuelResponse=this.modelMapperService.forResponse().map(createdFuel,CreateFuelResponse.class);
        return createFuelResponse;
    }

    @Override
    public Fuel getById(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            return existsFuel.get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public List<Fuel> getAll() {
        return this.fuelRepository.findAll();
    }

    @Override
    public UpdateFuelResponse update(int id, UpdateFuelRequest updateFuelRequest) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            existsFuel.get().setName(updateFuelRequest.getName());
            existsFuel.get().setUpdatedDate(LocalDateTime.now());
            Fuel updatedFuel=this.fuelRepository.save(existsFuel.get());

           UpdateFuelResponse updateFuelResponse=this.modelMapperService.forResponse().map(updatedFuel,UpdateFuelResponse.class);
            return updateFuelResponse;
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            this.fuelRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }

    }
}
