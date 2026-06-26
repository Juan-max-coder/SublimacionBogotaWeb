/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Produccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDAO {

    // CREATE
    public boolean insertarProduccion(Produccion produccion) {
        String sql = "INSERT INTO Produccion (fechaInicioProduccion, fechaFinProduccion, estadoProduccion, Pedido_idPedido) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(produccion.getFechaInicioProduccion().getTime()));
            ps.setTimestamp(2, new Timestamp(produccion.getFechaFinProduccion().getTime()));
            ps.setString(3, produccion.getEstadoProduccion());
            ps.setLong(4, produccion.getPedidoIdPedido());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar Producción: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Produccion> listarProducciones() {
        List<Produccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Produccion";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Produccion p = new Produccion();
                p.setIdProduccion(rs.getLong("idProduccion"));
                p.setFechaInicioProduccion(rs.getTimestamp("fechaInicioProduccion"));
                p.setFechaFinProduccion(rs.getTimestamp("fechaFinProduccion"));
                p.setEstadoProduccion(rs.getString("estadoProduccion"));
                p.setPedidoIdPedido(rs.getLong("Pedido_idPedido"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Producciones: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarProduccion(Produccion produccion) {
        String sql = "UPDATE Produccion SET fechaInicioProduccion=?, fechaFinProduccion=?, estadoProduccion=?, Pedido_idPedido=? WHERE idProduccion=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(produccion.getFechaInicioProduccion().getTime()));
            ps.setTimestamp(2, new Timestamp(produccion.getFechaFinProduccion().getTime()));
            ps.setString(3, produccion.getEstadoProduccion());
            ps.setLong(4, produccion.getPedidoIdPedido());
            ps.setLong(5, produccion.getIdProduccion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Producción: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarProduccion(long idProduccion) {
        String sql = "DELETE FROM Produccion WHERE idProduccion=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idProduccion);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Producción: " + e.getMessage());
            return false;
        }
    }
}