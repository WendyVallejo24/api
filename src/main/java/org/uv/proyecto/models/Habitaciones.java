/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.proyecto.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_habitacion")
    private Integer numero;
    
    @Column(name = "estado_hab")
    private int estado_hab; 

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private Set<Dispositivos> dispositivos= new HashSet<>();;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getEstado_hab() {
        return estado_hab;
    }

    public void setEstado_hab(int estado_hab) {
        this.estado_hab = estado_hab;
    }

    public Set<Dispositivos> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(Set<Dispositivos> dispositivos) {
        this.dispositivos = dispositivos;
        
        for(Dispositivos dispositivo: dispositivos){
            dispositivo.setHabitacion(this);
        }
    }
}
