package com.ws.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modelo")
@Getter
@Setter
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "modelo_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "marca_id", insertable = false, updatable = false)
    private Marca marca;

    private String nome;

    @Column(name = "valor_fipe")
    private Double valorFipe;

}
