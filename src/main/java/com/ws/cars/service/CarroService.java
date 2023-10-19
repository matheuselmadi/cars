package com.ws.cars.service;

import com.ws.cars.dto.CarroDTO;
import com.ws.cars.dto.CarsDTO;
import com.ws.cars.entity.Carro;
import com.ws.cars.entity.Modelo;
import com.ws.cars.repository.CarroRepository;
import com.ws.cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional
    public Integer createCarro(final CarroDTO carroDTO) {
        final Carro carro = new Carro();
        mapToEntity(carroDTO, carro);

        Modelo modelo = modeloRepository.findById(carroDTO.getModeloId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado para ID: " + carroDTO.getModeloId()));

        carro.setModelo(modelo);
        return carroRepository.save(carro).getId();
    }

    public List<CarsDTO> getAllCars() {
        List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(this::mapCarsToDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<CarroDTO> getAllCarros() {
        final List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(carro -> mapToDTO(carro, new CarroDTO()))
                .toList();
    }

    @Transactional(readOnly = true)
    public CarroDTO getCarroById(final Integer id) {
        return carroRepository.findById(id).map(carro -> mapToDTO(carro, new CarroDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado."));
    }

    @Transactional
    public CarroDTO updateCarro(Integer id, CarroDTO carroDTO) {
        Carro existingCarro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado."));

        Carro updatedCarro = mapToEntity(carroDTO, existingCarro);
        carroRepository.save(updatedCarro);

        return mapToDTO(updatedCarro, carroDTO);
    }

    public void deleteCarros(final List<Integer> ids) {
        carroRepository.deleteAllById(ids);
    }

    private Carro mapToEntity(
            final CarroDTO carroDTO,
            final Carro carro) {

        carro.setId(carroDTO.getId());
        carro.setTimestampCadastro(carroDTO.getTimestampCadastro());
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setNumPortas(carroDTO.getNumPortas());
        carro.setCor(carroDTO.getCor());

        Modelo modelo = new Modelo();
        modelo.setId(carroDTO.getModeloId());
        carro.setModelo(modelo);

        return carro;
    }

    private CarroDTO mapToDTO(
            final Carro carro,
            final CarroDTO carroDTO) {

        carroDTO.setId(carro.getId());
        carroDTO.setTimestampCadastro(carro.getTimestampCadastro());
        carroDTO.setModeloId(carro.getModelo().getId());
        carroDTO.setAno(carro.getAno());
        carroDTO.setCombustivel(carro.getCombustivel());
        carroDTO.setNumPortas(carro.getNumPortas());
        carroDTO.setCor(carro.getCor());

        return carroDTO;
    }

    private CarsDTO mapCarsToDTO(Carro carro) {

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
