/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

import com.sweetbakery.domain.Empleado;
import com.sweetbakery.service.EmpleadoService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lukelar
 */
@WebServlet("/empleados")
public class EmpleadoServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    EmpleadoService empleadoService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Empleado> empleados = empleadoService.listarEmpleados();
        System.out.println("Empleados: " + empleados);
        
        // Ponemos personas en un alcance
        request.setAttribute("Empleados", empleados);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoEmpleadosPrueba.jsp").forward(request, 
                respose);
    }
    
}
