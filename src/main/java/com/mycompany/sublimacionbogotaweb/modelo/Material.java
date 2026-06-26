/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class Material {
    private long idMaterial;
    private String nombreMaterial;
    private String tipoMaterial;
    private String colorMaterial;
    private double cantidadDisponibleMaterial;
    private long clienteIdCliente;

    public Material() {}

    public Material(long idMaterial, String nombreMaterial, String tipoMaterial,
                    String colorMaterial, double cantidadDisponibleMaterial,
                    long clienteIdCliente) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.tipoMaterial = tipoMaterial;
        this.colorMaterial = colorMaterial;
        this.cantidadDisponibleMaterial = cantidadDisponibleMaterial;
        this.clienteIdCliente = clienteIdCliente;
    }

    // Getters y Setters
    public long getIdMaterial() { return idMaterial; }
    public void setIdMaterial(long idMaterial) { this.idMaterial = idMaterial; }

    public String getNombreMaterial() { return nombreMaterial; }
    public void setNombreMaterial(String nombreMaterial) { this.nombreMaterial = nombreMaterial; }

    public String getTipoMaterial() { return tipoMaterial; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterial = tipoMaterial; }

    public String getColorMaterial() { return colorMaterial; }
    public void setColorMaterial(String colorMaterial) { this.colorMaterial = colorMaterial; }

    public double getCantidadDisponibleMaterial() { return cantidadDisponibleMaterial; }
    public void setCantidadDisponibleMaterial(double cantidadDisponibleMaterial) { this.cantidadDisponibleMaterial = cantidadDisponibleMaterial; }

    public long getClienteIdCliente() { return clienteIdCliente; }
    public void setClienteIdCliente(long clienteIdCliente) { this.clienteIdCliente = clienteIdCliente; }
}