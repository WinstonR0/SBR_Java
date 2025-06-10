/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Publicacion;

/**
 *
 * @author USER
 */
@Local
public interface PublicacionFacadeLocal {

    void create(Publicacion publicacion);

    void edit(Publicacion publicacion);

    void remove(Publicacion publicacion);

    Publicacion find(Object id);

    List<Publicacion> findAll();

    List<Publicacion> findRange(int[] range);

    int count();
    
}
