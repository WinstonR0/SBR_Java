package sbr.com.sbr_java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sbr.com.sbr_java.entities.Inventario;
import sbr.com.sbr_java.entities.Producto;
import sbr.com.sbr_java.entities.Vendedor;
import sbr.com.sbr_java.services.InventarioFacadeLocal;
import sbr.com.sbr_java.services.ProductoFacadeLocal;

@Named(value = "productoController")
@SessionScoped
public class ProductoController implements Serializable {

    private Producto producto = new Producto();
    private boolean editando = false;

    @Inject
    private login login; // Inyección correcta de la sesión del usuario

    @EJB
    private ProductoFacadeLocal pff;

    @EJB
    private InventarioFacadeLocal ifl;

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String crearProducto() {
        try {
            // Verifica que el vendedor esté logueado
            Vendedor vendedor = login.getVendedorLogueado();
            if (vendedor == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sesión inválida. Intenta volver a iniciar sesión.", null));
                return null;
            }

            // Asigna el vendedor al producto
            producto.setVendedorId(vendedor);
            pff.create(producto);

            // Crea el inventario correspondiente
            Inventario inventario = new Inventario();
            inventario.setVendedorId(vendedor);
            inventario.setProductoId(producto);
            inventario.setCantidad(producto.getStock());

            ifl.create(inventario);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto registrado correctamente"));
            producto = new Producto(); // Limpiar formulario
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar producto", null));
            return null;
        }
    }

    public List<Producto> getMisProductos() {
        Vendedor vendedor = login.getVendedorLogueado();
        if (vendedor != null) {
            return pff.findByVendedorId(vendedor.getId());
        }
        return new ArrayList<>();
    }

    public void guardarProducto() {

        try {
            if (!editando) {
                producto.setVendedorId(login.getVendedorLogueado());
                pff.create(producto);

                // Crear inventario al registrar nuevo producto
                Inventario inventario = new Inventario();
                inventario.setVendedorId(login.getVendedorLogueado());
                inventario.setProductoId(producto);
                inventario.setCantidad(producto.getStock());
                ifl.create(inventario);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto creado correctamente"));
            } else {
                pff.edit(producto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto actualizado correctamente"));

            }
            producto = new Producto();
            editando = false;

            // Redirigir al panel
            FacesContext.getCurrentInstance().getExternalContext().redirect("index_vendedor.xhtml?faces-redirect=true");

        } catch (Exception e) {

            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar el producto", null));
        }

    }

    public String editarProducto(Producto p) {
        this.producto = p;
        this.editando = true;
        return "crear_producto.xhtml?faces-redirect=true";
    }

    public void eliminarProducto(Producto p) {
        try {
            pff.remove(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto eliminado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", null));
        }
    }

}
