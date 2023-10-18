package com.ws.cars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modelo")
@Getter
@Setter
public class Modelo {

    @Id
//    @SequenceGenerator(name = "modelo_id_seq", sequenceName = "modelo_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "modelo_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "marca_id", insertable = false, updatable = false)
    @JsonProperty("marca_id")
    private Marca marcaId;

    private String nome;

    @Column(name = "valor_fipe")
    @JsonProperty("valor_fipe")
    private Double valor_fipe;

}
