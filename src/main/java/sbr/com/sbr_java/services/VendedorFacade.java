/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.services;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sbr.com.sbr_java.entities.Vendedor;

/**
 *
 * @author USER
 */

@PermitAll
@Stateless
public class VendedorFacade extends AbstractFacade<Vendedor> implements VendedorFacadeLocal {

    @PersistenceContext(unitName = "SBR.com_SBR_Java_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedorFacade() {
        super(Vendedor.class);
    }

    public Vendedor findByUsuarioId(int usuarioId) {
        try {
            return em.createQuery("SELECT v FROM Vendedor v WHERE v.usuarioId.id = :usuarioId", Vendedor.class)
                    .setParameter("usuarioId", usuarioId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
