/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.MedioDeTransporte;

/**
 *
 * @author USER
 */
@Local
public interface MedioDeTransporteFacadeLocal {

    void create(MedioDeTransporte medioDeTransporte);

    void edit(MedioDeTransporte medioDeTransporte);

    void remove(MedioDeTransporte medioDeTransporte);

    MedioDeTransporte find(Object id);

    List<MedioDeTransporte> findAll();

    List<MedioDeTransporte> findRange(int[] range);

    int count();
    
}
