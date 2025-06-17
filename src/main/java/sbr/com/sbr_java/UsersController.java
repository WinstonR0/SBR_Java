/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package sbr.com.sbr_java;

import com.sun.org.apache.bcel.internal.generic.Select;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import sbr.com.sbr_java.entities.Cliente;
import sbr.com.sbr_java.entities.Usuarios;
import sbr.com.sbr_java.services.ClienteFacadeLocal;
import sbr.com.sbr_java.services.UsuariosFacadeLocal;

/**
 *
 * @author USER
 */
@Named(value = "usersController")
@ViewScoped
public class UsersController implements Serializable {

    private Usuarios user = new Usuarios();
    private Cliente cli = new Cliente();
    private List<SelectItem> listaClientes;
    @EJB
    private ClienteFacadeLocal cfl;

    @EJB
    private UsuariosFacadeLocal ufl;

    public Cliente getCli() {
        return cli;
    }

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

    public List<SelectItem> listaClientes() {

        listaClientes = new ArrayList<>();
        try {
            for (Usuarios usuario : this.ufl.findAll()) {
                String label = usuario.getId() + " " + usuario.getNombres() + " " + usuario.getApellidos() + " " + usuario.getDocumento() + " " + usuario.getTelefono() + " " + usuario.getCorreo() + " " + usuario.getContrasena() + " " + usuario.getRol() + " " + usuario.getFechaRegistro();
                SelectItem item = new SelectItem(label);
                listaClientes.add(item);
            }
            return listaClientes;
        } catch (Exception e) {

        }
        return null;
    }

    public List<SelectItem> getListaClientes() {
        return listaClientes();
    }

    public String crearP1() {
        this.user = new Usuarios();
        return "/views/usuarios/crear_act.xhtml?faces-redirect=true";
    }
    
    public String crearP2() {
        this.user.getId();
        try {
            this.ufl.create(user);
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Registrado", "MSG_INFO");
            fc.addMessage(null, fm);
            //return "/views/usuarios/index.xhtml?faces-redirect=true";
            this.user = new Usuarios();
            return null;
        } catch (Exception e) {
            e.printStackTrace(); // Agrega para depurar si ocurre algo
        return null; // Quédate en la misma vista si hay error
        }
    }

}
