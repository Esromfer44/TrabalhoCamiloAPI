package com.NewTableLandia.Api.service;

import com.NewTableLandia.Api.model.Restaurante;
import com.NewTableLandia.Api.repository.RestauranteRepository;
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
