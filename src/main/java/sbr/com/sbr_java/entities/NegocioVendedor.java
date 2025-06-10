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
@Table(name = "negocio_vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NegocioVendedor.findAll", query = "SELECT n FROM NegocioVendedor n"),
    @NamedQuery(name = "NegocioVendedor.findById", query = "SELECT n FROM NegocioVendedor n WHERE n.id = :id"),
    @NamedQuery(name = "NegocioVendedor.findByNombreNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.nombreNegocio = :nombreNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByUbicacionNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.ubicacionNegocio = :ubicacionNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByPropietarioNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.propietarioNegocio = :propietarioNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByTipoNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.tipoNegocio = :tipoNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByEmailNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.emailNegocio = :emailNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByEstadoNegocio", query = "SELECT n FROM NegocioVendedor n WHERE n.estadoNegocio = :estadoNegocio"),
    @NamedQuery(name = "NegocioVendedor.findByFechaInaguracion", query = "SELECT n FROM NegocioVendedor n WHERE n.fechaInaguracion = :fechaInaguracion"),
    @NamedQuery(name = "NegocioVendedor.findByEstaLegalizado", query = "SELECT n FROM NegocioVendedor n WHERE n.estaLegalizado = :estaLegalizado")})
public class NegocioVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_negocio")
    private String nombreNegocio;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion_negocio")
    private String descripcionNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ubicacion_negocio")
    private String ubicacionNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "propietario_negocio")
    private String propietarioNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "tipo_negocio")
    private String tipoNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_negocio")
    private String emailNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado_negocio")
    private String estadoNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_inaguracion")
    private String fechaInaguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "esta_legalizado")
    private String estaLegalizado;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public NegocioVendedor() {
    }

    public NegocioVendedor(Integer id) {
        this.id = id;
    }

    public NegocioVendedor(Integer id, String nombreNegocio, String ubicacionNegocio, String propietarioNegocio, String tipoNegocio, String emailNegocio, String estadoNegocio, String fechaInaguracion, String estaLegalizado) {
        this.id = id;
        this.nombreNegocio = nombreNegocio;
        this.ubicacionNegocio = ubicacionNegocio;
        this.propietarioNegocio = propietarioNegocio;
        this.tipoNegocio = tipoNegocio;
        this.emailNegocio = emailNegocio;
        this.estadoNegocio = estadoNegocio;
        this.fechaInaguracion = fechaInaguracion;
        this.estaLegalizado = estaLegalizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getDescripcionNegocio() {
        return descripcionNegocio;
    }

    public void setDescripcionNegocio(String descripcionNegocio) {
        this.descripcionNegocio = descripcionNegocio;
    }

    public String getUbicacionNegocio() {
        return ubicacionNegocio;
    }

    public void setUbicacionNegocio(String ubicacionNegocio) {
        this.ubicacionNegocio = ubicacionNegocio;
    }

    public String getPropietarioNegocio() {
        return propietarioNegocio;
    }

    public void setPropietarioNegocio(String propietarioNegocio) {
        this.propietarioNegocio = propietarioNegocio;
    }

    public String getTipoNegocio() {
        return tipoNegocio;
    }

    public void setTipoNegocio(String tipoNegocio) {
        this.tipoNegocio = tipoNegocio;
    }

    public String getEmailNegocio() {
        return emailNegocio;
    }

    public void setEmailNegocio(String emailNegocio) {
        this.emailNegocio = emailNegocio;
    }

    public String getEstadoNegocio() {
        return estadoNegocio;
    }

    public void setEstadoNegocio(String estadoNegocio) {
        this.estadoNegocio = estadoNegocio;
    }

    public String getFechaInaguracion() {
        return fechaInaguracion;
    }

    public void setFechaInaguracion(String fechaInaguracion) {
        this.fechaInaguracion = fechaInaguracion;
    }

    public String getEstaLegalizado() {
        return estaLegalizado;
    }

    public void setEstaLegalizado(String estaLegalizado) {
        this.estaLegalizado = estaLegalizado;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
        if (!(object instanceof NegocioVendedor)) {
            return false;
        }
        NegocioVendedor other = (NegocioVendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sbr.com.sbr_java.entities.NegocioVendedor[ id=" + id + " ]";
    }
    
}
