package com.ws.cars.repository;

import com.ws.cars.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface é responsável por fornecer métodos para acessar e gerenciar objetos Carro no banco de dados.
 * É uma extensão da interface JpaRepository do Spring Data JPA.
 *
 * @param <Carro> O tipo de entidade (no caso, Carro) que esta interface lida.
 * @param <Integer> O tipo do identificador da entidade.
 */
public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
