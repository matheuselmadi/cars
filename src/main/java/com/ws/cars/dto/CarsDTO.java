package com.ws.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ws.cars.entity.Marca;
import com.ws.cars.entity.Modelo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CarsDTO {

    private Integer id;

    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

    @JsonProperty("modelo_id")
    private Integer modeloId;

    private Integer ano;

    private String combustivel;

    @JsonProperty("num_portas")
    private Integer numPortas;

    private String cor;

    @JsonProperty("nome_modelo")
    private String nomeModelo;

    private Double valor;

    private Integer brand;

}
