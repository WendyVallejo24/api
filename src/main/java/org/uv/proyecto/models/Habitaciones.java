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


@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_habitacion")
    private int nHabitacion;

    public int getnHabitacion() {
        return nHabitacion;
    }

    public void setnHabitacion(int nHabitacion) {
        this.nHabitacion = nHabitacion;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ip_dispositivo", nullable = false)
    private Dispositivos dispositivo;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_hab", nullable = false)
    private EstadoHabitacion estadoHab;



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
