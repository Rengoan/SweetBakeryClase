/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

import com.sweetbakery.domain.Cliente;
import com.sweetbakery.domain.Producto;
import com.sweetbakery.service.ProductoService;
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
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ProductoService productoService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Producto> productos = productoService.listarProductos();
        System.out.println("Productos: " + productos);
        
        // Ponemos personas en un alcance
        request.setAttribute("productos", productos);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoProductosPrueba.jsp").forward(request, 
                respose);
    }
    
}
