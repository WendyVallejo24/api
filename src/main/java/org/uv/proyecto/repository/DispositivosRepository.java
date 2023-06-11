/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.proyecto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.proyecto.models.Dispositivos;
import org.uv.proyecto.models.Habitaciones;

/**
 *
 * @author wbpat
 */
@Repository
public interface DispositivosRepository extends JpaRepository<Dispositivos, String> {

    public List<Dispositivos> findByHabitacion(Habitaciones habitacion);
    
}
