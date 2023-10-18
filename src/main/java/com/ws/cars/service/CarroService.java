package com.ws.cars.service;

import com.ws.cars.dto.CarsDTO;
import com.ws.cars.entity.Carro;
import com.ws.cars.entity.Modelo;
import com.ws.cars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public CarsDTO createCarro(CarsDTO carsDTO) {
        return mapToDTO(carroRepository.save(mapCarroToEntity(carsDTO)));
    }

    public List<CarsDTO> getAllCars() {
        List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(this::mapToDTO).toList();
    }

    public CarsDTO getCarroById(Integer id) {
        return mapToDTO(carroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado.")));
    }

    public void updateCarro(Integer id, CarsDTO carsDTO) {
        final Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapCarroToEntity(carsDTO);
        carroRepository.save(carro);
    }

    public void deleteCarros(final List<Integer> ids) {carroRepository.deleteAllById(ids);}

    private Carro mapCarroToEntity(CarsDTO carsDTO) {

        Carro carro = new Carro();
        carro.setId(carsDTO.getId());
        carro.setTimestampCadastro(carsDTO.getTimestampCadastro());
        carro.setAno(carsDTO.getAno());
        carro.setCombustivel(carsDTO.getCombustivel());
        carro.setNumPortas(carsDTO.getNumPortas());
        carro.setCor(carsDTO.getCor());

        Modelo modelo = new Modelo();
        modelo.setId(carsDTO.getModeloId());
        carro.setModelo(modelo);

        return carro;
    }

    private CarsDTO mapToDTO(Carro carro) {

        CarsDTO carsDTO = new CarsDTO();
        carsDTO.setId(carro.getId());
        carsDTO.setTimestampCadastro(carro.getTimestampCadastro());
        carsDTO.setModeloId(carro.getModelo().getId());
        carsDTO.setAno(carro.getAno());
        carsDTO.setCombustivel(carro.getCombustivel());
        carsDTO.setNumPortas(carro.getNumPortas());
        carsDTO.setCor(carro.getCor());
        carsDTO.setNomeModelo(carro.getModelo().getNome());
        carsDTO.setValor(carro.getModelo().getValorFipe());
        carsDTO.setBrand(carro.getModelo().getMarca().getId());

        return carsDTO;
    }
}
