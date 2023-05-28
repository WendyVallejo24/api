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
import javax.persistence.Table;

/**
 *
 * @author wbpat
 */
@Entity
@Table(name = "estado_dispositivo")
public class EstadoDispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private int id_estado;
    
    @Column(name = "estado_dis")
    private boolean estado_dis;

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public boolean isEstado_dis() {
        return estado_dis;
    }

    public void setEstado_dis(boolean estado_dis) {
        this.estado_dis = estado_dis;
    }
    
    
}
