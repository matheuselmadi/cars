package com.ws.cars.controller;

import com.ws.cars.dto.MarcaDTO;
import com.ws.cars.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciar operações relacionadas a marcas de carros.
 */
@RestController
@RequestMapping(value = "/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    /**
     * Obtém todas as marcas de carros.
     *
     * @return Lista de objetos MarcaDTO representando todas as marcas.
     */
    @GetMapping
    public List<MarcaDTO> getAll() {
        return marcaService.getAllMarcas();
    }

    /**
     * Obtém uma marca de carro pelo ID.
     *
     * @param id O ID da marca a ser obtida.
     * @return O objeto MarcaDTO correspondente ao ID especificado.
     */
    @GetMapping("/{id}")
    public MarcaDTO getById(@PathVariable Integer id) {
        return marcaService.getMarcaById(id);
    }

    /**
     * Cria uma nova marca de carro.
     *
     * @param marcaDTO Os dados da nova marca a ser criada.
     * @return O objeto MarcaDTO representando a marca criada.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarcaDTO createMarca(@RequestBody @Valid MarcaDTO marcaDTO) {
        return marcaService.createMarca(marcaDTO);
    }

    /**
     * Atualiza uma marca de carro existente.
     *
     * @param id       O ID da marca a ser atualizada.
     * @param marcaDTO Os novos dados da marca.
     * @return Um ResponseEntity contendo o objeto MarcaDTO atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> updateMarca(
            @PathVariable Integer id,
            @RequestBody @Valid MarcaDTO marcaDTO) {
        MarcaDTO updateMarca = marcaService.updateMarca(id, marcaDTO);
        return ResponseEntity.ok(updateMarca);
    }

    /**
     * Exclui uma ou mais marcas de carros pelo ID.
     *
     * @param ids Lista de IDs das marcas a serem excluídas.
     * @return Um ResponseEntity indicando que a operação foi bem-sucedida.
     */
    @DeleteMapping("/{ids}")
    public ResponseEntity<Void> deleteMarca(
            @PathVariable final List<Integer> ids) {
        marcaService.deleteMarcas(ids);
        return ResponseEntity.noContent().build();
    }
}
