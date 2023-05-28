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
public class DispositivosServiceImpl implements DispositivosService {
    @Autowired
    private DispositivosRepository repository;
    
    @Override
    public List<Dispositivos> listaDispositivos() {
        return repository.findAll();
    }
    
}
