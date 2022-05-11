package com.example.demoazver.service;

import com.example.demoazver.entity.ErrorEntity;
import com.example.demoazver.exception.ErrorNotFoundException;
import com.example.demoazver.exception.TextErrorAlreadyExistException;
import com.example.demoazver.model.Error;
import com.example.demoazver.repository.ErrorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {

    @Autowired
    public ErrorRepo errorRepo;

    public ErrorEntity registration(ErrorEntity error) throws TextErrorAlreadyExistException {
        if(errorRepo.findByTextError(error.getTextError()) != null){
            throw new TextErrorAlreadyExistException("Ошибка с таким textError уже существует");
        }
        return errorRepo.save(error);
    }

    public ErrorEntity getOne(Long id) throws ErrorNotFoundException {
        ErrorEntity error = errorRepo.findById(id).get();
        if (error == null) {
            throw new ErrorNotFoundException("Ошибка с таким ID не найдена");
        }
        return error;
    }

    public List<ErrorEntity> getAll(){
        List<ErrorEntity> error = errorRepo.findAll();
        return error;
    }
    public List<Error> getAllv()  {
        List<ErrorEntity> error = errorRepo.findAll();

        return Error.toModel(error)
    }

}
