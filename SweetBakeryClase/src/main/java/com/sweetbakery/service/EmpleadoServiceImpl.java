/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.data.EmpleadoDao;
import com.sweetbakery.domain.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Lukelar
 */
@Stateless
public class EmpleadoServiceImpl implements EmpleadoServiceRemote, EmpleadoService {
    
    @Inject    
    private EmpleadoDao empleadoDao;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoDao.findAllEmpleados();
    }

    @Override
    public Empleado encontrarEmpleadoID(Empleado empleado) {
        return empleadoDao.findEmpleadoByID(empleado);
    }

    @Override
    public Empleado encontrarEmpleadoPorUsuario(Empleado empleado) {
        return empleadoDao.findEmpleadoByUsername(empleado);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        empleadoDao.insertEmpleado(empleado);
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        empleadoDao.updateEmpleado(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoDao.deleteEmpleado(empleado);
    }
    
}
