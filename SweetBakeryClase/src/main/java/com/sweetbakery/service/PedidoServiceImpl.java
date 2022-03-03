/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.data.PedidoDao;
import com.sweetbakery.domain.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Lukelar
 */
@Stateless
public class PedidoServiceImpl implements PedidoService, PedidoServiceRemote{
    
    @Inject
    private PedidoDao pedidoDao;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoDao.findAllPedidos();
    }

    @Override
    public Pedido encontrarPedidoID(Pedido pedido) {
        return pedidoDao.findPedidoByID(pedido);
    }

    @Override
    public Pedido encontrarPedidoPorFecha(Pedido pedido) {
        return pedidoDao.findPedidoByDate(pedido);
    }

    @Override
    public void registrarPedido(Pedido pedido) {
        pedidoDao.insertPedido(pedido);
    }

    @Override
    public void modificarPedido(Pedido pedido) {
        pedidoDao.updatePedido(pedido);
    }

    @Override
    public void eliminarPedido(Pedido pedido) {
        pedidoDao.deletePedido(pedido);
    }
    
}
