/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package org.uv.proyecto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.uv.proyecto.models.Habitaciones;
import org.uv.proyecto.repository.HabitacionesRepository;
*/
/**
 *
 * @author wbpat
 */
/*@Service
public class HabitacionesService {
    @Autowired
    private HabitacionesRepository habitacionesRepository;

    public List<Habitaciones> getAllHabitaciones() {
        return habitacionesRepository.findAll();
    }

    public Optional<Habitaciones> getHabitacionById(int id) {
        return habitacionesRepository.findById(id);
    }

    public Habitaciones createHabitacion(Habitaciones habitacion) {
        return habitacionesRepository.save(habitacion);
    }

    public Habitaciones updateHabitacion(int id, Habitaciones habitacion) {
        Optional<Habitaciones> optionalHabitacion = habitacionesRepository.findById(id);
        if (optionalHabitacion.isPresent()) {
            Habitaciones existingHabitacion = optionalHabitacion.get();
            existingHabitacion.setDispositivo(habitacion.getDispositivo());
            existingHabitacion.setEstadoHab(habitacion.getEstadoHab());
            // Actualizar otros campos según sea necesario
            
            return habitacionesRepository.save(existingHabitacion);
        } else {
            throw new NotFoundException("Habitacion no encontrada");
        }
    }

    public void deleteHabitacion(int id) {
        Optional<Habitaciones> optionalHabitacion = habitacionesRepository.findById(id);
        if (optionalHabitacion.isPresent()) {
            habitacionesRepository.delete(optionalHabitacion.get());
        } else {
            throw new NotFoundException("Habitacion no encontrada");
        }
    }
}
*/