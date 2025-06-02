/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbr.com.sbr_java.security;

import java.io.IOException;
import java.net.Proxy;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rosdri
 */
public class Filtro implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest solicitud = (HttpServletRequest) request;
        HttpServletResponse respuesta = (HttpServletResponse) response;
        
        // Atributos para las validaciones
        HttpSession sesion = solicitud.getSession();
        String rutaSolicitud = solicitud.getRequestURI();
        String raizSolicitud = solicitud.getContextPath();
        
        respuesta.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        respuesta.setHeader("Pragma", "no-cache");
        respuesta.setDateHeader("Expires", 0);
        
        // Validaciones
        // 1. Sesion valida
        boolean validarSesion = ((sesion!=null) && (sesion.getAttribute("usuario")!=null));
        
        // 2. Ruta de login
        boolean validarRutaLogin = ((rutaSolicitud.equals(raizSolicitud + "/")) || (rutaSolicitud.equals(raizSolicitud + "/login.xhtml"))  );
        
        // 3. que se carge el contenido estatico (CSS)
        boolean validarContenidoEstatico = rutaSolicitud.contains("/resources/css/style.css");
        
        if(validarSesion || validarRutaLogin || validarContenidoEstatico){
            chain.doFilter(request, response);
        }else{
            respuesta.sendRedirect(raizSolicitud);
        }
    }

    @Override
    public void destroy() {
    }
    
}
