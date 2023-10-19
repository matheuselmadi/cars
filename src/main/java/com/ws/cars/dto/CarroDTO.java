package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CarroDTO {

    private Integer Id;

    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

    @JsonProperty("modelo_id")
    private Integer modeloId;

    private Integer ano;

    private String combustivel;

    @JsonProperty("num_portas")
    private Integer numPortas;

    private String cor;
}
