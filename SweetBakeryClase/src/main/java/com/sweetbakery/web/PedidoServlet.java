/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

import com.sweetbakery.domain.Cliente;
import com.sweetbakery.domain.Empleado;
import com.sweetbakery.domain.Pedido;
import com.sweetbakery.service.PedidoService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {

    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    PedidoService pedidoService; // Cremos una instancia de nuestra if local

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. Leer los parametros de nuestro request
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPedido(request, response);
                    break;
                case "eliminar":
                    this.eliminarPedido(request, response);
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
        if (accion != null) {
            switch (accion) {
                case "insertar": {
                    try {
                        this.insertarPedido(request, response);
                    } catch (ParseException ex) {
                        Logger.getLogger(PedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "modificar": {
                    try {
                        this.modificarPedido(request, response);
                    } catch (ParseException ex) {
                        Logger.getLogger(PedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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

        /**
         * Ahora este método va acceder al listado de personas por medio de la
         * instancia que estamos recibiendo el EJB
         */
        List<Pedido> pedidos = pedidoService.listarPedidos();
        System.out.println("Pedidos: " + pedidos);

        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        HttpSession sesion = request.getSession();

        sesion.setAttribute("pedidos", pedidos);
        sesion.setAttribute("totalPedidos", pedidos.size());

        // Ponemos personas en un alcance
        request.setAttribute("pedidos", pedidos);

        // Redirigimos al JSP
        request.getRequestDispatcher("/pedidos.jsp").forward(request,
                response);
    }

    private void insertarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //1. Recuperamos los parámetros del request
        Date fecha = df.parse(request.getParameter("fecha"));

        Double total = Double.parseDouble(request.getParameter("total"));
        int idCliente = Integer.parseInt(request.getParameter("cliente"));
        int idEmpleado = Integer.parseInt(request.getParameter("empleado"));

        Cliente cliente = new Cliente(idCliente);
        Empleado empleado = new Empleado(idEmpleado);
        
        Pedido pedido = new Pedido(fecha, total, cliente, empleado);
        //3. Invocamos al método de acceso a datos que inserta un empleado
        pedidoService.registrarPedido(pedido);
        //4. Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }

    private void editarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recuperamos los parámetros
        int idPedido = Integer.parseInt(request.getParameter("idpedido"));

        // 2. Ahora invocamos el método buscar cliente de acceso a datos
        Pedido pedido = pedidoService.encontrarPedidoID(new Pedido(idPedido));

        // 3. Ahora compartimos el cliente en el alcance de request
        request.setAttribute("pedido", pedido);

        String jspeditar = "/WEB-INF/paginas/pedidos/editarPedido.jsp";

        // 4. Redirigimos y propagamos
        request.getRequestDispatcher(jspeditar).forward(request, response);

    }

    private void modificarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        // 1. Recuperamos los parámetros pasamos por el formulario
        int idPedido = Integer.parseInt(request.getParameter("idpedido"));

       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //1. Recuperamos los parámetros del request
        Date fecha = df.parse(request.getParameter("fecha"));
        
        Double total = Double.parseDouble(request.getParameter("total"));
        int idCliente = Integer.parseInt(request.getParameter("cliente"));
        int idEmpleado = Integer.parseInt(request.getParameter("empleado"));

        Cliente cliente = new Cliente(idCliente);
        Empleado empleado = new Empleado(idEmpleado);
        
        //Proveedor proveedor = new Proveedor(nombre, correo, telefono, direccion, empleado);

        // 2. Creamos el objeto del cliente que queremos actualizar
        Pedido pedido = new Pedido(idPedido, fecha, total, cliente, empleado);

        // 3. Invocamos el método de acceso a datos para actualizar el cliente
        pedidoService.modificarPedido(pedido);

        // 4. Redirigimos a la acción default
        this.accionDefault(request, response);

    }

    private void eliminarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Obtenemos los parámetros
        int idPedido = Integer.parseInt(request.getParameter("idpedido"));

        Pedido pedido = new Pedido(idPedido);

        // 3. Invocamos al método de acceso que elimina el cliente
        pedidoService.eliminarPedido(pedido);

        // 4. Redirigimos al flujo de default
        this.accionDefault(request, response);

    }
}
