/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.modelo;

import java.util.Date;

public class Reporte {
    private long idReporte;
    private String tipoReporte;
    private Date fechaReporte;
    private long usuarioIdUsuario;

    public Reporte() {}

    public Reporte(long idReporte, String tipoReporte, Date fechaReporte, long usuarioIdUsuario) {
        this.idReporte = idReporte;
        this.tipoReporte = tipoReporte;
        this.fechaReporte = fechaReporte;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    // Getters y Setters
    public long getIdReporte() { return idReporte; }
    public void setIdReporte(long idReporte) { this.idReporte = idReporte; }

    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }

    public Date getFechaReporte() { return fechaReporte; }
    public void setFechaReporte(Date fechaReporte) { this.fechaReporte = fechaReporte; }

    public long getUsuarioIdUsuario() { return usuarioIdUsuario; }
    public void setUsuarioIdUsuario(long usuarioIdUsuario) { this.usuarioIdUsuario = usuarioIdUsuario; }
    
    }