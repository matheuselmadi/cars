package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Classe que representa os dados de um carro.
 */
@Getter
@Setter
public class CarroDTO {

    /**
     * Identificador do carro.
     */
    private Integer Id;

    /**
     * Data e hora do cadastro do carro.
     */
    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

    /**
     * Identificador do modelo do carro.
     */
    @JsonProperty("modelo_id")
    private Integer modeloId;

    /**
     * Ano de fabricação do carro.
     */
    private Integer ano;

    /**
     * Tipo de combustível do carro.
     */
    private String combustivel;

    /**
     * Número de portas do carro.
     */
    @JsonProperty("num_portas")
    private Integer numPortas;

    /**
     * Cor do carro.
     */
    private String cor;
}
