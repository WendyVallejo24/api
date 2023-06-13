/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.controllers;

// se realizan las importaciones necesarias
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
//se define la ruta para acceder a los datos de la tabla dispositivos
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dispositivo")
// se define la clase DispositivosController para acceder a los datos de la tabla dispositivos
public class DispositivosController {

    @Autowired
    private DispositivosRepository dispositivoRepository;

    @Autowired
    private HabitacionesRepository habitacionRepository;

    @GetMapping
    public ResponseEntity<Page<Dispositivos>> listarDispositivos(Pageable pageable) {
        return ResponseEntity.ok(dispositivoRepository.findAll(pageable));
    }

    // se define el metodo para guardar los datos de la tabla dispositivos
    @PostMapping
    public ResponseEntity<Dispositivos> guardarDispositivo(@RequestBody Dispositivos dispositivo) {
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

    // se define el metodo para actualizar los datos de la tabla dispositivos
    @PostMapping("/sensor")
    public static ResponseEntity<Object> handleJsonRequest(@RequestBody Object json) {
        System.out.println(json);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Dispositivos> actualizarDispositivo(@RequestBody Dispositivos dispositivo) {
        Optional<Habitaciones> habitacionOptional = habitacionRepository.findById(dispositivo.getHabitacion().getNumero());
        if (!habitacionOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        
        Optional<Dispositivos> dispositivoOptional = dispositivoRepository.findById(dispositivo.getIp());
        if (!dispositivoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        
        dispositivo.setHabitacion(habitacionOptional.get());
        dispositivo.setIp(dispositivoOptional.get().getIp());
        dispositivoRepository.save(dispositivo);
        return ResponseEntity.noContent().build();
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

    // se define el metodo para obtener los datos de la tabla dispositivos
    @GetMapping("/{ip_dispositivo}")
    public ResponseEntity<Dispositivos> obtenerDispositivoPorIp(@PathVariable String ip_dispositivo) {
        Optional<Dispositivos> dispositivoOptional = dispositivoRepository.findById(ip_dispositivo);
        if (!dispositivoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(dispositivoOptional.get());
    }
}