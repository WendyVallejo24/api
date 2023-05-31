/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.uv.proyecto.models.Habitaciones;
import org.uv.proyecto.repository.HabitacionesRepository;

/**
 *
 * @author wbpat
 */
@Service
public class HabitacionesService {
    private final HabitacionesRepository habitacionesRepository;

    @Autowired
    public HabitacionesService(HabitacionesRepository habitacionesRepository) {
        this.habitacionesRepository = habitacionesRepository;
    }

    public Habitaciones createHabitacion(Habitaciones habitacion) {
        return habitacionesRepository.save(habitacion);
    }

    public Habitaciones getHabitacion(int nHabitacion) {
        Optional<Habitaciones> optionalHabitacion = habitacionesRepository.findById(nHabitacion);
        return optionalHabitacion.orElse(null);
    }

    public List<Habitaciones> getAllHabitaciones() {
        return habitacionesRepository.findAll();
    }

    public Habitaciones updateHabitacion(int nHabitacion, Habitaciones habitacionDetails) {
        Habitaciones habitacion = habitacionesRepository.findById(nHabitacion).orElse(null);
        if (habitacion != null) {
            habitacion.setDispositivo(habitacionDetails.getDispositivo());
            habitacion.setEstadoHab(habitacionDetails.getEstadoHab());
            // Actualiza los demás campos según sea necesario

            return habitacionesRepository.save(habitacion);
        }
        return null;
    }

    public void deleteHabitacion(int nHabitacion) {
        habitacionesRepository.deleteById(nHabitacion);
    }
}