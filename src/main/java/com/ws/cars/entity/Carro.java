package com.ws.cars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "carro")
@Getter
@Setter
public class Carro {

    @Id
//    @SequenceGenerator(name = "carro_id_seq", sequenceName = "carro_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "carro_id_seq")
    private Integer id;

    @Column(name = "timestamp_cadastro")
    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id", insertable = false, updatable = false)
    @JsonProperty("modelo_id")
    private Modelo modeloId;

    private Integer ano;

    private String combustivel;

    @Column(name = "num_portas")
    @JsonProperty("num_portas")
    private Integer numPortas;

    private String cor;

}
