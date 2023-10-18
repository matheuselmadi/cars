package com.ws.cars.controller;

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

    @GetMapping
    public List<CarsDTO> getAll() {
        return carroService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarsDTO getById(@PathVariable Integer id) {
        return carroService.getCarroById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarsDTO createCarro(@RequestBody @Valid CarsDTO carsDTO) {
        return carroService.createCarro(carsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCarro(
            @PathVariable final Integer id,
            @RequestBody @Valid final CarsDTO carsDTO) {
        carroService.updateCarro(id, carsDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteCarro(
            @PathVariable final List<Integer> ids) {
        carroService.deleteCarros(ids);
        return ResponseEntity.noContent().build();
    }
}
