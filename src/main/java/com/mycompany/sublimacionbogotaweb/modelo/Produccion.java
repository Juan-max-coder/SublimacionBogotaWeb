/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

import java.util.Date;

public class Produccion {
    private long idProduccion;
    private Date fechaInicioProduccion;
    private Date fechaFinProduccion;
    private String estadoProduccion;
    private long pedidoIdPedido;

    public Produccion() {}

    public Produccion(long idProduccion, Date fechaInicioProduccion, Date fechaFinProduccion,
                      String estadoProduccion, long pedidoIdPedido) {
        this.idProduccion = idProduccion;
        this.fechaInicioProduccion = fechaInicioProduccion;
        this.fechaFinProduccion = fechaFinProduccion;
        this.estadoProduccion = estadoProduccion;
        this.pedidoIdPedido = pedidoIdPedido;
    }

    // Getters y Setters
    public long getIdProduccion() { return idProduccion; }
    public void setIdProduccion(long idProduccion) { this.idProduccion = idProduccion; }

    public Date getFechaInicioProduccion() { return fechaInicioProduccion; }
    public void setFechaInicioProduccion(Date fechaInicioProduccion) { this.fechaInicioProduccion = fechaInicioProduccion; }

    public Date getFechaFinProduccion() { return fechaFinProduccion; }
    public void setFechaFinProduccion(Date fechaFinProduccion) { this.fechaFinProduccion = fechaFinProduccion; }

    public String getEstadoProduccion() { return estadoProduccion; }
    public void setEstadoProduccion(String estadoProduccion) { this.estadoProduccion = estadoProduccion; }

    public long getPedidoIdPedido() { return pedidoIdPedido; }
    public void setPedidoIdPedido(long pedidoIdPedido) { this.pedidoIdPedido = pedidoIdPedido; }
}
