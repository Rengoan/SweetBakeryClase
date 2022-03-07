/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

import com.sweetbakery.domain.Empleado;
import com.sweetbakery.domain.Proveedor;
import com.sweetbakery.service.ProveedorService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lukelar
 */
@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ProveedorService proveedorService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "editar":
                        this.editarProveedor(request, response);
                        break;
                    case "eliminar":
                        this.eliminarProveedor(request, response);
                        break;
                    default:
                        this.accionDefault(request, response);
                }
            } else {
                this.accionDefault(request, response);
            }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
        // 1. Leemos los parametros de nuestro request
        String accion = request.getParameter("accion");
        if (accion != null){
            switch (accion){
                case "insertar":
                    this.insertarProveedor(request, response);
                    break;
                case "modificar":
                    this.modificarProveedor(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        System.out.println("Proveedores: " + proveedores);
        
        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("proveedor", proveedores);
        sesion.setAttribute("totalProveedores", proveedores.size());
        
        // Ponemos personas en un alcance
        request.setAttribute("proveedores", proveedores);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/proveedores.jsp").forward(request, 
                response);
    }
    
    private void insertarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. Recuperamos los parámetros del request
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        int idEmpleado = Integer.parseInt(request.getParameter("empleado"));
        
        
        
        
        Proveedor proveedor = new Proveedor(nombre, correo, telefono, direccion, (new Empleado(idEmpleado)));
        //3. Invocamos al método de acceso a datos que inserta un empleado
        proveedorService.registrarProveedor(proveedor);
        //4. Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
    
    private void editarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros
        int idProveedor = Integer.parseInt(request.getParameter("idproveedor"));
        
        // 2. Ahora invocamos el método buscar cliente de acceso a datos
        Proveedor proveedor = proveedorService.encontrarProveedorID(new Proveedor(idProveedor));
        
        // 3. Ahora compartimos el cliente en el alcance de request
        request.setAttribute("proveedor", proveedor);
        
        String jspeditar = "/WEB-INF/paginas/proveedores/editarProveedor.jsp";
        
        // 4. Redirigimos y propagamos
        request.getRequestDispatcher(jspeditar).forward(request, response);
        
    }
    
    private void modificarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros pasamos por el formulario
        int idProveedor = Integer.parseInt(request.getParameter("idproveedor"));
        
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
       
        
        // 2. Creamos el objeto del cliente que queremos actualizar
        Proveedor proveedor = new Proveedor(idProveedor, nombre, correo, telefono, direccion);
        
        // 3. Invocamos el método de acceso a datos para actualizar el cliente
        proveedorService.modificarProveedor(proveedor);
        
        // 4. Redirigimos a la acción default
        this.accionDefault(request, response);
        
    }
    
    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtenemos los parámetros
        int idProveedor = Integer.parseInt(request.getParameter("idproveedor"));
        
        Proveedor proveedor = new Proveedor(idProveedor);
        
        // 3. Invocamos al método de acceso que elimina el cliente
        proveedorService.eliminarProveedor(proveedor);
        
        // 4. Redirigimos al flujo de default
        this.accionDefault(request, response);
        
        
        
        
    }
}
