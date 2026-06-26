/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class InventarioMovimiento {
    private long idMovimiento;
    private String tipoMovimiento;
    private double cantidadDelMovimiento;
    private String detallesDelMaterialEnMovimiento;
    private long materialIdMaterial;

    public InventarioMovimiento() {}

    public InventarioMovimiento(long idMovimiento, String tipoMovimiento, double cantidadDelMovimiento,
                                String detallesDelMaterialEnMovimiento, long materialIdMaterial) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidadDelMovimiento = cantidadDelMovimiento;
        this.detallesDelMaterialEnMovimiento = detallesDelMaterialEnMovimiento;
        this.materialIdMaterial = materialIdMaterial;
    }

    // Getters y Setters
    public long getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(long idMovimiento) { this.idMovimiento = idMovimiento; }

    public String getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(String tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }

    public double getCantidadDelMovimiento() { return cantidadDelMovimiento; }
    public void setCantidadDelMovimiento(double cantidadDelMovimiento) { this.cantidadDelMovimiento = cantidadDelMovimiento; }

    public String getDetallesDelMaterialEnMovimiento() { return detallesDelMaterialEnMovimiento; }
    public void setDetallesDelMaterialEnMovimiento(String detallesDelMaterialEnMovimiento) { this.detallesDelMaterialEnMovimiento = detallesDelMaterialEnMovimiento; }

    public long getMaterialIdMaterial() { return materialIdMaterial; }
    public void setMaterialIdMaterial(long materialIdMaterial) { this.materialIdMaterial = materialIdMaterial; }
}
