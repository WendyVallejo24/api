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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.models.Habitaciones;
import org.uv.proyecto.services.HabitacionesService;

/**
 *
 * @author wbpat
 */

@Controller
public class HabitacionesController {
    private final HabitacionesService habitacionesService;

    @Autowired
    public HabitacionesController(HabitacionesService habitacionesService) {
        this.habitacionesService = habitacionesService;
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitaciones> createHabitacion(@RequestBody Habitaciones habitacion) {
        Habitaciones createdHabitacion = habitacionesService.createHabitacion(habitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHabitacion);
    }

    @GetMapping("/{nHabitacion}")
    public ResponseEntity<Habitaciones> getHabitacion(@PathVariable int nHabitacion) {
        Habitaciones habitacion = habitacionesService.getHabitacion(nHabitacion);
        if (habitacion != null) {
            return ResponseEntity.ok(habitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{nHabitacion}")
    public ResponseEntity<Habitaciones> updateHabitacion(@PathVariable int nHabitacion, @RequestBody Habitaciones habitacionDetails) {
        Habitaciones updatedHabitacion = habitacionesService.updateHabitacion(nHabitacion, habitacionDetails);
        if (updatedHabitacion != null) {
            return ResponseEntity.ok(updatedHabitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nHabitacion}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable int nHabitacion) {
        habitacionesService.deleteHabitacion(nHabitacion);
        return ResponseEntity.noContent().build();
    }
}
