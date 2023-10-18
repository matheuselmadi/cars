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
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloDTO createModelo(@RequestBody @Valid ModeloDTO modeloDTO) {
        return modeloService.createModelo(modeloDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateModelo(
            @PathVariable final Integer id,
            @RequestBody @Valid final ModeloDTO modeloDTO) {
        modeloService.updateModelo(id, modeloDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteModelo(
            @PathVariable final List<Integer> ids) {
        modeloService.deleteModelos(ids);
        return ResponseEntity.noContent().build();
    }
}
