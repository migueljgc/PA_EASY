package com.easyplanning.demo.api.controller;

import com.easyplanning.demo.domain.common.routes;
import com.easyplanning.demo.domain.dto.ReservaDTO;
import com.easyplanning.demo.domain.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = routes.API + routes.Reserva.RESERVA)
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping(value = routes.Reserva.SAVE_RESERVA)
    public ReservaDTO save(@RequestBody ReservaDTO reservaDTO) {
        return reservaService.save(reservaDTO);
    }

    @GetMapping(value = routes.Reserva.GET_RESERVA)
    public List<ReservaDTO> get() {
        return reservaService.getAll();
    }

    @PutMapping(value = routes.Reserva.UPDATE_RESERVA + "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        Optional<ReservaDTO> reservaDTOOptional = reservaService.findById(id);
        if (reservaDTOOptional.isPresent()) {
            ReservaDTO existingReserva = reservaDTOOptional.get();
            existingReserva.setEstado(reservaDTO.getEstado());
            // Aquí podrías actualizar otros campos si es necesario
            reservaService.save(existingReserva);
            return ResponseEntity.ok(existingReserva);
        }
        return ResponseEntity.notFound().build();
    }
}