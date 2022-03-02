/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Producto;
import java.util.List;

/**
 *
 * @author Lukelar
 */
public interface ProductoDao {
    public List<Producto> findAllProductos();
    
    public Producto findProductoByID(Producto producto);
    
    public Producto findProductoByName(Producto producto);
    
    public Producto findProductoByCate(Producto producto);
    
    public void insertProducto(Producto producto);

    public void updateProducto(Producto producto);
    
    public void deleteProducto(Producto producto); 
}
