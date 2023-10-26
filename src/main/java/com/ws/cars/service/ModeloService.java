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

/**
 * Esta classe é responsável por fornecer serviços relacionados a modelos de carros.
 * Ela permite a criação, leitura, atualização e exclusão de modelos, bem como a recuperação
 * de todos os modelos existentes.
 */
@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    /**
     * Cria um novo modelo de carro com as informações fornecidas.
     *
     * @param modeloDTO Os dados do modelo a ser criado.
     * @return O ID do modelo recém-criado.
     */
    @Transactional
    public Integer createModelo(final ModeloDTO modeloDTO) {
        final Modelo modelo = new Modelo();
        mapToEntity(modeloDTO, modelo);

        Marca marca = marcaRepository.findById(modeloDTO.getMarcaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada para ID: " + modeloDTO.getMarcaId()));

        modelo.setMarca(marca);
        return modeloRepository.save(modelo).getId();
    }

    /**
     * Obtém uma lista de todos os modelos de carros existentes.
     *
     * @return Uma lista de objetos ModeloDTO representando os modelos.
     */
    @Transactional(readOnly = true)
    public List<ModeloDTO> getAllModelos() {
        final List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream().map(modelo -> mapToDTO(modelo, new ModeloDTO()))
                .toList();
    }

    /**
     * Obtém um modelo de carro com base no ID fornecido.
     *
     * @param id O ID do modelo a ser recuperado.
     * @return Um objeto ModeloDTO representando o modelo encontrado.
     * @throws ResponseStatusException se o modelo não for encontrado.
     */
    @Transactional(readOnly = true)
    public ModeloDTO getModeloById(final Integer id) {
        return modeloRepository.findById(id).map(modelo -> mapToDTO(modelo, new ModeloDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado."));
    }

    /**
     * Atualiza um modelo de carro com as informações fornecidas.
     *
     * @param id O ID do modelo a ser atualizado.
     * @param modeloDTO Os novos dados a serem aplicados ao modelo.
     * @return Um objeto ModeloDTO representando o modelo atualizado.
     */
    @Transactional
    public ModeloDTO updateModelo(Integer id, ModeloDTO modeloDTO) {
        Modelo existingModelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        Modelo updatedModelo = mapToEntity(modeloDTO, existingModelo);
        modeloRepository.save(updatedModelo);

        return mapToDTO(updatedModelo, modeloDTO);
    }

    /**
     * Exclui modelos de carros com base nos IDs fornecidos.
     *
     * @param ids Uma lista de IDs de modelos a serem excluídos.
     */
    public void deleteModelos(final List<Integer> ids) {
        modeloRepository.deleteAllById(ids);
    }

    /**
     * Mapeia os dados do objeto ModeloDTO para a entidade Modelo.
     *
     * @param modeloDTO Os dados do modelo a ser mapeado.
     * @param modelo A entidade Modelo a ser preenchida com os dados mapeados.
     * @return A entidade Modelo preenchida com os dados do ModeloDTO.
     */
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

    /**
     * Mapeia os dados da entidade Modelo para o objeto ModeloDTO.
     *
     * @param modelo A entidade Modelo a ser mapeada.
     * @param modeloDTO O objeto ModeloDTO a ser preenchido com os dados mapeados.
     * @return O objeto ModeloDTO preenchido com os dados do Modelo.
     */
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
