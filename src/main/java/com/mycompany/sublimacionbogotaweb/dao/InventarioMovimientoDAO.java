/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.modelo.InventarioMovimiento;
import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioMovimientoDAO {

    // CREATE
    public boolean insertarMovimiento(InventarioMovimiento movimiento) {
        String sql = "INSERT INTO InventarioMovimiento (tipoMovimiento, cantidadDelMovimiento, detallesDelMaterialEnMovimiento, Material_idMaterial) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movimiento.getTipoMovimiento());
            ps.setDouble(2, movimiento.getCantidadDelMovimiento());
            ps.setString(3, movimiento.getDetallesDelMaterialEnMovimiento());
            ps.setLong(4, movimiento.getMaterialIdMaterial());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar Movimiento: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<InventarioMovimiento> listarMovimientos() {
        List<InventarioMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM InventarioMovimiento";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                InventarioMovimiento m = new InventarioMovimiento();
                m.setIdMovimiento(rs.getLong("idMovimiento"));
                m.setTipoMovimiento(rs.getString("tipoMovimiento"));
                m.setCantidadDelMovimiento(rs.getDouble("cantidadDelMovimiento"));
                m.setDetallesDelMaterialEnMovimiento(rs.getString("detallesDelMaterialEnMovimiento"));
                m.setMaterialIdMaterial(rs.getLong("Material_idMaterial"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Movimientos: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarMovimiento(InventarioMovimiento movimiento) {
        String sql = "UPDATE InventarioMovimiento SET tipoMovimiento=?, cantidadDelMovimiento=?, detallesDelMaterialEnMovimiento=?, Material_idMaterial=? WHERE idMovimiento=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movimiento.getTipoMovimiento());
            ps.setDouble(2, movimiento.getCantidadDelMovimiento());
            ps.setString(3, movimiento.getDetallesDelMaterialEnMovimiento());
            ps.setLong(4, movimiento.getMaterialIdMaterial());
            ps.setLong(5, movimiento.getIdMovimiento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Movimiento: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarMovimiento(long idMovimiento) {
        String sql = "DELETE FROM InventarioMovimiento WHERE idMovimiento=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idMovimiento);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Movimiento: " + e.getMessage());
            return false;
        }
    }
}