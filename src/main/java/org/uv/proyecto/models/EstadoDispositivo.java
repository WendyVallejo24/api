/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.uv.proyecto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "estado_dispositivo")
public class EstadoDispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_dis")
    private Integer id;

    @Column(name = "estado_dis")
    private Boolean estado;

    @JsonIgnore
    @OneToOne(mappedBy = "estadoDispositivo")
    private Dispositivos dispositivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Dispositivos getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivos dispositivo) {
        this.dispositivo = dispositivo;
    }
}
