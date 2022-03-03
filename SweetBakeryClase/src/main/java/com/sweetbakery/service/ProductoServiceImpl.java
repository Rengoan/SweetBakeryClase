/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.data.ProductoDao;
import com.sweetbakery.domain.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Lukelar
 */
@Stateless
public class ProductoServiceImpl implements ProductoServiceRemote, ProductoService {

    @Inject
    private ProductoDao productoDao;

    @Override
    public List<Producto> listarProductos() {
        return productoDao.findAllProductos();
    }

    @Override
    public Producto encontrarProductoID(Producto producto) {
        return productoDao.findProductoByID(producto);
    }

    @Override
    public Producto encontrarProductoPorNombre(Producto producto) {
        return productoDao.findProductoByName(producto);
    }

    @Override
    public Producto encontrarProductoPorCategoria(Producto producto) {
        return productoDao.findProductoByCate(producto);
    }

    @Override
    public void registrarProducto(Producto producto) {
        productoDao.insertProducto(producto);
    }

    @Override
    public void modificarProducto(Producto producto) {
        productoDao.updateProducto(producto);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoDao.deleteProducto(producto);
    }

}
