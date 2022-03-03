/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Cliente;
import java.util.List;

/**
 *
 * @author Lukelar
 */
public interface ClienteDao {
    
    public List<Cliente> findAllClientes();
    
    public Cliente findClienteByID(Cliente cliente);
    
    public Cliente findClienteByUsername(Cliente cliente);
    
    public void insertCliente(Cliente cliente);

    public void updateCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);    
    
}
