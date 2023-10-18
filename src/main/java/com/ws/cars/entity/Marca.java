package com.ws.cars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marca")
@Getter
@Setter
public class Marca {

    @Id
//    @SequenceGenerator(name = "marca_id_seq", sequenceName = "marca_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "marca_id_seq")
    private Integer id;

    @Column(name = "nome_marca")
    @JsonProperty("nome_marca")
    private String nome_marca;

}
