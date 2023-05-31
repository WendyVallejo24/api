/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.proyecto.models.EstadoDispositivo;
import org.uv.proyecto.repository.EstadoDisRepository;

/**
 *
 * @author wbpat
 */
@Service
public class EstadoDisService {
    @Autowired
    private EstadoDisRepository estadoDispositivoRepository;

    public List<EstadoDispositivo> getAllEstadosDispositivo() {
        return estadoDispositivoRepository.findAll();
    }

    public EstadoDispositivo getEstadoDispositivoById(int id) {
        return estadoDispositivoRepository.findById(id).orElse(null);
    }

    public EstadoDispositivo createEstadoDispositivo(EstadoDispositivo estadoDispositivo) {
        return estadoDispositivoRepository.save(estadoDispositivo);
    }

    public EstadoDispositivo updateEstadoDispositivo(int id, EstadoDispositivo updatedEstadoDispositivo) {
        EstadoDispositivo existingEstadoDispositivo = estadoDispositivoRepository.findById(id).orElse(null);
        if (existingEstadoDispositivo != null) {
            // Actualizar los campos necesarios de acuerdo a tus requerimientos
            existingEstadoDispositivo.setEstadoDis(updatedEstadoDispositivo.isEstadoDis());
            return estadoDispositivoRepository.save(existingEstadoDispositivo);
        } else {
            return null;
        }
    }

    public boolean deleteEstadoDispositivo(int id) {
        EstadoDispositivo estadoDispositivo = estadoDispositivoRepository.findById(id).orElse(null);
        if (estadoDispositivo != null) {
            estadoDispositivoRepository.delete(estadoDispositivo);
            return true;
        } else {
            return false;
        }
    }
}
