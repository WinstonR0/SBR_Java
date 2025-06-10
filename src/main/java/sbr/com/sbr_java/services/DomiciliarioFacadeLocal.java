/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Domiciliario;

/**
 *
 * @author USER
 */
@Local
public interface DomiciliarioFacadeLocal {

    void create(Domiciliario domiciliario);

    void edit(Domiciliario domiciliario);

    void remove(Domiciliario domiciliario);

    Domiciliario find(Object id);

    List<Domiciliario> findAll();

    List<Domiciliario> findRange(int[] range);

    int count();
    
}
