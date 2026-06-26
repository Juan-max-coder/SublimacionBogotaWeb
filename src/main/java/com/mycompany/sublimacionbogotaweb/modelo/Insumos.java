/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class Insumos {
    private long idInsumo;
    private String nombreInsumo;
    private double costoInsumo;
    private int stockInsumo;
    private double precioInsumo;
    private long inventarioMovimientoIdMovimiento;

    public Insumos() {}

    public Insumos(long idInsumo, String nombreInsumo, double costoInsumo,
                   int stockInsumo, double precioInsumo, long inventarioMovimientoIdMovimiento) {
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.costoInsumo = costoInsumo;
        this.stockInsumo = stockInsumo;
        this.precioInsumo = precioInsumo;
        this.inventarioMovimientoIdMovimiento = inventarioMovimientoIdMovimiento;
    }

    // Getters y Setters
    public long getIdInsumo() { return idInsumo; }
    public void setIdInsumo(long idInsumo) { this.idInsumo = idInsumo; }

    public String getNombreInsumo() { return nombreInsumo; }
    public void setNombreInsumo(String nombreInsumo) { this.nombreInsumo = nombreInsumo; }

    public double getCostoInsumo() { return costoInsumo; }
    public void setCostoInsumo(double costoInsumo) { this.costoInsumo = costoInsumo; }

    public int getStockInsumo() { return stockInsumo; }
    public void setStockInsumo(int stockInsumo) { this.stockInsumo = stockInsumo; }

    public double getPrecioInsumo() { return precioInsumo; }
    public void setPrecioInsumo(double precioInsumo) { this.precioInsumo = precioInsumo; }

    public long getInventarioMovimientoIdMovimiento() { return inventarioMovimientoIdMovimiento; }
    public void setInventarioMovimientoIdMovimiento(long inventarioMovimientoIdMovimiento) { this.inventarioMovimientoIdMovimiento = inventarioMovimientoIdMovimiento; }
}