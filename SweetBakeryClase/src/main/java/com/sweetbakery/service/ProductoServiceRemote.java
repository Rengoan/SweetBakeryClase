/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.domain.Producto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Lukelar
 */
@Remote
public interface ProductoServiceRemote {
    
    public List<Producto> listarProductos();
    
    public Producto encontrarProductoID(Producto producto);
    
    public Producto encontrarProductoPorNombre(Producto producto);
    
    public Producto encontrarProductoPorCategoria(Producto producto);
    
    public void registrarProducto(Producto producto);
    
    public void modificarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
}
