/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "gestion_de_lealtad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionDeLealtad.findAll", query = "SELECT g FROM GestionDeLealtad g"),
    @NamedQuery(name = "GestionDeLealtad.findById", query = "SELECT g FROM GestionDeLealtad g WHERE g.id = :id"),
    @NamedQuery(name = "GestionDeLealtad.findByPuntos", query = "SELECT g FROM GestionDeLealtad g WHERE g.puntos = :puntos")})
public class GestionDeLealtad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "puntos")
    private Integer puntos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "historial_redenciones")
    private String historialRedenciones;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clienteId;

    public GestionDeLealtad() {
    }

    public GestionDeLealtad(Integer id) {
        this.id = id;
    }

    public GestionDeLealtad(Integer id, String historialRedenciones) {
        this.id = id;
        this.historialRedenciones = historialRedenciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getHistorialRedenciones() {
        return historialRedenciones;
    }

    public void setHistorialRedenciones(String historialRedenciones) {
        this.historialRedenciones = historialRedenciones;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionDeLealtad)) {
            return false;
        }
        GestionDeLealtad other = (GestionDeLealtad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sbr.com.sbr_java.entities.GestionDeLealtad[ id=" + id + " ]";
    }
    
}
