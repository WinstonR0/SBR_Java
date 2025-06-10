/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Ruta;

/**
 *
 * @author USER
 */
@Local
public interface RutaFacadeLocal {

    void create(Ruta ruta);

    void edit(Ruta ruta);

    void remove(Ruta ruta);

    Ruta find(Object id);

    List<Ruta> findAll();

    List<Ruta> findRange(int[] range);

    int count();
    
}
