/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Empleado;
import java.util.List;

/**
 *
 * @author Lukelar
 */
public interface EmpleadoDao {
    
    public List<Empleado> findAllEmpleados();
    
    public Empleado findEmpleadoByID(Empleado empleado);
    
    public Empleado findEmpleadoByUsername(Empleado empleado);
    
    public void insertEmpleado(Empleado empleado);

    public void updateEmpleado(Empleado empleado);
    
    public void deleteEmpleado(Empleado empleado);  
    
}
