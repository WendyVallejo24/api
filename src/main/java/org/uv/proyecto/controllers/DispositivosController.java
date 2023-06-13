/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.uv.proyecto.repository.DispositivosRepository;
import org.uv.proyecto.repository.HabitacionesRepository;

/**
 *
 * @author wbpat
 */

@RestController
@RequestMapping("/dispositivo")
@CrossOrigin(origins = "http://localhost:4200")
public class DispositivosController {

    @Autowired
    private DispositivosRepository dispositivoRepository;

    @Autowired
    private HabitacionesRepository habitacionRepository;

    @GetMapping
    public ResponseEntity<Page<Dispositivos>> listarDispositivos(Pageable pageable) {
        return ResponseEntity.ok(dispositivoRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Dispositivos> guardarDispositivo(@RequestBody Dispositivos dispositivo) {
        System.out.println(dispositivo.getIp());
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(dispositivo.getHabitacion().getNumero());

        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        dispositivo.setHabitacion(habitacionOptional.get());
        Dispositivos dispositivoGuardado = dispositivoRepository.save(dispositivo);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dispositivoGuardado.getIp()).toUri();
        return ResponseEntity.created(ubicacion).body(dispositivoGuardado);
    }

    @PutMapping("{ip_dispositivo}")
    public ResponseEntity<Dispositivos> ActualizarDispositivo(@RequestBody Dispositivos dispositivo, @PathVariable String ip_dispositivo) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(dispositivo.getHabitacion().getNumero());

        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Dispositivos> dispositivoOptional = dispositivoRepository.findById(ip_dispositivo);
        if (!dispositivoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        dispositivo.setHabitacion(habitacionOptional.get());
        dispositivo.setIp(dispositivoOptional.get().getIp());
        dispositivoRepository.save(dispositivo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{ip_dispositivo}")
    public ResponseEntity<Dispositivos> obtenerDispositivoPorIp(@PathVariable String ip_dispositivo) {
        Optional<Dispositivos> dispositivoOptional = dispositivoRepository.findById(ip_dispositivo);
        if (!dispositivoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dispositivoOptional.get());
    }

}
