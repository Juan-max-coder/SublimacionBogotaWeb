/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.modelo.Insumos;
import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsumosDAO {

    // CREATE
    public boolean insertarInsumo(Insumos insumo) {
        String sql = "INSERT INTO Insumos (nombreInsumo, costoInsumo, stockInsumo, precioInsumo, InventarioMovimiento_idMovimiento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, insumo.getNombreInsumo());
            ps.setDouble(2, insumo.getCostoInsumo());
            ps.setInt(3, insumo.getStockInsumo());
            ps.setDouble(4, insumo.getPrecioInsumo());
            ps.setLong(5, insumo.getInventarioMovimientoIdMovimiento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar Insumo: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Insumos> listarInsumos() {
        List<Insumos> lista = new ArrayList<>();
        String sql = "SELECT * FROM Insumos";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Insumos i = new Insumos();
                i.setIdInsumo(rs.getLong("idInsumo"));
                i.setNombreInsumo(rs.getString("nombreInsumo"));
                i.setCostoInsumo(rs.getDouble("costoInsumo"));
                i.setStockInsumo(rs.getInt("stockInsumo"));
                i.setPrecioInsumo(rs.getDouble("precioInsumo"));
                i.setInventarioMovimientoIdMovimiento(rs.getLong("InventarioMovimiento_idMovimiento"));
                lista.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Insumos: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarInsumo(Insumos insumo) {
        String sql = "UPDATE Insumos SET nombreInsumo=?, costoInsumo=?, stockInsumo=?, precioInsumo=?, InventarioMovimiento_idMovimiento=? WHERE idInsumo=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, insumo.getNombreInsumo());
            ps.setDouble(2, insumo.getCostoInsumo());
            ps.setInt(3, insumo.getStockInsumo());
            ps.setDouble(4, insumo.getPrecioInsumo());
            ps.setLong(5, insumo.getInventarioMovimientoIdMovimiento());
            ps.setLong(6, insumo.getIdInsumo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Insumo: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarInsumo(long idInsumo) {
        String sql = "DELETE FROM Insumos WHERE idInsumo=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idInsumo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Insumo: " + e.getMessage());
            return false;
        }
    }
}
