package com.ws.cars.repository;

import com.ws.cars.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsável por fornecer métodos para acessar e gerenciar objetos Modelo no banco de dados.
 */
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
