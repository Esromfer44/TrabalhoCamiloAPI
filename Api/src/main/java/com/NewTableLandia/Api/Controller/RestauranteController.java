package com.NewTableLandia.Api.Controller;

import com.NewTableLandia.Api.model.Restaurante;
import com.NewTableLandia.Api.model.RestauranteDTO;
import com.NewTableLandia.Api.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public List<RestauranteDTO> getAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.getAllRestaurantes();
        List<RestauranteDTO> restauranteDTOs = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            RestauranteDTO restauranteDTO = RestauranteDTO.fromEntity(restaurante);
            restauranteDTOs.add(restauranteDTO);
        }

        return restauranteDTOs;
    }


    @GetMapping("/{id}")
    public RestauranteDTO getRestauranteById(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.getRestauranteById(id);
        return RestauranteDTO.fromEntity(restaurante);
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        Restaurante restaurante = RestauranteDTO.toEntity(restauranteDTO);
        Restaurante createdRestaurante = restauranteService.createRestaurante(restaurante);
        RestauranteDTO createdRestauranteDTO = RestauranteDTO.fromEntity(createdRestaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestauranteDTO);
    }



}
