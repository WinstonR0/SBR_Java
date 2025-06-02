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
        if (usuario.equals("Admin") && contrasena.equals("123")) {
            HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true); // El true indica que se crea una nueva sesion
            sesion.setAttribute("usuario",usuario);
            return "inicio.xhtml?faces-redirect=true";
    }else {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contrasena incorrecta", null);
            fc.addMessage(null, fm);
            return null;
        }
    }
}
    
