/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.security;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author USER
 */
public class PasswordUtil {
    
    public static String hasPassword(String plainTextPassword) {
    
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    
    public static boolean checkPassword(String plaintTextPassword, String hashedPassword) {
    
        return BCrypt.checkpw(plaintTextPassword, hashedPassword);
    }
    
}
