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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lukelar
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ClienteService clienteService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "editar":
                        this.editarCliente(request, response);
                        break;
                    case "eliminar":
                        this.eliminarCliente(request, response);
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
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
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
        List<Cliente> clientes = clienteService.listarClientes();
        System.out.println("Clientes: " + clientes);
        
        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        
        // Ponemos personas en un alcance
        request.setAttribute("clientes", clientes);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/clientes.jsp").forward(request, 
                response);
    }
    
    
   
    
    
     // Método que inserta un nueva cliente
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. Recuperamos los parámetros del request
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        
        
        
        
        //2. Creamos nuestro objeto Cliente
        Cliente cliente = new Cliente(nombre, apellido, telefono, correo, usuario, pass, direccion);
        //3. Invocamos al método de acceso a datos que inserta un cliente
        clienteService.registrarCliente(cliente);
        //4. Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        
        // 2. Ahora invocamos el método buscar cliente de acceso a datos
        Cliente cliente = clienteService.encontrarClientePorID(new Cliente(idCliente));
        
        // 3. Ahora compartimos el cliente en el alcance de request
        request.setAttribute("cliente", cliente);
        
        String jspeditar = "/WEB-INF/paginas/clientes/editarCliente.jsp";
        
        // 4. Redirigimos y propagamos
        request.getRequestDispatcher(jspeditar).forward(request, response);
        
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros pasamos por el formulario
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        
       
        
        // 2. Creamos el objeto del cliente que queremos actualizar
        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, correo, usuario, pass, direccion);
        
        // 3. Invocamos el método de acceso a datos para actualizar el cliente
        clienteService.modificarCliente(cliente);
        
        // 4. Redirigimos a la acción default
        this.accionDefault(request, response);
        
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtenemos los parámetros
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        
        // 2. Crear el objeto del Cliente
        Cliente cliente = new Cliente(idCliente);
        
        // 3. Invocamos al método de acceso que elimina el cliente
        clienteService.eliminarCliente(cliente);
        
        // 4. Redirigimos al flujo de default
        this.accionDefault(request, response);
        
        
        
        
    }
    
}
