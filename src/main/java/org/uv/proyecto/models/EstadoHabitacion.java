/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wbpat
 */
@Entity
@Table(name = "estado_habitacion")
public class EstadoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_hab")
    private Integer id;

    @Column(name = "estado_hab")
    private String estado;

    @OneToOne(mappedBy = "estadoHabitacion")
    private Habitaciones habitacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }
    
}
