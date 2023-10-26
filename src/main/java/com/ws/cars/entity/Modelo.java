package com.ws.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa um modelo de carro.
 */
@Entity
@Table(name = "modelo")
@Getter
@Setter
public class Modelo {

    /**
     * O identificador único do modelo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "modelo_id_seq")
    private Integer id;

    /**
     * A marca do modelo.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    /**
     * O nome do modelo.
     */
    private String nome;

    /**
     * O valor Fipe do modelo.
     */
    @Column(name = "valor_fipe")
    private Double valorFipe;
}
