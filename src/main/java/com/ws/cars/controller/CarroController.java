package com.ws.cars.controller;

import com.ws.cars.dto.CarroDTO;
import com.ws.cars.dto.CarsDTO;
import com.ws.cars.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/all")
    public List<CarsDTO> getAll() {
        return carroService.getAllCars();
    }

    @GetMapping
    public List<CarroDTO> getAllCarros() {
        return carroService.getAllCarros();
    }

    @GetMapping("/{id}")
    public CarroDTO getById(@PathVariable Integer id) {
        return carroService.getCarroById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> createCarro(
            @RequestBody @Valid final CarroDTO carroDTO) {
        return new ResponseEntity<>(carroService.createCarro(carroDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(
            @PathVariable final Integer id,
            @RequestBody @Valid final CarroDTO carroDTO) {
        CarroDTO updatedCarro = carroService.updateCarro(id, carroDTO);
        return ResponseEntity.ok(updatedCarro);
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteCarro(
            @PathVariable final List<Integer> ids) {
        carroService.deleteCarros(ids);
        return ResponseEntity.noContent().build();
    }
}
