/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.domain.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukelar
 */
@Local
public interface ClienteService {
    
    public List<Cliente> listarClientes();
    
    public Cliente encontrarClientePorID(Cliente cliente);
    
    public Cliente encontrarClientePorUsuario(Cliente cliente);
    
    public void registrarCliente(Cliente cliente);
    
    public void modificarCliente(Cliente cliente);
    
    public void eliminarCliente(Cliente cliente);
    
}
