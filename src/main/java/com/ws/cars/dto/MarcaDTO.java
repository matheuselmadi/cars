package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa os dados de uma marca de carro.
 */
@Getter
@Setter
public class MarcaDTO {

    /**
     * O identificador único da marca.
     */
    private Integer id;

    /**
     * O nome da marca de carro.
     */
    @JsonProperty("nome_marca")
    private String nomeMarca;
}
