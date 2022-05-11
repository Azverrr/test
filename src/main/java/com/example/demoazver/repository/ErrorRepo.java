package com.example.demoazver.repository;

import com.example.demoazver.controller.ErrorController;
import com.example.demoazver.entity.ErrorEntity;
import com.example.demoazver.model.Error;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ErrorRepo extends CrudRepository<ErrorEntity, Long> {
    ErrorEntity findByTextError(String textError);
    List<ErrorEntity> findAll();
}
