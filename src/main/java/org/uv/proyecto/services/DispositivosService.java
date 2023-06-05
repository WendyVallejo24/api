/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.repository.DispositivosRepository;

/**
 *
 * @author wbpat
 */
@Service
public class DispositivosService {
    @Autowired
    private DispositivosRepository dispositivosRepository;
    


    public List<Dispositivos> getAllDispositivos() {
        return dispositivosRepository.findAll();
    }

    public Dispositivos getDispositivoById(String id) {
        return dispositivosRepository.findById(id).orElse(null);
    }

    public Dispositivos createDispositivo(Dispositivos dispositivo) {
        return dispositivosRepository.save(dispositivo);
    }

    /*public Dispositivos updateDispositivo(String id, Dispositivos updatedDispositivo) {
        Dispositivos existingDispositivo = dispositivosRepository.findById(id).orElse(null);
        if (existingDispositivo != null) {
            // Actualizar los campos necesarios de acuerdo a tus requerimientos
            existingDispositivo.setTipoDis(updatedDispositivo.getTipoDis());
            existingDispositivo.setHora(updatedDispositivo.getHora());
            existingDispositivo.setFecha(updatedDispositivo.getFecha());
            return dispositivosRepository.save(existingDispositivo);
        } else {
            return null;
        }
    }*/

    public boolean deleteDispositivo(String id) {
        Dispositivos dispositivo = dispositivosRepository.findById(id).orElse(null);
        if (dispositivo != null) {
            dispositivosRepository.delete(dispositivo);
            return true;
        } else {
            return false;
        }
    }
}
