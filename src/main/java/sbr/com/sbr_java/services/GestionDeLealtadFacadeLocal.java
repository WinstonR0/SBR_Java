/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.GestionDeLealtad;

/**
 *
 * @author USER
 */
@Local
public interface GestionDeLealtadFacadeLocal {

    void create(GestionDeLealtad gestionDeLealtad);

    void edit(GestionDeLealtad gestionDeLealtad);

    void remove(GestionDeLealtad gestionDeLealtad);

    GestionDeLealtad find(Object id);

    List<GestionDeLealtad> findAll();

    List<GestionDeLealtad> findRange(int[] range);

    int count();
    
}
