/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.web;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lukelar
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    ProductoService productoService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "editar":
                        this.editarProducto(request, response);
                        break;
                    case "eliminar":
                        this.eliminarProducto(request, response);
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
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
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
        List<Producto> productos = productoService.listarProductos();
        System.out.println("Productos: " + productos);
        
        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("productos", productos);
        sesion.setAttribute("totalProductos", productos.size());
        sesion.setAttribute("total", calcularStock(productos));
        sesion.setAttribute("caro", calcularMax(productos));
        
        // Ponemos personas en un alcance
        request.setAttribute("productos", productos);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/productos.jsp").forward(request, 
                response);
    }
    
    private int calcularStock(List<Producto> productos){
        int total = 0;
        
        for(Producto producto: productos){
            total += producto.getStock();
        }
        
        return total;
    }
    
    private double calcularMax(List<Producto> productos){
        double max = 0;
        
        for(Producto producto: productos){
            if (producto.getPrecio()> max ) {
                max = producto.getPrecio();
            }  
        }
        
        return max;
    }
    
    
    
    private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //1. Recuperamos los parámetros del request
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        
        
        
        Producto producto = new Producto(nombre, categoria, precio, stock);
        //3. Invocamos al método de acceso a datos que inserta un empleado
        productoService.registrarProducto(producto);
        //4. Redirigimos a la acción por defecto
        this.accionDefault(request, response);
    }
    
    private void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        
        // 2. Ahora invocamos el método buscar cliente de acceso a datos
        Producto producto = productoService.encontrarProductoID(new Producto(idProducto));
        
        // 3. Ahora compartimos el cliente en el alcance de request
        request.setAttribute("producto", producto);
        
        String jspeditar = "/WEB-INF/paginas/productos/editarProducto.jsp";
        
        // 4. Redirigimos y propagamos
        request.getRequestDispatcher(jspeditar).forward(request, response);
        
    }
    
    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los parámetros pasamos por el formulario
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
       
        
        // 2. Creamos el objeto del cliente que queremos actualizar
        Producto producto = new Producto(idProducto, nombre, categoria, precio, stock);
        
        // 3. Invocamos el método de acceso a datos para actualizar el cliente
        productoService.modificarProducto(producto);
        
        // 4. Redirigimos a la acción default
        this.accionDefault(request, response);
        
    }
    
    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtenemos los parámetros
        int idProducto = Integer.parseInt(request.getParameter("idproducto"));
        
        Producto producto = new Producto(idProducto);
        
        // 3. Invocamos al método de acceso que elimina el cliente
        productoService.eliminarProducto(producto);
        
        // 4. Redirigimos al flujo de default
        this.accionDefault(request, response);
        
        
        
        
    }
    
}
