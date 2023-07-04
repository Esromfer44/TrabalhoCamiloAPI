package com.NewTableLandia.Api.repository;

import com.NewTableLandia.Api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findAll();

    Optional<Restaurante> findById(Long id);

    Restaurante save(Restaurante restaurante);
}
