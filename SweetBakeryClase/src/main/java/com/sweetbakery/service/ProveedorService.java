/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.domain.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukelar
*/
@Local
public interface ProveedorService {
    
    public List<Proveedor> listarProveedores();
    
    public Proveedor encontrarProveedorID(Proveedor proveedor);
    
    public Proveedor encontrarProveedorPorNombre(Proveedor proveedor);
    
    public Proveedor encontrarProveedorPorDireccion(Proveedor proveedor);
    
    public void registrarProveedor(Proveedor proveedor);
    
    public void modificarProveedor(Proveedor proveedor);
    
    public void eliminarProveedor(Proveedor proveedor);
    
    
}
