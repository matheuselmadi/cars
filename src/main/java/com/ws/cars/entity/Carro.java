package com.ws.cars.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "carro_id_seq")
    private Integer id;

    @Column(name = "timestamp_cadastro")
    private Timestamp timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id", insertable = false, updatable = false)
    private Modelo modelo;

    private Integer ano;

    private String combustivel;

    @Column(name = "num_portas")
    private Integer numPortas;

    private String cor;

}
