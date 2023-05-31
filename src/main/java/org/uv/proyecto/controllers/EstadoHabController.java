/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.uv.proyecto.models.EstadoHabitacion;
import org.uv.proyecto.services.EstadoHabService;

/**
 *
 * @author wbpat
 */
public class EstadoHabController {
    private final EstadoHabService estadoHabitacionService;

    @Autowired
    public EstadoHabController(EstadoHabService estadoHabitacionService) {
        this.estadoHabitacionService = estadoHabitacionService;
    }

    @PostMapping("/estado_habitacion")
    public ResponseEntity<EstadoHabitacion> createEstadoHabitacion(@RequestBody EstadoHabitacion estadoHabitacion) {
        EstadoHabitacion createdEstadoHabitacion = estadoHabitacionService.createEstadoHabitacion(estadoHabitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoHabitacion);
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<EstadoHabitacion> getEstadoHabitacion(@PathVariable int idEstado) {
        EstadoHabitacion estadoHabitacion = estadoHabitacionService.getEstadoHabitacion(idEstado);
        if (estadoHabitacion != null) {
            return ResponseEntity.ok(estadoHabitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<EstadoHabitacion> updateEstadoHabitacion(@PathVariable int idEstado, @RequestBody EstadoHabitacion estadoHabitacionDetails) {
        EstadoHabitacion updatedEstadoHabitacion = estadoHabitacionService.updateEstadoHabitacion(idEstado, estadoHabitacionDetails);
        if (updatedEstadoHabitacion != null) {
            return ResponseEntity.ok(updatedEstadoHabitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<Void> deleteEstadoHabitacion(@PathVariable int idEstado) {
        estadoHabitacionService.deleteEstadoHabitacion(idEstado);
        return ResponseEntity.noContent().build();
    }
}
