package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Esta classe representa os dados de um carro.
 */
@Getter
@Setter
public class CarsDTO {

    /** Identificador único do carro. */
    private Integer id;

    /** Data e hora de cadastro do carro. */
    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

    /** Identificador do modelo do carro. */
    @JsonProperty("modelo_id")
    private Integer modeloId;

    /** Ano de fabricação do carro. */
    private Integer ano;

    /** Tipo de combustível do carro. */
    private String combustivel;

    /** Número de portas do carro. */
    @JsonProperty("num_portas")
    private Integer numPortas;

    /** Cor do carro. */
    private String cor;

    /** Nome do modelo do carro. */
    @JsonProperty("nome_modelo")
    private String nomeModelo;

    /** Valor do carro. */
    private Double valor;

    /** Identificador da marca do carro. */
    private Integer brand;

}
