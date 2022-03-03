/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.service;

import com.sweetbakery.domain.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lukelar
 */
@Local
public interface EmpleadoService {
    
    public List<Empleado> listarEmpleados();
    
    public Empleado encontrarEmpleadoID(Empleado empleado);
    
    public Empleado encontrarEmpleadoPorUsuario(Empleado empleado);
    
    public void registrarEmpleado(Empleado empleado);
    
    public void modificarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Empleado empleado);
    
}
