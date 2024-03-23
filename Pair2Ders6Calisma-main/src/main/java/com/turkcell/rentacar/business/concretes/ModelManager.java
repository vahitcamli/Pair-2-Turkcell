package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.updates.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateModelResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdateModelResponse;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;
    @Override
    public CreateModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCanNotBeDuplicated(createModelRequest.getName());
        Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel =this.modelRepository.save(model);
        CreateModelResponse createModelResponse=this.modelMapperService.forResponse().map(createdModel,CreateModelResponse.class);
        return createModelResponse;

    }

    @Override
    public List<Model> getAll() {

        return this.modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        Optional<Model> existsModel=this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            return existsModel.get();
        }
        else{
            throw new FindException("Veri tabanında bu ID'ye karşılık bir veri bulunamadı");
        }
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest updateModelRequest) {
        Optional<Model> existsModel=this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            existsModel.get().setName(updateModelRequest.getName());
            existsModel.get().setUpdatedDate(LocalDateTime.now());
            Model updatedModel=this.modelRepository.save(existsModel.get());

            UpdateModelResponse updateModelResponse=this.modelMapperService.forResponse().map(updatedModel,UpdateModelResponse.class);
            return updateModelResponse;
        }
        else{
            throw new FindException("Veri tabanında bu ID'ye karşılık bir veri bulunamadı");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Model> existsModel=this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            this.modelRepository.deleteById(id);
        }
        else{
            throw new FindException("Veri tabanında bu ID'ye karşılık bir veri bulunamadı");
        }
    }
}
