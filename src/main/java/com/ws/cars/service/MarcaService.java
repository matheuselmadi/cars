package com.ws.cars.service;

import com.ws.cars.dto.MarcaDTO;
import com.ws.cars.entity.Marca;
import com.ws.cars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Classe de serviço para lidar com operações relacionadas a marcas de carros.
 *
 * Esta classe fornece métodos para criar, atualizar, recuperar e excluir informações de carros.
 * Ela também lida com a transformação de dados entre DTOs (Data Transfer Objects) e entidades de carro.
 */
@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    /**
     * Cria uma nova marca com base nos dados fornecidos e a salva no repositório.
     *
     * @param marcaDTO Os dados da marca a ser criada.
     * @return Um objeto MarcaDTO representando a marca criada.
     */
    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        return mapToDTO(marcaRepository.save(mapToEntity(marcaDTO)));
    }

    /**
     * Obtém todas as marcas do repositório.
     *
     * @return Uma lista de MarcaDTOs representando todas as marcas.
     */
    public List<MarcaDTO> getAllMarcas() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas.stream().map(this::mapToDTO).toList();
    }

    /**
     * Obtém uma marca com base no ID fornecido.
     *
     * @param id O ID da marca a ser recuperada.
     * @return Um objeto MarcaDTO representando a marca encontrada.
     * @throws ResponseStatusException Se a marca não for encontrada.
     */
    public MarcaDTO getMarcaById(Integer id) {
        return mapToDTO(marcaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada.")));
    }

    /**
     * Atualiza uma marca existente com base no ID fornecido e nos dados fornecidos.
     *
     * @param id       O ID da marca a ser atualizada.
     * @param marcaDTO Os novos dados da marca.
     * @return Um objeto MarcaDTO representando a marca atualizada.
     * @throws ResponseStatusException Se a marca não for encontrada.
     */
    @Transactional
    public MarcaDTO updateMarca(Integer id, MarcaDTO marcaDTO) {
        Marca existingMarca = marcaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingMarca.setId(marcaDTO.getId());
        existingMarca.setNomeMarca(marcaDTO.getNomeMarca());

        marcaRepository.save(existingMarca);

        return mapToDTO(existingMarca);
    }

    /**
     * Exclui marcas com base em uma lista de IDs fornecida.
     *
     * @param ids A lista de IDs das marcas a serem excluídas.
     */
    public void deleteMarcas(final List<Integer> ids) {
        marcaRepository.deleteAllById(ids);
    }

    /**
     * Converte um objeto MarcaDTO em um objeto Marca.
     *
     * @param marcaDTO O objeto MarcaDTO a ser convertido.
     * @return Um objeto Marca correspondente.
     */
    private Marca mapToEntity(MarcaDTO marcaDTO) {
        Marca marca = new Marca();
        marca.setId(marcaDTO.getId());
        marca.setNomeMarca(marcaDTO.getNomeMarca());

        return marca;
    }

    /**
     * Converte um objeto Marca em um objeto MarcaDTO.
     *
     * @param marca O objeto Marca a ser convertido.
     * @return Um objeto MarcaDTO correspondente.
     */
    private MarcaDTO mapToDTO(Marca marca) {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setId(marca.getId());
        marcaDTO.setNomeMarca(marca.getNomeMarca());

        return marcaDTO;
    }
}
