/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.services;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sbr.com.sbr_java.entities.Inventario;

/**
 *
 * @author USER
 */
@PermitAll
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {

    @PersistenceContext(unitName = "SBR.com_SBR_Java_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    
}
