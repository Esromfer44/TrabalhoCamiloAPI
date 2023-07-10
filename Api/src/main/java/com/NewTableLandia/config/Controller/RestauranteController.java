package com.NewTableLandia.config.Controller;

import com.NewTableLandia.config.dto.RestauranteDTO;
import com.NewTableLandia.config.mapper.DozerMapper;
import com.NewTableLandia.config.model.Restaurante;
import com.NewTableLandia.config.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> getAllRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.getAllRestaurantes();
        List<RestauranteDTO> restaurantesDTO = DozerMapper.parseListObject(restaurantes, RestauranteDTO.class);
        return ResponseEntity.ok(restaurantesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> getRestauranteById(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.getRestauranteById(id);
        if (restaurante != null) {
            RestauranteDTO restauranteDTO = DozerMapper.parseObject(restaurante, RestauranteDTO.class);
            return ResponseEntity.ok(restauranteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        Restaurante restaurante = DozerMapper.parseObject(restauranteDTO, Restaurante.class);
        Restaurante createdRestaurante = restauranteService.createRestaurante(restaurante);
        RestauranteDTO createdRestauranteDTO = DozerMapper.parseObject(createdRestaurante, RestauranteDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestauranteDTO);
    }
}
