package com.ws.cars.repository;

import com.ws.cars.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsável por fornecer métodos para acessar e gerenciar objetos Carro no banco de dados.
 * É uma extensão da interface JpaRepository do Spring Data JPA.
 */
public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
