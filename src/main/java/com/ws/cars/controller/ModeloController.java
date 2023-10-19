package com.ws.cars.controller;

import com.ws.cars.dto.ModeloDTO;
import com.ws.cars.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<ModeloDTO> getAll() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public ModeloDTO getById(@PathVariable Integer id) {
        return modeloService.getModeloById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> createModelo(
            @RequestBody @Valid final ModeloDTO modeloDTO) {
        return new ResponseEntity<>(modeloService.createModelo(modeloDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModelo(
            @PathVariable Integer id,
            @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO updatedModelo = modeloService.updateModelo(id, modeloDTO);
        return ResponseEntity.ok(updatedModelo);
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteModelo(
            @PathVariable final List<Integer> ids) {
        modeloService.deleteModelos(ids);
        return ResponseEntity.noContent().build();
    }
}
