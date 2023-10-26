package com.ws.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Classe que representa um carro.
 */
@Entity
@Table(name = "carro")
@Getter
@Setter
public class Carro {

    /**
     * Identificador único do carro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "carro_id_seq")
    private Integer id;

    /**
     * Data e hora de cadastro do carro.
     */
    @Column(name = "timestamp_cadastro")
    private Timestamp timestampCadastro;

    /**
     * Modelo do carro.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    /**
     * Ano de fabricação do carro.
     */
    private Integer ano;

    /**
     * Tipo de combustível do carro.
     */
    private String combustivel;

    /**
     * Número de portas do carro.
     */
    @Column(name = "num_portas")
    private Integer numPortas;

    /**
     * Cor do carro.
     */
    private String cor;
}
