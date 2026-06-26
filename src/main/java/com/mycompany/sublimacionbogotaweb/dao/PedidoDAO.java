/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    // CREATE
    public boolean insertarPedido(Pedido pedido) {
        String sql = "INSERT INTO Pedido (fechaRegistroPedido, estadoPedido, prioridadPedido, fechaEntregaEstimadaPedido, Material_idMaterial, Cliente_idCliente, Empleado_idEmpleado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(pedido.getFechaRegistroPedido().getTime()));
            ps.setString(2, pedido.getEstadoPedido());
            ps.setString(3, pedido.getPrioridadPedido());
            ps.setTimestamp(4, new Timestamp(pedido.getFechaEntregaEstimadaPedido().getTime()));
            ps.setLong(5, pedido.getMaterialIdMaterial());
            ps.setLong(6, pedido.getClienteIdCliente());
            ps.setLong(7, pedido.getEmpleadoIdEmpleado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar pedido: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Pedido> listarPedidos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pedido ped = new Pedido(
                    rs.getLong("idPedido"),
                    rs.getTimestamp("fechaRegistroPedido"),
                    rs.getString("estadoPedido"),
                    rs.getString("prioridadPedido"),
                    rs.getTimestamp("fechaEntregaEstimadaPedido"),
                    rs.getLong("Material_idMaterial"),
                    rs.getLong("Cliente_idCliente"),
                    rs.getLong("Empleado_idEmpleado")
                );
                lista.add(ped);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarPedido(Pedido pedido) {
        String sql = "UPDATE Pedido SET fechaRegistroPedido=?, estadoPedido=?, prioridadPedido=?, fechaEntregaEstimadaPedido=?, Material_idMaterial=?, Cliente_idCliente=?, Empleado_idEmpleado=? WHERE idPedido=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(pedido.getFechaRegistroPedido().getTime()));
            ps.setString(2, pedido.getEstadoPedido());
            ps.setString(3, pedido.getPrioridadPedido());
            ps.setTimestamp(4, new Timestamp(pedido.getFechaEntregaEstimadaPedido().getTime()));
            ps.setLong(5, pedido.getMaterialIdMaterial());
            ps.setLong(6, pedido.getClienteIdCliente());
            ps.setLong(7, pedido.getEmpleadoIdEmpleado());
            ps.setLong(8, pedido.getIdPedido());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar pedido: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarPedido(long idPedido) {
        String sql = "DELETE FROM Pedido WHERE idPedido=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
            return false;
        }
    }
}