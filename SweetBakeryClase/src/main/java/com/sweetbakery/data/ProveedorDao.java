/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Lukelar
 */
public interface ProveedorDao {
    
    public List<Proveedor> findAllProveedores();
    
    public Proveedor findProveedorByID(Proveedor proveedor);
    
    public Proveedor findProveedorByName(Proveedor proveedor);
    
    public Proveedor findProveedorByDirecc(Proveedor proveedor);
    
    public void insertProveedor(Proveedor proveedor);

    public void updateProveedor(Proveedor proveedor);
    
    public void deleteProveedor(Proveedor proveedor); 
    
}
