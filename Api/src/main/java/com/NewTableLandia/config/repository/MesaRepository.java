package com.NewTableLandia.config.repository;

import com.NewTableLandia.config.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findAll();

    Optional<Mesa> findById(Long id);

    Mesa save(Mesa mesa);

    void deleteById(Long id);
}
