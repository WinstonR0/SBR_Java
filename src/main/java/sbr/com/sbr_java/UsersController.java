/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sbr.com.sbr_java;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import sbr.com.sbr_java.entities.Usuarios;
import sbr.com.sbr_java.services.UsuariosFacadeLocal;

/**
 *
 * @author USER
 */
@Named(value = "usersController")
@ViewScoped
public class UsersController implements Serializable {
    
    private Usuarios user = new Usuarios();
    
    @EJB
    private UsuariosFacadeLocal ufl;
            
    
    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
    
    public List<Usuarios> obtenerRegistros() {
        return this.ufl.findAll();
    }
    
    public UsersController() {
    }
    
}
