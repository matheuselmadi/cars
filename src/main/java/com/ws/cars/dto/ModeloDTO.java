package com.ws.cars.dto;

import com.ws.cars.entity.Marca;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloDTO {

    private Integer id;

    private Integer marcaId;

    private String nome;

    private Double valorFipe;
}
