/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sbr.com.sbr_java.entities.Usuarios;

/**
 *
 * @author USER
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "SBR.com_SBR_Java_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public Usuarios findByCorreoAndContrasena(String correo, String contrasena) {
        try {
            // Realiza una consulta JPQL para buscar un usuario con el correo y contraseña proporcionados
            return em.createQuery("SELECT u FROM Usuarios u WHERE u.correo = :correo AND u.contrasena = :contrasena", Usuarios.class)
                    .setParameter("correo", correo) // Asigna el parámetro :correo al valor recibido
                    .setParameter("contrasena", contrasena) // Asigna el parámetro :contrasena
                    .getSingleResult(); // Retorna el único resultado esperado
        } catch (Exception e) {
            // Si ocurre un error (como que no se encuentre el usuario), retorna null
            return null;
        }
    }

}
