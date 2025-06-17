/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sbr.com.sbr_java;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rosdri
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {
    private String usuario;
    private String contrasena;

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
    
    public String iniciarSesion(){
        
        //user = this.ufl.iniciarSesion(usuario,contrasena);
        if (usuario.equals("Admin") && contrasena.equals("123")) {
            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); // El true indica que se crea una nueva sesion
            sesion.setAttribute("usuario",usuario);
            return "/views/index.xhtml?faces-redirect=true";
    }else {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contrasena incorrecta", null);
            fc.addMessage(null, fm);
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
    
