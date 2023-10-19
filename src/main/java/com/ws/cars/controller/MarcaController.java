package com.ws.cars.controller;

import com.ws.cars.dto.MarcaDTO;
import com.ws.cars.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<MarcaDTO> getAll() {
        return marcaService.getAllMarcas();
    }

    @GetMapping("/{id}")
    public MarcaDTO getById(@PathVariable Integer id) {
        return marcaService.getMarcaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarcaDTO createMarca(@RequestBody @Valid MarcaDTO marcaDTO) {
        return marcaService.createMarca(marcaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> updateMarca(
            @PathVariable Integer id,
            @RequestBody @Valid MarcaDTO marcaDTO) {
        MarcaDTO updateMarca = marcaService.updateMarca(id, marcaDTO);
        return ResponseEntity.ok(updateMarca);
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteMarca(
            @PathVariable final List<Integer> ids) {
        marcaService.deleteMarcas(ids);
        return ResponseEntity.noContent().build();
    }
}
