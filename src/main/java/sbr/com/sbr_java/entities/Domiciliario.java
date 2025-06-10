/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "domiciliario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domiciliario.findAll", query = "SELECT d FROM Domiciliario d"),
    @NamedQuery(name = "Domiciliario.findById", query = "SELECT d FROM Domiciliario d WHERE d.id = :id"),
    @NamedQuery(name = "Domiciliario.findByMedioTransporteId", query = "SELECT d FROM Domiciliario d WHERE d.medioTransporteId = :medioTransporteId")})
public class Domiciliario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medio_transporte_id")
    private int medioTransporteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domiciliarioId", fetch = FetchType.LAZY)
    private List<Ruta> rutaList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuarioId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "domiciliario", fetch = FetchType.LAZY)
    private MedioDeTransporte medioDeTransporte;

    public Domiciliario() {
    }

    public Domiciliario(Integer id) {
        this.id = id;
    }

    public Domiciliario(Integer id, int medioTransporteId) {
        this.id = id;
        this.medioTransporteId = medioTransporteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMedioTransporteId() {
        return medioTransporteId;
    }

    public void setMedioTransporteId(int medioTransporteId) {
        this.medioTransporteId = medioTransporteId;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public MedioDeTransporte getMedioDeTransporte() {
        return medioDeTransporte;
    }

    public void setMedioDeTransporte(MedioDeTransporte medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
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
        if (!(object instanceof Domiciliario)) {
            return false;
        }
        Domiciliario other = (Domiciliario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sbr.com.sbr_java.entities.Domiciliario[ id=" + id + " ]";
    }
    
}
