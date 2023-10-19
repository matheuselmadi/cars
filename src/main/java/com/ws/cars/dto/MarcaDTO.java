package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaDTO {

    private Integer id;

    @JsonProperty("nome_marca")
    private String nomeMarca;
}
