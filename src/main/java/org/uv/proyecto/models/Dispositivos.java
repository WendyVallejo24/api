package org.uv.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "dispositivos")
public class Dispositivos {
    @Id
    @Column(name = "ip_dispositivo")
    private String ip;

    @Column(name = "tipo_dis")
    private String tipo;

    @OneToOne
    @JoinColumn(name = "id_estado_dis")
    private EstadoDispositivo estadoDispositivo;

    @ManyToOne
    @JoinColumn(name = "n_habitacion")
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

    public EstadoDispositivo getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(EstadoDispositivo estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }
    
    
}
