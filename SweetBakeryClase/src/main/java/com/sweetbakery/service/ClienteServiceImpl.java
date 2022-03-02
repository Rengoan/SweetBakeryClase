/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.data.ClienteDao;
import com.sweetbakery.domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Lukelar
 */
@Stateless
public class ClienteServiceImpl implements ClienteServiceRemote, ClienteService {
    
    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar personaDao
    @Inject    
    private ClienteDao clienteDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios

    @Override
    public List<Cliente> listarClientes() {
        return clienteDao.findAllClientes();
    }

    @Override
    public Cliente encontrarClientePorID(Cliente cliente) {
        return clienteDao.findClienteByID(cliente);
    }

    @Override
    public Cliente encontrarClientePorUsuario(Cliente cliente) {
        return clienteDao.findClienteByUsername(cliente);
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        clienteDao.insertUsuario(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        clienteDao.updateCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteDao.deleteCliente(cliente);
    }
    
}
