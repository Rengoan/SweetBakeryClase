/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.domain.Pedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukelar
 */
@Local
public interface PedidoService {
    
    public List<Pedido> listarPedidos();
    
    public Pedido encontrarPedidoID(Pedido pedido);
    
    public Pedido encontrarPedidoPorFecha(Pedido pedido);
    
    public void registrarPedido(Pedido pedido);
    
    public void modificarPedido(Pedido pedido);
    
    public void eliminarPedido(Pedido pedido);
    
}
