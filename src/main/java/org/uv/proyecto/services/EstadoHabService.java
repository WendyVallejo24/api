/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package org.uv.proyecto.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.uv.proyecto.models.EstadoHabitacion;
import org.uv.proyecto.repository.EstadoHabRepository;
*/
/**
 *
 * @author wbpat
 */
/*
public class EstadoHabService {
    @Autowired
    private EstadoHabRepository estadoHabitacionRepository;

    public List<EstadoHabitacion> getAllEstadosHabitacion() {
        return estadoHabitacionRepository.findAll();
    }

    public Optional<EstadoHabitacion> getEstadoHabitacionById(int id) {
        return estadoHabitacionRepository.findById(id);
    }

    public EstadoHabitacion createEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        return estadoHabitacionRepository.save(estadoHabitacion);
    }

    public EstadoHabitacion updateEstadoHabitacion(int id, EstadoHabitacion estadoHabitacion) {
        Optional<EstadoHabitacion> optionalEstadoHabitacion = estadoHabitacionRepository.findById(id);
        if (optionalEstadoHabitacion.isPresent()) {
            EstadoHabitacion existingEstadoHabitacion = optionalEstadoHabitacion.get();
            existingEstadoHabitacion.setEstadoHab(estadoHabitacion.getEstadoHab());
            // Actualizar otros campos según sea necesario
            
            return estadoHabitacionRepository.save(existingEstadoHabitacion);
        } else {
            throw new NotFoundException("EstadoHabitacion no encontrada");
        }
    }

    public void deleteEstadoHabitacion(int id) {
        Optional<EstadoHabitacion> optionalEstadoHabitacion = estadoHabitacionRepository.findById(id);
        if (optionalEstadoHabitacion.isPresent()) { 
            estadoHabitacionRepository.delete(optionalEstadoHabitacion.get());
        } else {
            throw new NotFoundException("EstadoHabitacion no encontrada");
        }
    }
}
*/