package com.NewTableLandia.config.Controller;

import com.NewTableLandia.config.dto.MesaDTO;
import com.NewTableLandia.config.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public ResponseEntity<List<MesaDTO>> getAllMesas() {
        List<MesaDTO> mesasDTO = mesaService.getAllMesas();
        return ResponseEntity.ok(mesasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> getMesaById(@PathVariable Long id) {
        MesaDTO mesaDTO = mesaService.getMesaById(id);
        if (mesaDTO != null) {
            return ResponseEntity.ok(mesaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MesaDTO> createMesa(@RequestBody MesaDTO mesaDTO) {
        MesaDTO createdMesaDTO = mesaService.createMesa(mesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMesaDTO);
    }
}
