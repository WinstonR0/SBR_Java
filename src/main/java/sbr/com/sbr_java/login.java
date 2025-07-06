/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sbr.com.sbr_java;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sbr.com.sbr_java.services.UsuariosFacade;
import sbr.com.sbr_java.entities.Usuarios;
import sbr.com.sbr_java.services.UsuariosFacadeLocal;
import sbr.com.sbr_java.services.VendedorFacadeLocal;
import sbr.com.sbr_java.entities.Vendedor;

/**
 *
 * @author rosdri
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

    private String usuario;
    private String contrasena;

    private Vendedor vendedorLogueado;

    @EJB
    private VendedorFacadeLocal vdf;

    @EJB
    private UsuariosFacadeLocal ufl;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Vendedor getVendedorLogueado() {
        return vendedorLogueado;
    }

    public void setVendedorLogueado(Vendedor vendedorLogueado) {
        this.vendedorLogueado = vendedorLogueado;
    }

    public VendedorFacadeLocal getVdf() {
        return vdf;
    }

    public void setVdf(VendedorFacadeLocal vdf) {
        this.vdf = vdf;
    }

    public UsuariosFacadeLocal getUfl() {
        return ufl;
    }

    public void setUfl(UsuariosFacadeLocal ufl) {
        this.ufl = ufl;
    }

    /**
     * Creates a new instance of login
     */
    public login() {
    }

    public String iniciarSesion() {

        // Llama al método en UsuariosFacade para verificar si el usuario existe
        Usuarios u = ufl.findByCorreoAndContrasena(usuario, contrasena);

        /*sesion.setAttribute("usuario", u.getCorreo()); // Guarda el correo
        sesion.setAttribute("rol", u.getRol());        // Guarda el rol

        //user = this.ufl.iniciarSesion(usuario,contrasena);
        if (usuario.equals("Admin") && contrasena.equals("123")) {
            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); // El true indica que se crea una nueva sesion
            sesion.setAttribute("usuario", usuario);
            return "/views/index.xhtml?faces-redirect=true";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contrasena incorrecta", null);
            fc.addMessage(null, fm);
            return null;
        }*/
        if (u != null) {
            // Si se encontró, inicia sesión y guarda datos en la sesión HTTP
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession sesion = (HttpSession) context.getExternalContext().getSession(true);

            sesion.setAttribute("usuario", u.getCorreo()); // Guarda el correo
            sesion.setAttribute("rol", u.getRol());        // Guarda el rol

            // Normaliza el rol para evitar errores por mayúsculas o espacios
            String rol = u.getRol().toLowerCase().trim();

            // Redirige según el rol del usuario
            switch (u.getRol().toLowerCase()) {
                case "admin":
                    return "/views/index.xhtml?faces-redirect=true";
                case "cliente":
                    return "/views/clientes/index_cliente.xhtml?faces-redirect=true";
                case "vendedor":
                    this.vendedorLogueado = vdf.findByUsuarioId(u.getId());
                    System.out.println("Vendedor logueado" + this.vendedorLogueado);
                    return "/views/vendedor/index_vendedor.xhtml?faces-redirect=true";
                case "domiciliario":
                    return "/views/domiciliario/index_domiciliario.xhtml?faces-redirect=true";
                default:
                    // Si el rol no es reconocido, muestra un mensaje de error
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rol no reconocido", null);
                    context.addMessage(null, fm);
                    return null;
            }
        } else {
            // Si no encuentra el usuario, muestra mensaje de error
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo y/o contraseña incorrectos", null);
            context.addMessage(null, fm);
            return null;
        }

    }

    // Método para cerrar la sesión del usuario actual
    public void cerrarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect(
                    context.getExternalContext().getRequestContextPath() + "/login.xhtml"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para verificar el rol antes de cargar el dashboard (para mas seguridad)
    public void verificarAdmin() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) context.getExternalContext().getSession(false);

        if (sesion == null) {
            // no hay sesion: debe redirigir al login
            context.getExternalContext().redirect("/login.xhtml");
            return;
        }

        String rol = (String) sesion.getAttribute("rol");
        if (rol == null || !"admin".equals(rol)) {
            // No tiene permisos es decir que debe redirigir a un error
            context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/views/usuarios-admin/no_autorizado.xhtml");
        }
    }

    // Método para verificar si el usuario logueado es vendedor
    public void verificarVendedor() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) context.getExternalContext().getSession(false);

        if (sesion == null) {
            context.getExternalContext().redirect("/login.xhtml");
            return;
        }

        String rol = (String) sesion.getAttribute("rol");
        if (rol == null || !"vendedor".equalsIgnoreCase(rol)) {
            context.getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/views/usuarios-admin/no_autorizado.xhtml");
        }
    }

}
