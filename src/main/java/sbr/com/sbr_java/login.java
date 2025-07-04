/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sbr.com.sbr_java;

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

/**
 *
 * @author rosdri
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

    private String usuario;
    private String contrasena;

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
    public String cerrarSesion() {

        // Obtiene el contexto actual de JSF, que contiene toda la info de la petición web en curso
        FacesContext context = FacesContext.getCurrentInstance();

        // Invalida (destruye) la sesión activa del usuario esto elimina todos los atributos guardados como "usuario"
        context.getExternalContext().invalidateSession();

        // Redirecciona al archivo login.xhtml. El "faces-redirect=true" indica que se debe hacer una redirección real
        return "login.xhtml?faces-redirect=true";
    }

}
