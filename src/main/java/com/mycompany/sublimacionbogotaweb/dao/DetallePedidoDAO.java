/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.modelo.DetallePedido;
import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO {

    // CREATE
    public boolean insertarDetalle(DetallePedido detalle) {
        String sql = "INSERT INTO DetallePedido (cantidadMaterial, precioUnitarioMaterial, costoManoDeObra, subtotalPedido, Pedido_idPedido, Material_idMaterial, Insumos_idInsumo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, detalle.getCantidadMaterial());
            ps.setDouble(2, detalle.getPrecioUnitarioMaterial());
            ps.setDouble(3, detalle.getCostoManoDeObra());
            ps.setDouble(4, detalle.getSubtotalPedido());
            ps.setLong(5, detalle.getPedidoIdPedido());
            ps.setLong(6, detalle.getMaterialIdMaterial());
            ps.setLong(7, detalle.getInsumosIdInsumo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar DetallePedido: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<DetallePedido> listarDetalles() {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetallePedido";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                DetallePedido d = new DetallePedido();
                d.setIdDetalle(rs.getLong("idDetalle"));
                d.setCantidadMaterial(rs.getDouble("cantidadMaterial"));
                d.setPrecioUnitarioMaterial(rs.getDouble("precioUnitarioMaterial"));
                d.setCostoManoDeObra(rs.getDouble("costoManoDeObra"));
                d.setSubtotalPedido(rs.getDouble("subtotalPedido"));
                d.setPedidoIdPedido(rs.getLong("Pedido_idPedido"));
                d.setMaterialIdMaterial(rs.getLong("Material_idMaterial"));
                d.setInsumosIdInsumo(rs.getLong("Insumos_idInsumo"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar DetallePedido: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarDetalle(DetallePedido detalle) {
        String sql = "UPDATE DetallePedido SET cantidadMaterial=?, precioUnitarioMaterial=?, costoManoDeObra=?, subtotalPedido=?, Pedido_idPedido=?, Material_idMaterial=?, Insumos_idInsumo=? WHERE idDetalle=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, detalle.getCantidadMaterial());
            ps.setDouble(2, detalle.getPrecioUnitarioMaterial());
            ps.setDouble(3, detalle.getCostoManoDeObra());
            ps.setDouble(4, detalle.getSubtotalPedido());
            ps.setLong(5, detalle.getPedidoIdPedido());
            ps.setLong(6, detalle.getMaterialIdMaterial());
            ps.setLong(7, detalle.getInsumosIdInsumo());
            ps.setLong(8, detalle.getIdDetalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar DetallePedido: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarDetalle(long idDetalle) {
        String sql = "DELETE FROM DetallePedido WHERE idDetalle=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idDetalle);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar DetallePedido: " + e.getMessage());
            return false;
        }
    }
}