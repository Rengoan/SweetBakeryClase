/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.data.ProveedorDao;
import com.sweetbakery.domain.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Lukelar
 */
@Stateless
public class ProveedorServiceImpl implements ProveedorService, ProveedorServiceRemote {
    
    @Inject
    private ProveedorDao proveedorDao;
    
    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorDao.findAllProveedores();
    }
    
    @Override
    public Proveedor encontrarProveedorID(Proveedor proveedor) {
        return proveedorDao.findProveedorByID(proveedor);
    }
    
    @Override
    public Proveedor encontrarProveedorPorNombre(Proveedor proveedor) {
        return proveedorDao.findProveedorByName(proveedor);
    }
    
    @Override
    public Proveedor encontrarProveedorPorDireccion(Proveedor proveedor) {
        return proveedorDao.findProveedorByDirecc(proveedor);
    }
    
    @Override
    public void registrarProveedor(Proveedor proveedor) {
        proveedorDao.insertProveedor(proveedor);
    }
    
    @Override
    public void modificarProveedor(Proveedor proveedor) {
        proveedorDao.updateProveedor(proveedor);
    }
    
    @Override
    public void eliminarProveedor(Proveedor proveedor) {
        proveedorDao.deleteProveedor(proveedor);
    }
    
}
