package com.ws.cars.service;

import com.ws.cars.dto.CarsDTO;
import com.ws.cars.entity.Carro;
import com.ws.cars.entity.Modelo;
import com.ws.cars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarsDTO> getAllCars() {
        List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(carro -> mapToDTO(carro, new CarsDTO())).toList();
    }

    private CarsDTO mapToDTO(
            final Carro carro,
            final CarsDTO carsDTO) {

        Modelo modelo = new Modelo();
        carsDTO.setId(carro.getId());
        carsDTO.setTimestampCadastro(carro.getTimestampCadastro());
        carsDTO.setModeloId(carro.getModeloId().getId());
        carsDTO.setAno(carro.getAno());
        carsDTO.setCombustivel(carro.getCombustivel());
        carsDTO.setNumPortas(carro.getNumPortas());
        carsDTO.setCor(carro.getCor());
        carsDTO.setNomeModelo(carro.getModeloId().getNome());
        carsDTO.setValor(modelo.getValor_fipe());
        carsDTO.setBrand(modelo.getMarcaId());

        return carsDTO;
    }
}
