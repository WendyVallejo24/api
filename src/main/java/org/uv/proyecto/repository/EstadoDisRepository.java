/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.proyecto.models.EstadoDispositivo;

/**
 *
 * @author wbpat
 */
public interface EstadoDisRepository extends JpaRepository<EstadoDispositivo, Integer> {
    
}
