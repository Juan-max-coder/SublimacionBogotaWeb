/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.modelo.Factura;
import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    // CREATE
    public boolean insertarFactura(Factura factura) {
        String sql = "INSERT INTO Factura (estadoFactura, fechaExportacionFactura, fechaConfirmacionFactura, Pedido_idPedido) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, factura.getEstadoFactura());
            ps.setTimestamp(2, new Timestamp(factura.getFechaExportacionFactura().getTime()));
            ps.setTimestamp(3, new Timestamp(factura.getFechaConfirmacionFactura().getTime()));
            ps.setLong(4, factura.getPedidoIdPedido());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar Factura: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Factura> listarFacturas() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM Factura";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Factura f = new Factura();
                f.setIdFactura(rs.getLong("idFactura"));
                f.setEstadoFactura(rs.getString("estadoFactura"));
                f.setFechaExportacionFactura(rs.getTimestamp("fechaExportacionFactura"));
                f.setFechaConfirmacionFactura(rs.getTimestamp("fechaConfirmacionFactura"));
                f.setPedidoIdPedido(rs.getLong("Pedido_idPedido"));
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Facturas: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarFactura(Factura factura) {
        String sql = "UPDATE Factura SET estadoFactura=?, fechaExportacionFactura=?, fechaConfirmacionFactura=?, Pedido_idPedido=? WHERE idFactura=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, factura.getEstadoFactura());
            ps.setTimestamp(2, new Timestamp(factura.getFechaExportacionFactura().getTime()));
            ps.setTimestamp(3, new Timestamp(factura.getFechaConfirmacionFactura().getTime()));
            ps.setLong(4, factura.getPedidoIdPedido());
            ps.setLong(5, factura.getIdFactura());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar Factura: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarFactura(long idFactura) {
        String sql = "DELETE FROM Factura WHERE idFactura=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idFactura);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar Factura: " + e.getMessage());
            return false;
        }
    }
}
