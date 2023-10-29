package com.ws.cars.controller;

import com.ws.cars.dto.ModeloDTO;
import com.ws.cars.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciar operações relacionadas aos modelos de carros.
 */
@RestController
@RequestMapping(value = "/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    /**
     * Obtém todos os modelos de carros.
     *
     * @return Uma lista de objetos ModeloDTO representando os modelos de carros.
     */
    @GetMapping
    public List<ModeloDTO> getAll() {
        return modeloService.getAllModelos();
    }

    /**
     * Obtém um modelo de carro pelo ID.
     *
     * @param id O ID do modelo de carro a ser obtido.
     * @return Um objeto ModeloDTO representando o modelo de carro correspondente ao ID.
     */
    @GetMapping("/{id}")
    public ModeloDTO getById(@PathVariable Integer id) {
        return modeloService.getModeloById(id);
    }

    /**
     * Cria um novo modelo de carro.
     *
     * @param modeloDTO O objeto ModeloDTO que contém os detalhes do novo modelo de carro.
     * @return Um objeto ResponseEntity contendo o ID do modelo criado e o status HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Integer> createModelo(
            @RequestBody @Valid final ModeloDTO modeloDTO) {
        return new ResponseEntity<>(modeloService.createModelo(modeloDTO), HttpStatus.CREATED);
    }

    /**
     * Atualiza um modelo de carro existente.
     *
     * @param id        O ID do modelo de carro a ser atualizado.
     * @param modeloDTO O objeto ModeloDTO com as informações atualizadas.
     * @return Um objeto ResponseEntity contendo o modelo de carro atualizado e o status HTTP 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModelo(
            @PathVariable Integer id,
            @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO updatedModelo = modeloService.updateModelo(id, modeloDTO);
        return ResponseEntity.ok(updatedModelo);
    }

    /**
     * Exclui um ou mais modelos de carros pelo ID.
     *
     * @param ids Uma lista de IDs de modelos de carros a serem excluídos.
     * @return Um objeto ResponseEntity com status HTTP 204 (No Content) indicando que a exclusão foi bem-sucedida.
     */
    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteModelo(
            @PathVariable final List<Integer> ids) {
        modeloService.deleteModelos(ids);
        return ResponseEntity.noContent().build();
    }
}
