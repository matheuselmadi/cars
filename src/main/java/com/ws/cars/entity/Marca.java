package com.ws.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marca")
@Getter
@Setter
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "marca_id_seq")
    private Integer id;

    @Column(name = "nome_marca")
    private String nomeMarca;

}
