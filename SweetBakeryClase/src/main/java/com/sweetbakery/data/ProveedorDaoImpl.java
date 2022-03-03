/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Empleado;
import com.sweetbakery.domain.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukelar
 */
public class ProveedorDaoImpl implements ProveedorDao{
    
    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "sweetbakery")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD

    @Override
    public List<Proveedor> findAllProveedores() {
         return em.createNamedQuery("Proveedor.findAll").getResultList();
    }

    @Override
    public Proveedor findProveedorByID(Proveedor proveedor) {
        return em.find(Proveedor.class, proveedor.getIdproveedor());
    }

    @Override
    public Proveedor findProveedorByName(Proveedor proveedor) {
        Query query = em.createQuery("from Proveedor p where p.nombre = :nombre");
        query.setParameter("nombre", proveedor.getNombre());
        return (Proveedor) query.getSingleResult();
    }

    @Override
    public Proveedor findProveedorByDirecc(Proveedor proveedor) {
        Query query = em.createQuery("from Proveedor p where p.direccion = :direccion");
        query.setParameter("direccion", proveedor.getDireccion());
        return (Proveedor) query.getSingleResult();
    }

    @Override
    public void insertProveedor(Proveedor proveedor) {
        em.persist(proveedor);
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        em.remove(em.merge(proveedor));
    }
    
}
