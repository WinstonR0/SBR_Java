/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Oferta;

/**
 *
 * @author USER
 */
@Local
public interface OfertaFacadeLocal {

    void create(Oferta oferta);

    void edit(Oferta oferta);

    void remove(Oferta oferta);

    Oferta find(Object id);

    List<Oferta> findAll();

    List<Oferta> findRange(int[] range);

    int count();
    
}
