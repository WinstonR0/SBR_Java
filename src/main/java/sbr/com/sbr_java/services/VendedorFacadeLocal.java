/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.Vendedor;

/**
 *
 * @author USER
 */
@Local
public interface VendedorFacadeLocal {

    void create(Vendedor vendedor);

    void edit(Vendedor vendedor);

    void remove(Vendedor vendedor);

    Vendedor find(Object id);

    List<Vendedor> findAll();

    List<Vendedor> findRange(int[] range);

    int count();

    public Vendedor findByUsuarioId(int usuarioId);

}
