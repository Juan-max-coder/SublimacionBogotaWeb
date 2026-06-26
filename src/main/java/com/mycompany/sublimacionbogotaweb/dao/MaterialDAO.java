/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    // CREATE
    public boolean insertarMaterial(Material material) {
        String sql = "INSERT INTO Material (nombreMaterial, tipoMaterial, colorMaterial, cantidadDisponibleMaterial, Cliente_idCliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, material.getNombreMaterial());
            ps.setString(2, material.getTipoMaterial());
            ps.setString(3, material.getColorMaterial());
            ps.setDouble(4, material.getCantidadDisponibleMaterial());
            ps.setLong(5, material.getClienteIdCliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar material: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Material> listarMateriales() {
        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM Material";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Material mat = new Material(
                    rs.getLong("idMaterial"),
                    rs.getString("nombreMaterial"),
                    rs.getString("tipoMaterial"),
                    rs.getString("colorMaterial"),
                    rs.getDouble("cantidadDisponibleMaterial"),
                    rs.getLong("Cliente_idCliente")
                );
                lista.add(mat);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar materiales: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarMaterial(Material material) {
        String sql = "UPDATE Material SET nombreMaterial=?, tipoMaterial=?, colorMaterial=?, cantidadDisponibleMaterial=?, Cliente_idCliente=? WHERE idMaterial=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, material.getNombreMaterial());
            ps.setString(2, material.getTipoMaterial());
            ps.setString(3, material.getColorMaterial());
            ps.setDouble(4, material.getCantidadDisponibleMaterial());
            ps.setLong(5, material.getClienteIdCliente());
            ps.setLong(6, material.getIdMaterial());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar material: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarMaterial(long idMaterial) {
        String sql = "DELETE FROM Material WHERE idMaterial=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idMaterial);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar material: " + e.getMessage());
            return false;
        }
    }
}