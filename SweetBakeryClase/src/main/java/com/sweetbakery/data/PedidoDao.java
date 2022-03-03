/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Pedido;
import com.sweetbakery.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Lukelar
 */
public interface PedidoDao {
    
    public List<Pedido> findAllPedidos();
    
    public Pedido findPedidoByID(Pedido pedido);
    
    public Pedido findPedidoByDate(Pedido pedido);
    
    public void insertPedido(Pedido pedido);

    public void updatePedido(Pedido pedido);
    
    public void deletePedido(Pedido pedido); 
    
}
