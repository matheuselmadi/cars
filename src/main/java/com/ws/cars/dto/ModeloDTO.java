package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloDTO {

    private Integer id;

    @JsonProperty("marca_id")
    private Integer marcaId;

    private String nome;

    @JsonProperty("valor_fipe")
    private Double valorFipe;
}
