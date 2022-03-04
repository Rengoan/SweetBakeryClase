/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sweetbakery.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Lukelar
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Detallespedido.findAll", query = "SELECT d FROM Detallespedido d"),
    @NamedQuery(name = "Detallespedido.findByIddetallespedido", query = "SELECT d FROM Detallespedido d WHERE d.iddetallespedido = :iddetallespedido"),
    @NamedQuery(name = "Detallespedido.findByPrecioVente", query = "SELECT d FROM Detallespedido d WHERE d.precioVente = :precioVente"),
    @NamedQuery(name = "Detallespedido.findByCantidad", query = "SELECT d FROM Detallespedido d WHERE d.cantidad = :cantidad")})
public class Detallespedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iddetallespedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_vente")
    private Double precioVente;
    private Integer cantidad;
    @JoinColumn(name = "pedido_idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;

    public Detallespedido(Integer iddetallespedido, Double precioVente, Integer cantidad, Pedido pedido, Producto producto) {
        this.iddetallespedido = iddetallespedido;
        this.precioVente = precioVente;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Detallespedido(Double precioVente, Integer cantidad, Pedido pedido, Producto producto) {
        this.precioVente = precioVente;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
    }
    
    

    public Detallespedido() {
    }

    public Detallespedido(Integer iddetallespedido) {
        this.iddetallespedido = iddetallespedido;
    }

    public Integer getIddetallespedido() {
        return iddetallespedido;
    }

    public void setIddetallespedido(Integer iddetallespedido) {
        this.iddetallespedido = iddetallespedido;
    }

    public Double getPrecioVente() {
        return precioVente;
    }

    public void setPrecioVente(Double precioVente) {
        this.precioVente = precioVente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallespedido != null ? iddetallespedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallespedido)) {
            return false;
        }
        Detallespedido other = (Detallespedido) object;
        if ((this.iddetallespedido == null && other.iddetallespedido != null) || (this.iddetallespedido != null && !this.iddetallespedido.equals(other.iddetallespedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sweetbakery.domain.Detallespedido[ iddetallespedido=" + iddetallespedido + " ]";
    }
    
}
