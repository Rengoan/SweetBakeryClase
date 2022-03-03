/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.data;

import com.sweetbakery.domain.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lukelar
 */
public class ClienteDaoImpl implements ClienteDao{
    
    // El EJB se encarga de forma automática de hacer las transacciones.
    
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName="sweetbakery")
    EntityManager em;
    
    // Con este objeto de em ya podemos interactuar con nuestra BD

    @Override
    public List<Cliente> findAllClientes() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public Cliente findClienteByID(Cliente cliente) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Cliente.class, cliente.getIdcliente());
    }

    @Override
    public Cliente findClienteByUsername(Cliente cliente) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Cliente sino que vamos a incluirlo directamente.
        Query query = em.createQuery("from Cliente c where c.usuario = :usuario");
        query.setParameter("usuario", cliente.getUsuario());
        // Y ahroa sólo esperamos un resultado, porque el usuario debe de ser único
        // sino lo hemos definido así lo modificamos en nuestra tabla como unique
        return (Cliente) query.getSingleResult();
    }

    @Override
    public void insertCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(cliente));
    }
    
}
