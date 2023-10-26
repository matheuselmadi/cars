package com.ws.cars.repository;

import com.ws.cars.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que fornece métodos para acessar e gerenciar entidades do tipo Marca no banco de dados.
 */
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
