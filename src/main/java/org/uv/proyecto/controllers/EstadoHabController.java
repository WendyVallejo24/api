/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.proyecto.models.EstadoHabitacion;
import org.uv.proyecto.repository.EstadoHabRepository;
import org.uv.proyecto.services.EstadoHabService;

/**
 *
 * @author wbpat
 */
@RestController
@RequestMapping("/estadoHabitacion")
public class EstadoHabController {
    private final EstadoHabService estadoHabitacionService;

    @Autowired
    public EstadoHabController(EstadoHabService estadoHabitacionService) {
        this.estadoHabitacionService = estadoHabitacionService;
    }
    
    @Autowired
    private EstadoHabRepository estadoHabitacionRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEstadoHabitacion(@PathVariable Integer id) {
        EstadoHabitacion estadoHabitacion = estadoHabitacionRepository.findById(id).orElse(null);
        if (estadoHabitacion != null) {
            return ResponseEntity.ok(estadoHabitacion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado de habitación no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstadoHabitacion(@RequestBody EstadoHabitacion estadoHabitacion) {
        EstadoHabitacion createdEstadoHabitacion = estadoHabitacionRepository.save(estadoHabitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoHabitacion);
    }
}
