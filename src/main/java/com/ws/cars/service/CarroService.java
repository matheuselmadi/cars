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

/**
 * Classe de serviço para lidar com operações relacionadas a carros.
 *
 * Esta classe fornece métodos para criar, atualizar, recuperar e excluir informações de carros.
 * Ela também lida com a transformação de dados entre DTOs (Data Transfer Objects) e entidades de carro.
 */
@Service
public class CarroService {

    /**
     * Repositório para entidades de carros.
     */
    @Autowired
    private CarroRepository carroRepository;

    /**
     * Repositório para entidades de modelos de carro.
     */
    @Autowired
    private ModeloRepository modeloRepository;

    /**
     * Cria um novo carro com base nos dados do DTO fornecido.
     *
     * @param carroDTO O DTO contendo os dados do carro a ser criado.
     * @return O ID do carro recém-criado.
     * @throws ResponseStatusException Se o modelo associado ao carro não for encontrado.
     */
    @Transactional
    public Integer createCarro(final CarroDTO carroDTO) {
        final Carro carro = new Carro();
        mapToEntity(carroDTO, carro);

        Modelo modelo = modeloRepository.findById(carroDTO.getModeloId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado para ID: " + carroDTO.getModeloId()));

        carro.setModelo(modelo);
        return carroRepository.save(carro).getId();
    }

    /**
     * Obtém uma lista de carros em formato DTO.
     *
     * @return Uma lista de carros no formato DTO.
     */
    public List<CarsDTO> getAllCars() {
        List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(this::mapCarsToDTO).toList();
    }

    /**
     * Obtém uma lista de carros em formato DTO.
     *
     * @return Uma lista de carros no formato DTO.
     */
    @Transactional(readOnly = true)
    public List<CarroDTO> getAllCarros() {
        final List<Carro> cars = carroRepository.findAll();
        return cars.stream().map(carro -> mapToDTO(carro, new CarroDTO()))
                .toList();
    }

    /**
     * Obtém os detalhes de um carro com base em seu ID.
     *
     * @param id O ID do carro a ser recuperado.
     * @return Um objeto CarroDTO contendo os detalhes do carro.
     * @throws ResponseStatusException Se o carro não for encontrado.
     */
    @Transactional(readOnly = true)
    public CarroDTO getCarroById(final Integer id) {
        return carroRepository.findById(id).map(carro -> mapToDTO(carro, new CarroDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado."));
    }

    /**
     * Atualiza os detalhes de um carro existente com base em seu ID.
     *
     * @param id       O ID do carro a ser atualizado.
     * @param carroDTO O DTO contendo os novos dados do carro.
     * @return O DTO atualizado do carro.
     * @throws RuntimeException Se o carro não for encontrado.
     */
    @Transactional
    public CarroDTO updateCarro(Integer id, CarroDTO carroDTO) {
        Carro existingCarro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado."));

        Carro updatedCarro = mapToEntity(carroDTO, existingCarro);
        carroRepository.save(updatedCarro);

        return mapToDTO(updatedCarro, carroDTO);
    }

    /**
     * Exclui carros com base em uma lista de IDs.
     *
     * @param ids Uma lista de IDs de carros a serem excluídos.
     */
    public void deleteCarros(final List<Integer> ids) {
        carroRepository.deleteAllById(ids);
    }

    /**
     * Mapeia os dados de um objeto CarroDTO para uma entidade Carro.
     *
     * @param carroDTO O objeto CarroDTO a ser mapeado.
     * @param carro A entidade Carro na qual os dados serão mapeados.
     * @return A entidade Carro mapeada com os dados do CarroDTO.
     */
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

    /**
     * Mapeia os dados de uma entidade Carro para um objeto CarroDTO.
     *
     * @param carro A entidade Carro a ser mapeada.
     * @param carroDTO O objeto CarroDTO no qual os dados serão mapeados.
     * @return O objeto CarroDTO mapeado com os dados da entidade Carro.
     */
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

    /**
     * Mapeia os dados de uma entidade Carro para um objeto CarsDTO.
     *
     * @param carro A entidade Carro a ser mapeada.
     * @return O objeto CarsDTO mapeado com os dados da entidade Carro.
     */
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
