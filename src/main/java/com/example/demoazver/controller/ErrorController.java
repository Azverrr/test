package com.example.demoazver.controller;

import com.example.demoazver.entity.ErrorEntity;
import com.example.demoazver.exception.ErrorNotFoundException;
import com.example.demoazver.exception.TextErrorAlreadyExistException;
import com.example.demoazver.repository.ErrorRepo;
import com.example.demoazver.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/errors")
public class ErrorController {

    @Autowired
    public ErrorService errorService;

    @Autowired
    public ErrorRepo errorRepo;

    @PostMapping
    public ResponseEntity registartion(@RequestBody ErrorEntity error) {
        try {
            errorService.registration(error);
            return ResponseEntity.ok("Ошибка сохранена");
        }catch (TextErrorAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping
    public ResponseEntity getOneError(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(errorService.getOne(id));
        }catch (ErrorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(errorService.getAll());
    }
    @GetMapping("allv")
    public ResponseEntity getAllv() {
        return ResponseEntity.ok(errorService.getAllv());
    }

}
