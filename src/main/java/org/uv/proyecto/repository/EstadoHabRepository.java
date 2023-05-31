/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.proyecto.models.EstadoHabitacion;

/**
 *
 * @author wbpat
 */
@Repository
public interface EstadoHabRepository extends JpaRepository<EstadoHabitacion, Integer>{
    
}
