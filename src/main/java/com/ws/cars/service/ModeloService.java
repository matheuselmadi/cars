package com.ws.cars.service;

import com.ws.cars.dto.ModeloDTO;
import com.ws.cars.entity.Marca;
import com.ws.cars.entity.Modelo;
import com.ws.cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public ModeloDTO createModelo(ModeloDTO modeloDTO) {
        return mapToDTO(modeloRepository.save(mapToEntity(modeloDTO)));
    }

    public List<ModeloDTO> getAllModelos() {
        List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream().map(this::mapToDTO).toList();
    }

    public ModeloDTO getModeloById(Integer id) {
        return mapToDTO(modeloRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado.")));
    }

    public void updateModelo(Integer id, ModeloDTO modeloDTO) {
        final Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(modeloDTO);
        modeloRepository.save(modelo);
    }

    public void deleteModelos(final List<Integer> ids) {
        modeloRepository.deleteAllById(ids);
    }

    private Modelo mapToEntity(ModeloDTO modeloDTO) {

        Modelo modelo = new Modelo();
        modelo.setId(modeloDTO.getId());
        modelo.setNome(modeloDTO.getNome());
        modelo.setValorFipe(modeloDTO.getValorFipe());

        Marca marca = new Marca();
        marca.setId(modeloDTO.getMarcaId());
        modelo.setMarca(marca);

        return modelo;
    }

    private ModeloDTO mapToDTO(Modelo modelo) {

        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(modelo.getId());
        modeloDTO.setMarcaId(modelo.getMarca().getId());
        modeloDTO.setNome(modelo.getNome());
        modeloDTO.setValorFipe(modelo.getValorFipe());

        return modeloDTO;
    }
}
