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

/**
 * Controller que lida com as operações relacionadas a carros.
 */
@RestController
@RequestMapping(value = "/cars")
public class CarroController {

    @Autowired
    private CarroService carroService;

    /**
     * Retorna todos os carros disponíveis no formato solicitado no teste.
     *
     * @return Lista de objetos CarsDTO contendo informações de carros.
     */
    @GetMapping("/all")
    public List<CarsDTO> getAll() {
        return carroService.getAllCars();
    }

    /**
     * Retorna todos os carros disponíveis.
     *
     * @return Lista de objetos CarroDTO contendo informações de carros.
     */
    @GetMapping
    public List<CarroDTO> getAllCarros() {
        return carroService.getAllCarros();
    }

    /**
     * Retorna informações de um carro com base no ID fornecido.
     *
     * @param id ID do carro desejado.
     * @return Objeto CarroDTO contendo informações do carro.
     */
    @GetMapping("/{id}")
    public CarroDTO getById(@PathVariable Integer id) {
        return carroService.getCarroById(id);
    }

    /**
     * Cria um novo carro com base nos dados fornecidos.
     *
     * @param carroDTO Objeto CarroDTO contendo informações do novo carro.
     * @return Resposta HTTP com status 201 Created e o ID do novo carro.
     */
    @PostMapping
    public ResponseEntity<Integer> createCarro(
            @RequestBody @Valid final CarroDTO carroDTO) {
        return new ResponseEntity<>(carroService.createCarro(carroDTO), HttpStatus.CREATED);
    }

    /**
     * Atualiza as informações de um carro com base no ID fornecido.
     *
     * @param id       ID do carro a ser atualizado.
     * @param carroDTO Objeto CarroDTO contendo as informações atualizadas.
     * @return Resposta HTTP com status 200 OK e as informações atualizadas do carro.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(
            @PathVariable final Integer id,
            @RequestBody @Valid final CarroDTO carroDTO) {
        CarroDTO updatedCarro = carroService.updateCarro(id, carroDTO);
        return ResponseEntity.ok(updatedCarro);
    }

    /**
     * Deleta carros com base nos IDs fornecidos.
     *
     * @param ids Lista de IDs dos carros a serem deletados.
     * @return Resposta HTTP com status 204 No Content.
     */
    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteCarro(
            @PathVariable final List<Integer> ids) {
        carroService.deleteCarros(ids);
        return ResponseEntity.noContent().build();
    }
}
