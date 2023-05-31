/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.proyecto.models.EstadoHabitacion;
import org.uv.proyecto.repository.EstadoHabRepository;
/**
 *
 * @author wbpat
 */
@Service
public class EstadoHabService {
    private final EstadoHabRepository estadoHabitacionRepository;

    @Autowired
    public EstadoHabService(EstadoHabRepository estadoHabitacionRepository) {
        this.estadoHabitacionRepository = estadoHabitacionRepository;
    }

    public EstadoHabitacion createEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        return estadoHabitacionRepository.save(estadoHabitacion);
    }

    public EstadoHabitacion getEstadoHabitacion(int idEstado) {
        Optional<EstadoHabitacion> optionalEstadoHabitacion = estadoHabitacionRepository.findById(idEstado);
        return optionalEstadoHabitacion.orElse(null);
    }

    public List<EstadoHabitacion> getAllEstadoHabitacion() {
        return estadoHabitacionRepository.findAll();
    }

    public EstadoHabitacion updateEstadoHabitacion(int idEstado, EstadoHabitacion estadoHabitacionDetails) {
        EstadoHabitacion estadoHabitacion = estadoHabitacionRepository.findById(idEstado).orElse(null);
        if (estadoHabitacion != null) {
            estadoHabitacion.setEstadoHab(estadoHabitacionDetails.getEstadoHab());
            // Actualiza los demás campos según sea necesario

            return estadoHabitacionRepository.save(estadoHabitacion);
        }
        return null;
    }

    public void deleteEstadoHabitacion(int idEstado) {
        estadoHabitacionRepository.deleteById(idEstado);
    }
}