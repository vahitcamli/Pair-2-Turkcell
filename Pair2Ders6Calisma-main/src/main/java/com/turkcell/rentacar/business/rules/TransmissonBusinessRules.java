package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissonBusinessRules {
    private TransmissionRepository transmissionRepository;
    public void transmissionNameCanNotBeDuplicated(String transmissionName){
        Optional<Transmission> transmission=this.transmissionRepository.findByNameIgnoreCase(transmissionName);
        if (transmission.isPresent()){
            throw new BusinessException("TransmissionExists");
        }
    }
}
