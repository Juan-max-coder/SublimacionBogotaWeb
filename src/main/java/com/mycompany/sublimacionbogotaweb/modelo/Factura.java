/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

import java.util.Date;

public class Factura {
    private long idFactura;
    private String estadoFactura;
    private Date fechaExportacionFactura;
    private Date fechaConfirmacionFactura;
    private long pedidoIdPedido;

    public Factura() {}

    public Factura(long idFactura, String estadoFactura, Date fechaExportacionFactura,
                   Date fechaConfirmacionFactura, long pedidoIdPedido) {
        this.idFactura = idFactura;
        this.estadoFactura = estadoFactura;
        this.fechaExportacionFactura = fechaExportacionFactura;
        this.fechaConfirmacionFactura = fechaConfirmacionFactura;
        this.pedidoIdPedido = pedidoIdPedido;
    }

    // Getters y Setters
    public long getIdFactura() { return idFactura; }
    public void setIdFactura(long idFactura) { this.idFactura = idFactura; }

    public String getEstadoFactura() { return estadoFactura; }
    public void setEstadoFactura(String estadoFactura) { this.estadoFactura = estadoFactura; }

    public Date getFechaExportacionFactura() { return fechaExportacionFactura; }
    public void setFechaExportacionFactura(Date fechaExportacionFactura) { this.fechaExportacionFactura = fechaExportacionFactura; }

    public Date getFechaConfirmacionFactura() { return fechaConfirmacionFactura; }
    public void setFechaConfirmacionFactura(Date fechaConfirmacionFactura) { this.fechaConfirmacionFactura = fechaConfirmacionFactura; }

    public long getPedidoIdPedido() { return pedidoIdPedido; }
    public void setPedidoIdPedido(long pedidoIdPedido) { this.pedidoIdPedido = pedidoIdPedido; }
}