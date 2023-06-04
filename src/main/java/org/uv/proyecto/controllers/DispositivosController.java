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
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.repository.DispositivosRepository;
import org.uv.proyecto.repository.EstadoDisRepository;

/**
 *
 * @author wbpat
 */

@RestController
@RequestMapping("/dispositivo")
public class DispositivosController {
    
    @Autowired
    private EstadoDisRepository estadoDisRepository;
    @Autowired
    private DispositivosRepository dispositivoRepository;

    @GetMapping("/{ip}")
    public ResponseEntity<?> getDispositivo(@PathVariable String ip) {
        Dispositivos dispositivo = dispositivoRepository.findById(ip).orElse(null);
        if (dispositivo != null) {
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dispositivo no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> createDispositivo(@RequestBody Dispositivos dispositivo) {
        Dispositivos createdDispositivo = dispositivoRepository.save(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDispositivo);
    }

}
