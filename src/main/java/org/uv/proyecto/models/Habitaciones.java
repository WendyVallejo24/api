/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wbpat
 */
@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_habitacion")
    private int n_habitacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_dis", nullable = false)
    private Dispositivos dispositivo;
    
    @OneToOne
    @JoinColumn(name = "id_estado_hab")
    private EstadoHabitacion estadoHab;

    public int getN_habitacion() {
        return n_habitacion;
    }

    public void setN_habitacion(int n_habitacion) {
        this.n_habitacion = n_habitacion;
    }

    public Dispositivos getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }

    public EstadoHabitacion getEstadoHab() {
        return estadoHab;
    }

    public void setEstadoHab(EstadoHabitacion estadoHab) {
        this.estadoHab = estadoHab;
    }
    
    
}
