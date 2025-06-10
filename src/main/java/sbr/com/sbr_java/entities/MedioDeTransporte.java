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
@Table(name = "medio_de_transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioDeTransporte.findAll", query = "SELECT m FROM MedioDeTransporte m"),
    @NamedQuery(name = "MedioDeTransporte.findById", query = "SELECT m FROM MedioDeTransporte m WHERE m.id = :id"),
    @NamedQuery(name = "MedioDeTransporte.findByTipoVehiculo", query = "SELECT m FROM MedioDeTransporte m WHERE m.tipoVehiculo = :tipoVehiculo"),
    @NamedQuery(name = "MedioDeTransporte.findByPlacaVehiculo", query = "SELECT m FROM MedioDeTransporte m WHERE m.placaVehiculo = :placaVehiculo")})
public class MedioDeTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "placa_vehiculo")
    private String placaVehiculo;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Domiciliario domiciliario;

    public MedioDeTransporte() {
    }

    public MedioDeTransporte(Integer id) {
        this.id = id;
    }

    public MedioDeTransporte(Integer id, String tipoVehiculo, String placaVehiculo) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.placaVehiculo = placaVehiculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Domiciliario getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(Domiciliario domiciliario) {
        this.domiciliario = domiciliario;
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
        if (!(object instanceof MedioDeTransporte)) {
            return false;
        }
        MedioDeTransporte other = (MedioDeTransporte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sbr.com.sbr_java.entities.MedioDeTransporte[ id=" + id + " ]";
    }
    
}
