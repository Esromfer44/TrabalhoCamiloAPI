package com.NewTableLandia.config.repository;

import com.NewTableLandia.config.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);
}
