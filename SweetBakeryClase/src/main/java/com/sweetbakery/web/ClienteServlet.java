/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

import com.sweetbakery.domain.Cliente;
import com.sweetbakery.service.ClienteService;
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
@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ClienteService clienteService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Cliente> clientes = clienteService.listarClientes();
        System.out.println("Clientes: " + clientes);
        
        // Ponemos personas en un alcance
        request.setAttribute("clientes", clientes);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoClientesPrueba.jsp").forward(request, 
                respose);
    }
    
}
