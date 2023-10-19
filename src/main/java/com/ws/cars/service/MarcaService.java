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

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        return mapToDTO(marcaRepository.save(mapToEntity(marcaDTO)));
    }

    public List<MarcaDTO> getAllMarcas() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas.stream().map(this::mapToDTO).toList();
    }

    public MarcaDTO getMarcaById(Integer id) {
        return mapToDTO(marcaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada.")));
    }

    @Transactional
    public MarcaDTO updateMarca(Integer id, MarcaDTO marcaDTO) {
        Marca existingMarca = marcaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingMarca.setId(marcaDTO.getId());
        existingMarca.setNomeMarca(marcaDTO.getNomeMarca());

        marcaRepository.save(existingMarca);

        return mapToDTO(existingMarca);
    }

    public void deleteMarcas(final List<Integer> ids) {
        marcaRepository.deleteAllById(ids);
    }

    private Marca mapToEntity(MarcaDTO marcaDTO) {

        Marca marca = new Marca();
        marca.setId(marcaDTO.getId());
        marca.setNomeMarca(marcaDTO.getNomeMarca());

        return marca;
    }

    private MarcaDTO mapToDTO(Marca marca) {

        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setId(marca.getId());
        marcaDTO.setNomeMarca(marca.getNomeMarca());

        return marcaDTO;
    }
}
