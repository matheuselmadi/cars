package com.ws.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma entidade de marca de carro.
 */
@Entity
@Table(name = "marca")
@Getter
@Setter
public class Marca {

    /**
     * Identificador único da marca, gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "marca_id_seq")
    private Integer id;

    /**
     * O nome da marca de carro.
     */
    @Column(name = "nome_marca")
    private String nomeMarca;

}
