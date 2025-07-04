/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sbr.com.sbr_java.entities.Usuarios;
import sbr.com.sbr_java.security.PasswordUtil;

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

    @Override
    public void create(Usuarios user) {
        // Hashear la contraseña antes de guardar en BD
        String hashed = PasswordUtil.hasPassword(user.getContrasena());
        user.setContrasena(hashed);
        getEntityManager().persist(user);
    }

    public Usuarios findByCorreoAndContrasena(String correo, String contrasena) {

        try {
            // Buscar por correo solamente
            Usuarios usuario = em.createQuery("SELECT u FROM Usuarios u WHERE u.correo = :correo", Usuarios.class)
                    .setParameter("correo", correo)
                    .getSingleResult();

            // Verificar contraseña con hash
            if (usuario != null && PasswordUtil.checkPassword(contrasena, usuario.getContrasena())) {
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null; // Usuario no encontrado o error
        }

    }

}
