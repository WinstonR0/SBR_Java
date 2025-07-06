/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sbr.com.sbr_java.entities.Producto;

/**
 *
 * @author USER
 */
@PermitAll
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "SBR.com_SBR_Java_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    public List<Producto> findByVendedorId(Integer vendedorId) {
        return em.createQuery(
                "SELECT p FROM Producto p WHERE p.vendedorId.id = :vendedorId",
                Producto.class)
                .setParameter("vendedorId", vendedorId)
                .getResultList();
    }

}
