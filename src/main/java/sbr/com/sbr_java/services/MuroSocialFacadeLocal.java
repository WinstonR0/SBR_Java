/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sbr.com.sbr_java.services;

import java.util.List;
import javax.ejb.Local;
import sbr.com.sbr_java.entities.MuroSocial;

/**
 *
 * @author USER
 */
@Local
public interface MuroSocialFacadeLocal {

    void create(MuroSocial muroSocial);

    void edit(MuroSocial muroSocial);

    void remove(MuroSocial muroSocial);

    MuroSocial find(Object id);

    List<MuroSocial> findAll();

    List<MuroSocial> findRange(int[] range);

    int count();
    
}
