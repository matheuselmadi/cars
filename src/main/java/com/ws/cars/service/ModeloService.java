package com.ws.cars.service;

import com.ws.cars.dto.ModeloDTO;
import com.ws.cars.entity.Marca;
import com.ws.cars.entity.Modelo;
import com.ws.cars.repository.MarcaRepository;
import com.ws.cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional
    public Integer createModelo(final ModeloDTO modeloDTO) {
        final Modelo modelo = new Modelo();
        mapToEntity(modeloDTO, modelo);

        Marca marca = marcaRepository.findById(modeloDTO.getMarcaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada para ID: " + modeloDTO.getMarcaId()));

        modelo.setMarca(marca);
        return modeloRepository.save(modelo).getId();
    }

    @Transactional(readOnly = true)
    public List<ModeloDTO> getAllModelos() {
        final List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream().map(modelo -> mapToDTO(modelo, new ModeloDTO()))
                .toList();
    }

    @Transactional(readOnly = true)
    public ModeloDTO getModeloById(final Integer id) {
        return modeloRepository.findById(id).map(modelo -> mapToDTO(modelo, new ModeloDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado."));
    }

    @Transactional
    public ModeloDTO updateModelo(Integer id, ModeloDTO modeloDTO) {
        Modelo existingModelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        Modelo updatedModelo = mapToEntity(modeloDTO, existingModelo);
        modeloRepository.save(updatedModelo);

        return mapToDTO(updatedModelo, modeloDTO);
    }

    public void deleteModelos(final List<Integer> ids) {
        modeloRepository.deleteAllById(ids);
    }

    private Modelo mapToEntity(
            final ModeloDTO modeloDTO,
            final Modelo modelo) {

        modelo.setId(modeloDTO.getId());
        modelo.setNome(modeloDTO.getNome());
        modelo.setValorFipe(modeloDTO.getValorFipe());

        Marca marca = new Marca();
        marca.setId(modeloDTO.getMarcaId());
        modelo.setMarca(marca);

        return modelo;
    }

    private ModeloDTO mapToDTO(
            final Modelo modelo,
            final ModeloDTO modeloDTO) {

        modeloDTO.setId(modelo.getId());
        modeloDTO.setMarcaId(modelo.getMarca().getId());
        modeloDTO.setNome(modelo.getNome());
        modeloDTO.setValorFipe(modelo.getValorFipe());

        return modeloDTO;
    }
}
