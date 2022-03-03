/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukelar
 */
public class EmpleadoDaoImpl implements EmpleadoDao {

    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "sweetbakery")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Empleado> findAllEmpleados() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Override
    public Empleado findEmpleadoByID(Empleado empleado) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Empleado.class, empleado.getIdempleado());
    }

    @Override
    public Empleado findEmpleadoByUsername(Empleado empleado) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Empleado sino que vamos a incluirlo directamente.
        Query query = em.createQuery("from Cliente e where e.usuario = :usuario");
        query.setParameter("usuario", empleado.getUsuario());
        // Y ahroa sólo esperamos un resultado, porque el usuario debe de ser único
        // sino lo hemos definido así lo modificamos en nuestra tabla como unique
        return (Empleado) query.getSingleResult();
    }

    @Override
    public void insertEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(empleado));
    }

}
