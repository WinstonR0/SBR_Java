/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.NegocioVendedor;

/**
 *
 * @author USER
 */
@Local
public interface NegocioVendedorFacadeLocal {

    void create(NegocioVendedor negocioVendedor);

    void edit(NegocioVendedor negocioVendedor);

    void remove(NegocioVendedor negocioVendedor);

    NegocioVendedor find(Object id);

    List<NegocioVendedor> findAll();

    List<NegocioVendedor> findRange(int[] range);

    int count();
    
}
