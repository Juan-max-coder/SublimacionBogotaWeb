/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class TareaProduccion {
    private long idTarea;
    private String descripcionTarea;
    private String estadoTarea;
    private double avanceTarea;
    private long empleadoIdEmpleado;
    private long produccionIdProduccion;

    public TareaProduccion() {}

    public TareaProduccion(long idTarea, String descripcionTarea, String estadoTarea,
                           double avanceTarea, long empleadoIdEmpleado, long produccionIdProduccion) {
        this.idTarea = idTarea;
        this.descripcionTarea = descripcionTarea;
        this.estadoTarea = estadoTarea;
        this.avanceTarea = avanceTarea;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
        this.produccionIdProduccion = produccionIdProduccion;
    }

    // Getters y Setters
    public long getIdTarea() { return idTarea; }
    public void setIdTarea(long idTarea) { this.idTarea = idTarea; }

    public String getDescripcionTarea() { return descripcionTarea; }
    public void setDescripcionTarea(String descripcionTarea) { this.descripcionTarea = descripcionTarea; }

    public String getEstadoTarea() { return estadoTarea; }
    public void setEstadoTarea(String estadoTarea) { this.estadoTarea = estadoTarea; }

    public double getAvanceTarea() { return avanceTarea; }
    public void setAvanceTarea(double avanceTarea) { this.avanceTarea = avanceTarea; }

    public long getEmpleadoIdEmpleado() { return empleadoIdEmpleado; }
    public void setEmpleadoIdEmpleado(long empleadoIdEmpleado) { this.empleadoIdEmpleado = empleadoIdEmpleado; }

    public long getProduccionIdProduccion() { return produccionIdProduccion; }
    public void setProduccionIdProduccion(long produccionIdProduccion) { this.produccionIdProduccion = produccionIdProduccion; }
}
