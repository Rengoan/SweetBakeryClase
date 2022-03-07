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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lukelar
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    EmpleadoService empleadoService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "editar":
                        this.editarEmpleado(request, response);
                        break;
                    case "eliminar":
                        this.eliminarEmpleado(request, response);
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
                    this.insertarEmpleado(request, response);
                    break;
                case "modificar":
                    this.modificarEmpleado(request, response);
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
        List<Empleado> empleados = empleadoService.listarEmpleados();
        System.out.println("Empleados: " + empleados);
        
        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("totalEmpleados", empleados.size());
        
        // Ponemos personas en un alcance
        request.setAttribute("empleados", empleados);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/empleados.jsp").forward(request, 
                response);
    }
    
     // Método que inserta un nueva empleado
    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. Recuperamos los parámetros del request
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        
        
        
        
        //2. Creamos nuestro objeto Empleado
        Empleado empleado = new Empleado(nombre, apellido, telefono, correo, usuario, pass, direccion);
        //3. Invocamos al método de acceso a datos que inserta un empleado
        empleadoService.registrarEmpleado(empleado);
        //4. Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
    
    private void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros
        int idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
        
        // 2. Ahora invocamos el método buscar cliente de acceso a datos
        Empleado empleado = empleadoService.encontrarEmpleadoID(new Empleado(idEmpleado));
        
        // 3. Ahora compartimos el cliente en el alcance de request
        request.setAttribute("empleado", empleado);
        
        String jspeditar = "/WEB-INF/paginas/empleados/editarEmpleado.jsp";
        
        // 4. Redirigimos y propagamos
        request.getRequestDispatcher(jspeditar).forward(request, response);
        
    }
    
    private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros pasamos por el formulario
        int idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        
       
        
        // 2. Creamos el objeto del cliente que queremos actualizar
        Empleado empleado = new Empleado(idEmpleado, nombre, apellido, telefono, correo, usuario, pass, direccion);
        
        // 3. Invocamos el método de acceso a datos para actualizar el cliente
        empleadoService.modificarEmpleado(empleado);
        
        // 4. Redirigimos a la acción default
        this.accionDefault(request, response);
        
    }
    
    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtenemos los parámetros
        int idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
        
        // 2. Crear el objeto del Cliente
        Empleado empleado = new Empleado(idEmpleado);
        
        // 3. Invocamos al método de acceso que elimina el cliente
        empleadoService.eliminarEmpleado(empleado);
        
        // 4. Redirigimos al flujo de default
        this.accionDefault(request, response);
        
        
        
        
    }
    
}
