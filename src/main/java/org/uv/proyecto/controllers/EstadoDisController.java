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
import org.uv.proyecto.models.EstadoDispositivo;
import org.uv.proyecto.services.EstadoDisService;

/**
 *
 * @author wbpat
 */
public class EstadoDisController {
    private final EstadoDisService estadoDispositivoService;

    @Autowired
    public EstadoDisController(EstadoDisService estadoDispositivoService) {
        this.estadoDispositivoService = estadoDispositivoService;
    }

    @PostMapping
    public ResponseEntity<EstadoDispositivo> createEstadoDispositivo(@RequestBody EstadoDispositivo estadoDispositivo) {
        EstadoDispositivo createdEstadoDispositivo = estadoDispositivoService.createEstadoDispositivo(estadoDispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoDispositivo);
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<EstadoDispositivo> getEstadoDispositivo(@PathVariable int idEstado) {
        EstadoDispositivo estadoDispositivo = estadoDispositivoService.getEstadoDispositivoById(idEstado);
        if (estadoDispositivo != null) {
            return ResponseEntity.ok(estadoDispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<EstadoDispositivo> updateEstadoDispositivo(@PathVariable int idEstado, @RequestBody EstadoDispositivo estadoDispositivoDetails) {
        EstadoDispositivo updatedEstadoDispositivo = estadoDispositivoService.updateEstadoDispositivo(idEstado, estadoDispositivoDetails);
        if (updatedEstadoDispositivo != null) {
            return ResponseEntity.ok(updatedEstadoDispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<Void> deleteEstadoDispositivo(@PathVariable int idEstado) {
        estadoDispositivoService.deleteEstadoDispositivo(idEstado);
        return ResponseEntity.noContent().build();
    }
}
