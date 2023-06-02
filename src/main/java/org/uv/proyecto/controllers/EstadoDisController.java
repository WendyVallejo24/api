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
@RequestMapping("/api")
public class EstadoDisController {
    @Autowired
    private EstadoDisRepository estadoDispositivosRepository;
    
    @Autowired
    DispositivosRepository dispositivosRepository;

    @PostMapping("/estadodisp")
    public ResponseEntity<EstadoDispositivo> createEstadoDispositivo(@RequestBody EstadoDispositivo estadoDispositivo) {
        EstadoDispositivo createdEstadoDispositivo = estadoDispositivosRepository.save(estadoDispositivo);
        System.out.println("info del estado " + createdEstadoDispositivo.getEstadoDis());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadoDispositivo);
    }

    @GetMapping("/estadodisp/{idEstado}")
    public ResponseEntity<EstadoDispositivo> getEstadoDispositivo(@PathVariable int idEstado) {
        EstadoDispositivo estadoDispositivo = estadoDispositivosRepository.findById(idEstado)
                .orElseThrow();
        
        return new ResponseEntity<>(estadoDispositivo, HttpStatus.OK);
    }

    @PutMapping("/estadodisp/{idEstado}")
    public ResponseEntity<EstadoDispositivo> updateEstadoDispositivo(@PathVariable int idEstado, @RequestBody EstadoDispositivo estadoDispositivoDetails) {
        EstadoDispositivo estadoDispositivo = estadoDispositivosRepository.findById(idEstado)
                .orElseThrow();
        return new ResponseEntity<>(estadoDispositivosRepository.save(estadoDispositivo), HttpStatus.OK);
    }

}
