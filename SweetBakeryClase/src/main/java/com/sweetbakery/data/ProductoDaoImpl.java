/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukelar
 */
public class ProductoDaoImpl implements ProductoDao {

    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "sweetbakery")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Producto> findAllProductos() {
        return em.createNamedQuery("Producto.findAll").getResultList();
    }

    @Override
    public Producto findProductoByID(Producto producto) {
        return em.find(Producto.class, producto.getIdproducto());
    }

    @Override
    public Producto findProductoByName(Producto producto) {
        Query query = em.createQuery("from Producto p where p.nombre = :nombre");
        query.setParameter("nombre", producto.getNombre());
        return (Producto) query.getSingleResult();
    }

    @Override
    public Producto findProductoByCate(Producto producto) {
        Query query = em.createQuery("from Producto p where p.categoria = :categoria");
        query.setParameter("categoria", producto.getCategoria());
        return (Producto) query.getSingleResult();
    }

    @Override
    public void insertProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        em.merge(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        em.remove(em.merge(producto));
    }

}
