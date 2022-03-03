/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Pedido;
import com.sweetbakery.domain.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukelar
 */
public class PedidoDaoImpl implements PedidoDao{
    
    // El EJB se encarga de forma automática de hacer las transacciones.
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "sweetbakery")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD

    @Override
    public List<Pedido> findAllPedidos() {
        return em.createNamedQuery("Pedido.findAll").getResultList();
    }

    @Override
    public Pedido findPedidoByID(Pedido pedido) {
        return em.find(Pedido.class, pedido.getIdpedido());
    }

    @Override
    public Pedido findPedidoByDate(Pedido pedido) {
        Query query = em.createQuery("from Pedido p where p.fecha = :fecha");
        query.setParameter("fecha", pedido.getFecha());
        return (Pedido) query.getSingleResult();
    }

    @Override
    public void insertPedido(Pedido pedido) {
        em.persist(pedido);
    }

    @Override
    public void updatePedido(Pedido pedido) {
        em.merge(pedido);
    }

    @Override
    public void deletePedido(Pedido pedido) {
        em.remove(em.merge(pedido));
    }
    
}
