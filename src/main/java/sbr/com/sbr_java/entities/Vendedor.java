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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findById", query = "SELECT v FROM Vendedor v WHERE v.id = :id"),
    @NamedQuery(name = "Vendedor.findByNegocioId", query = "SELECT v FROM Vendedor v WHERE v.negocioId = :negocioId")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "negocio_id")
    private int negocioId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorId", fetch = FetchType.LAZY)
    private List<Oferta> ofertaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorId", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendedor", fetch = FetchType.LAZY)
    private NegocioVendedor negocioVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorId", fetch = FetchType.LAZY)
    private List<Inventario> inventarioList;

    public Vendedor() {
    }

    public Vendedor(Integer id) {
        this.id = id;
    }

    public Vendedor(Integer id, int negocioId) {
        this.id = id;
        this.negocioId = negocioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNegocioId() {
        return negocioId;
    }

    public void setNegocioId(int negocioId) {
        this.negocioId = negocioId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public NegocioVendedor getNegocioVendedor() {
        return negocioVendedor;
    }

    public void setNegocioVendedor(NegocioVendedor negocioVendedor) {
        this.negocioVendedor = negocioVendedor;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
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
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sbr.com.sbr_java.entities.Vendedor[ id=" + id + " ]";
    }
    
}
