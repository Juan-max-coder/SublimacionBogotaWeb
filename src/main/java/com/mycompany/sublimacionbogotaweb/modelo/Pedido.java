/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

import java.util.Date;

public class Pedido {
    private long idPedido;
    private Date fechaRegistroPedido;
    private String estadoPedido;
    private String prioridadPedido;
    private Date fechaEntregaEstimadaPedido;
    private long materialIdMaterial;
    private long clienteIdCliente;
    private long empleadoIdEmpleado;

    public Pedido() {}

    public Pedido(long idPedido, Date fechaRegistroPedido, String estadoPedido,
                  String prioridadPedido, Date fechaEntregaEstimadaPedido,
                  long materialIdMaterial, long clienteIdCliente, long empleadoIdEmpleado) {
        this.idPedido = idPedido;
        this.fechaRegistroPedido = fechaRegistroPedido;
        this.estadoPedido = estadoPedido;
        this.prioridadPedido = prioridadPedido;
        this.fechaEntregaEstimadaPedido = fechaEntregaEstimadaPedido;
        this.materialIdMaterial = materialIdMaterial;
        this.clienteIdCliente = clienteIdCliente;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    // Getters y Setters
    public long getIdPedido() { return idPedido; }
    public void setIdPedido(long idPedido) { this.idPedido = idPedido; }

    public Date getFechaRegistroPedido() { return fechaRegistroPedido; }
    public void setFechaRegistroPedido(Date fechaRegistroPedido) { this.fechaRegistroPedido = fechaRegistroPedido; }

    public String getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(String estadoPedido) { this.estadoPedido = estadoPedido; }

    public String getPrioridadPedido() { return prioridadPedido; }
    public void setPrioridadPedido(String prioridadPedido) { this.prioridadPedido = prioridadPedido; }

    public Date getFechaEntregaEstimadaPedido() { return fechaEntregaEstimadaPedido; }
    public void setFechaEntregaEstimadaPedido(Date fechaEntregaEstimadaPedido) { this.fechaEntregaEstimadaPedido = fechaEntregaEstimadaPedido; }

    public long getMaterialIdMaterial() { return materialIdMaterial; }
    public void setMaterialIdMaterial(long materialIdMaterial) { this.materialIdMaterial = materialIdMaterial; }

    public long getClienteIdCliente() { return clienteIdCliente; }
    public void setClienteIdCliente(long clienteIdCliente) { this.clienteIdCliente = clienteIdCliente; }

    public long getEmpleadoIdEmpleado() { return empleadoIdEmpleado; }
    public void setEmpleadoIdEmpleado(long empleadoIdEmpleado) { this.empleadoIdEmpleado = empleadoIdEmpleado; }
}