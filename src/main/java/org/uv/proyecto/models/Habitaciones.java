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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_habitacion")
    private Integer numero;

    @OneToMany(mappedBy = "habitacion")
    private List<Dispositivos> dispositivos;

    @OneToOne
    @JoinColumn(name = "id_estado_hab")
    private EstadoHabitacion estadoHabitacion;  

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Dispositivos> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivos> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
    
    
}
