/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.proyecto.models.Habitaciones;
import org.uv.proyecto.repository.HabitacionesRepository;
import org.uv.proyecto.services.HabitacionesService;

/**
 *
 * @author wbpat
 */

@RestController
@RequestMapping("/habitacion")
public class HabitacionesController {
    private final HabitacionesService habitacionesService;

    @Autowired
    public HabitacionesController(HabitacionesService habitacionesService) {
        this.habitacionesService = habitacionesService;
    }
    @Autowired
    private HabitacionesRepository habitacionRepository;

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
    public ResponseEntity<?> createHabitacion(@RequestBody Habitaciones habitacion) {
        Habitaciones createdHabitacion = habitacionRepository.save(habitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHabitacion);
    }
}
