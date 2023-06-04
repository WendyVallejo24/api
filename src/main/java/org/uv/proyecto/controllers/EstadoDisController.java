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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.proyecto.models.EstadoDispositivo;
import org.uv.proyecto.repository.DispositivosRepository;
import org.uv.proyecto.repository.EstadoDisRepository;

/**
 *
 * @author wbpat
 */
@RestController
@RequestMapping("/estadoDispositivo")
public class EstadoDisController {
    @Autowired
    private EstadoDisRepository estadoDispositivosRepository;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getEstadoDispositivo(@PathVariable Integer id) {
        EstadoDispositivo estadoDispositivo = estadoDispositivosRepository.findById(id).orElse(null);
        if (estadoDispositivo != null) {
            return ResponseEntity.ok(estadoDispositivo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado de dispositivo no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> createEstadoDispositivo(@RequestBody EstadoDispositivo estadoDispositivo) {
        EstadoDispositivo createdEstadoDispositivo = estadoDispositivosRepository.save(estadoDispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoDispositivo);
    }

}
