/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

public class Empleado {
    private long idEmpleado;
    private String nombreEmpleado;
    private String cargoEmpleado;
    private String areaEmpleado;
    private String contactoEmpleado;
    private long usuarioIdUsuario;

    public Empleado() {}

    public Empleado(long idEmpleado, String nombreEmpleado, String cargoEmpleado,
                    String areaEmpleado, String contactoEmpleado, long usuarioIdUsuario) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.areaEmpleado = areaEmpleado;
        this.contactoEmpleado = contactoEmpleado;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    // Getters y Setters
    public long getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(long idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }

    public String getCargoEmpleado() { return cargoEmpleado; }
    public void setCargoEmpleado(String cargoEmpleado) { this.cargoEmpleado = cargoEmpleado; }

    public String getAreaEmpleado() { return areaEmpleado; }
    public void setAreaEmpleado(String areaEmpleado) { this.areaEmpleado = areaEmpleado; }

    public String getContactoEmpleado() { return contactoEmpleado; }
    public void setContactoEmpleado(String contactoEmpleado) { this.contactoEmpleado = contactoEmpleado; }

    public long getUsuarioIdUsuario() { return usuarioIdUsuario; }
    public void setUsuarioIdUsuario(long usuarioIdUsuario) { this.usuarioIdUsuario = usuarioIdUsuario; }
}