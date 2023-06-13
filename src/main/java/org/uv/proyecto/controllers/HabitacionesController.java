/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import java.net.URI;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.models.Habitaciones;
import org.uv.proyecto.repository.HabitacionesRepository;

/**
 *
 * @author wbpat
 */
@RestController
@RequestMapping("/habitacion")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitacionesController {

    @Autowired
    private HabitacionesRepository habitacionRepository;

    @GetMapping
    public ResponseEntity<Page<Habitaciones>> listarHabitaciones(Pageable pageable) {
        return ResponseEntity.ok(habitacionRepository.findAll(pageable));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getHabitacion(@PathVariable Integer numero) {
        Habitaciones habitacion = habitacionRepository.findById(numero).orElse(null);
        if (habitacion != null) {
            return ResponseEntity.ok(habitacion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habitación no encontrada");
        }
    }

    @PostMapping
    public ResponseEntity<Habitaciones> createHabitacion(@RequestBody Habitaciones habitacion) {
        Habitaciones createdHabitacion = habitacionRepository.save(habitacion);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdHabitacion.getNumero()).toUri();
        return ResponseEntity.created(ubicacion).body(createdHabitacion);
    }

    @PutMapping("/{numero}")
    public ResponseEntity<Habitaciones> actualizarAbitación(@PathVariable Integer numero, @RequestBody Habitaciones habitacion) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(numero);
        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        habitacion.setNumero(habitacionOptional.get().getNumero());
        habitacionRepository.save(habitacion);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Habitaciones> eliminarHabitacion(@PathVariable Integer numero) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(numero);
        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        habitacionRepository.delete(habitacionOptional.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("numero")
    public ResponseEntity<Habitaciones> obtenerHabitacionPorId(@PathVariable Integer numero) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(numero);
        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(habitacionOptional.get());
    }

    @GetMapping("/{numero}/dispositivo")
    public ResponseEntity<Set<Dispositivos>> obtenerDispositivosDeHabitacion(@PathVariable Integer numero) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(numero);
        if (habitacionOptional.isPresent()) {
            Habitaciones habitacion = habitacionOptional.get();
            Set<Dispositivos> dispositivos = habitacion.getDispositivos();
            return ResponseEntity.ok(dispositivos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
