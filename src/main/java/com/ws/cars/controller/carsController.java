package com.ws.cars.controller;

import com.ws.cars.dto.CarsDTO;
import com.ws.cars.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class carsController {

    @Autowired
    private CarsService carsService;

    @GetMapping
    public List<CarsDTO> getAll(){
        return carsService.getAllCars();
    }
}
