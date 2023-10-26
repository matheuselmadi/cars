package com.ws.cars.repository;

import com.ws.cars.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Modelo.
 * Este repositório fornece operações de acesso a dados para a entidade Modelo.
 */
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
