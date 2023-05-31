package org.uv.proyecto.models;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "dispositivos")
public class Dispositivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ip_dispositivo")
    private String ipDispositivo;
    
    @Column(name = "tipo_dis")
    private String tipoDis;
    
    @Column(name = "hora")
    private Time hora;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_dis")
    private EstadoDispositivo estadoDis;
    
    @Column(name = "ultimavezactivo")
    private Time  ultimavezactivo;
    
    @OneToMany(mappedBy = "dispositivo")
    private List<Habitaciones> habitacion = new ArrayList<>();

    public String getIpDispositivo() {
        return ipDispositivo;
    }
    public void setIpDispositivo(String ipDispositivo) {
        this.ipDispositivo = ipDispositivo;
    }
    public String getTipoDis() {
        return tipoDis;
    }
    public void setTipoDis(String tipoDis) {
        this.tipoDis = tipoDis;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public EstadoDispositivo getEstadoDis() {
        return estadoDis;
    }
    public void setEstadoDis(EstadoDispositivo estadoDis) {
        this.estadoDis = estadoDis;
    }
    public Time getUltimavezactivo() {
        return ultimavezactivo;
    }
    public void setUltimavezactivo(Time ultimavezactivo) {
        this.ultimavezactivo = ultimavezactivo;
    }
    public List<Habitaciones> getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(List<Habitaciones> habitacion) {
        this.habitacion = habitacion;
    }
}
