package com.NewTableLandia.config.service;

import com.NewTableLandia.config.dto.RestauranteDTO;
import com.NewTableLandia.config.mapper.DozerMapper;
import com.NewTableLandia.config.model.Restaurante;
import com.NewTableLandia.config.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Restaurante getRestauranteById(Long id) {
        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(id);
        return restauranteOptional.orElse(null);
    }

    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
}
