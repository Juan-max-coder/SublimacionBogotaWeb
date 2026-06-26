/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Reporte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    // CREATE
    public boolean insertarReporte(Reporte reporte) {
        String sql = "INSERT INTO Reporte (tipoReporte, fechaReporte, Usuario_idUsuario) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, reporte.getTipoReporte());
            ps.setTimestamp(2, new Timestamp(reporte.getFechaReporte().getTime()));
            ps.setLong(3, reporte.getUsuarioIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar Reporte: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Reporte> listarReportes() {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reporte";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reporte r = new Reporte();
                r.setIdReporte(rs.getLong("idReporte"));
                r.setTipoReporte(rs.getString("tipoReporte"));
                r.setFechaReporte(rs.getTimestamp("fechaReporte"));
                r.setUsuarioIdUsuario(rs.getLong("Usuario_idUsuario"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Reportes: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarReporte(Reporte reporte) {
        String sql = "UPDATE Reporte SET tipoReporte=?, fechaReporte=?, Usuario_idUsuario=? WHERE idReporte=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, reporte.getTipoReporte());
            ps.setTimestamp(2, new Timestamp(reporte.getFechaReporte().getTime()));
            ps.setLong(3, reporte.getUsuarioIdUsuario());
            ps.setLong(4, reporte.getIdReporte());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Reporte: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarReporte(long idReporte) {
        String sql = "DELETE FROM Reporte WHERE idReporte=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idReporte);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Reporte: " + e.getMessage());
            return false;
        }
    }
}