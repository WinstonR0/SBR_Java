/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Usuarios;

/**
 *
 * @author USER
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    Usuarios findByCorreoAndContrasena(String correo, String contrasena);
    
}
