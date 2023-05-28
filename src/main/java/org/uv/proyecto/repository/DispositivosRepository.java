/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.proyecto.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.proyecto.models.Dispositivos;

/**
 *
 * @author wbpat
 */
public interface DispositivosRepository extends JpaRepository<Dispositivos, String> {
    
    List<Dispositivos> findByHabitacionId(String ip_dispositivo);
    
    @Transactional
    void deleteByHabitacionId(String n_habitacion);
}
