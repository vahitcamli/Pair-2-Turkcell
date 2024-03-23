package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateTransmissionResponse;
import com.turkcell.rentacar.business.rules.TransmissonBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissonBusinessRules transmissonBusinessRules;
    @Override
    public CreateTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissonBusinessRules.transmissionNameCanNotBeDuplicated(createTransmissionRequest.getName());
        Transmission transmission=this.modelMapperService.forRequest().map(createTransmissionRequest,Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmission  =this.transmissionRepository.save(transmission);
        CreateTransmissionResponse createTransmissionResponse=this.modelMapperService.forResponse().map(createdTransmission,CreateTransmissionResponse.class);
        return createTransmissionResponse;

    }

    @Override
    public List<Transmission> getAll() {

        return this.transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            return existsTransmission.get();
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }
    }

    @Override
    public UpdateTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            existsTransmission.get().setName(updateTransmissionRequest.getName());
            existsTransmission.get().setUpdatedDate(LocalDateTime.now());
            Transmission updatedTransmission=this.transmissionRepository.save(existsTransmission.get());

            UpdateTransmissionResponse updateTransmissionResponse=this.modelMapperService.forResponse().map(updatedTransmission,UpdateTransmissionResponse.class);
            return updateTransmissionResponse;
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }

    }

    @Override
    public void delete(int id) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            this.transmissionRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }
    }
}
