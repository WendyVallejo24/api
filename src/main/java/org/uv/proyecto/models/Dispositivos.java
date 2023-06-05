package org.uv.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "dispositivos")
public class Dispositivos {
    @Id
    @Column(name = "ip_dispositivo")
    private String ip;

    @Column(name = "tipo_dis")
    private String tipo;

    @Column(name = "estado_dis")
    private int estadoDispositivo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "n_habitacion")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Habitaciones habitacion;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(int estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }
       
}
