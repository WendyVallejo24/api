/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.services.DispositivosService;

/**
 *
 * @author wbpat
 */
@RestController
public class DispositivosController {

    @Autowired
    private DispositivosService dispositivosService;

    // Obtener todos los dispositivos
    @GetMapping("/dispositivos")
    public List<Dispositivos> getAllDispositivos() {
        return dispositivosService.getAllDispositivos();
    }

    // Obtener un dispositivo por su ID
    @GetMapping("/{ip_dispositivo}")
    public ResponseEntity<Dispositivos> getDispositivoById(@PathVariable("id") String id) {
        Dispositivos dispositivo = dispositivosService.getDispositivoById(id);
        if (dispositivo != null) {
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo dispositivo
    @PostMapping("/dispositivos")
    public Dispositivos createDispositivo(@RequestBody Dispositivos dispositivo) {
        return dispositivosService.createDispositivo(dispositivo);
    }

    // Actualizar un dispositivo existente
    @PutMapping("/{ip_dispositivo}")
    public ResponseEntity<Dispositivos> updateDispositivo(@PathVariable("id") String id, @RequestBody Dispositivos dispositivo) {
        Dispositivos updatedDispositivo = dispositivosService.updateDispositivo(id, dispositivo);
        if (updatedDispositivo != null) {
            return ResponseEntity.ok(updatedDispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un dispositivo
    @DeleteMapping("/{ip_dispositivo}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable("id") String id) {
        boolean deleted = dispositivosService.deleteDispositivo(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
