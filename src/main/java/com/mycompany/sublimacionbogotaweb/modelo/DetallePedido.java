/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class DetallePedido {
    private long idDetalle;
    private double cantidadMaterial;
    private double precioUnitarioMaterial;
    private double costoManoDeObra;
    private double subtotalPedido;
    private long pedidoIdPedido;
    private long materialIdMaterial;
    private long insumosIdInsumo;

    public DetallePedido() {}

    public DetallePedido(long idDetalle, double cantidadMaterial, double precioUnitarioMaterial,
                         double costoManoDeObra, double subtotalPedido,
                         long pedidoIdPedido, long materialIdMaterial, long insumosIdInsumo) {
        this.idDetalle = idDetalle;
        this.cantidadMaterial = cantidadMaterial;
        this.precioUnitarioMaterial = precioUnitarioMaterial;
        this.costoManoDeObra = costoManoDeObra;
        this.subtotalPedido = subtotalPedido;
        this.pedidoIdPedido = pedidoIdPedido;
        this.materialIdMaterial = materialIdMaterial;
        this.insumosIdInsumo = insumosIdInsumo;
    }
    
// Getters y Setters
    public long getIdDetalle() { return idDetalle; }
    public void setIdDetalle(long idDetalle) { this.idDetalle = idDetalle; }

    public double getCantidadMaterial() { return cantidadMaterial; }
    public void setCantidadMaterial(double cantidadMaterial) { this.cantidadMaterial = cantidadMaterial; }

    public double getPrecioUnitarioMaterial() { return precioUnitarioMaterial; }
    public void setPrecioUnitarioMaterial(double precioUnitarioMaterial) { this.precioUnitarioMaterial = precioUnitarioMaterial; }

    public double getCostoManoDeObra() { return costoManoDeObra; }
    public void setCostoManoDeObra(double costoManoDeObra) { this.costoManoDeObra = costoManoDeObra; }

    public double getSubtotalPedido() { return subtotalPedido; }
    public void setSubtotalPedido(double subtotalPedido) { this.subtotalPedido = subtotalPedido; }

    public long getPedidoIdPedido() { return pedidoIdPedido; }
    public void setPedidoIdPedido(long pedidoIdPedido) { this.pedidoIdPedido = pedidoIdPedido; }

    public long getMaterialIdMaterial() { return materialIdMaterial; }
    public void setMaterialIdMaterial(long materialIdMaterial) { this.materialIdMaterial = materialIdMaterial; }

    public long getInsumosIdInsumo() { return insumosIdInsumo; }
    public void setInsumosIdInsumo(long insumosIdInsumo) { this.insumosIdInsumo = insumosIdInsumo; }
}
