package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa um modelo de carro.
 */
@Getter
@Setter
public class ModeloDTO {

    /**
     * O ID do modelo.
     */
    private Integer id;

    /**
     * O ID da marca a que este modelo pertence.
     */
    @JsonProperty("marca_id")
    private Integer marcaId;

    /**
     * O nome do modelo de carro.
     */
    private String nome;

    /**
     * O valor Fipe do modelo.
     */
    @JsonProperty("valor_fipe")
    private Double valorFipe;
}
