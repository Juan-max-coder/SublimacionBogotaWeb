/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // CREATE
    public boolean insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombreCliente, apellidoCliente, direccionCliente, telefonoCliente, correoCliente, tipoCliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombreCliente());
            ps.setString(2, cliente.getApellidoCliente());
            ps.setString(3, cliente.getDireccionCliente());
            ps.setString(4, cliente.getTelefonoCliente());
            ps.setString(5, cliente.getCorreoCliente());
            ps.setString(6, cliente.getTipoCliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cli = new Cliente(
                    rs.getLong("idCliente"),
                    rs.getString("nombreCliente"),
                    rs.getString("apellidoCliente"),
                    rs.getString("direccionCliente"),
                    rs.getString("telefonoCliente"),
                    rs.getString("correoCliente"),
                    rs.getString("tipoCliente")
                );
                lista.add(cli);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombreCliente=?, apellidoCliente=?, direccionCliente=?, telefonoCliente=?, correoCliente=?, tipoCliente=? WHERE idCliente=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombreCliente());
            ps.setString(2, cliente.getApellidoCliente());
            ps.setString(3, cliente.getDireccionCliente());
            ps.setString(4, cliente.getTelefonoCliente());
            ps.setString(5, cliente.getCorreoCliente());
            ps.setString(6, cliente.getTipoCliente());
            ps.setLong(7, cliente.getIdCliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarCliente(long idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idCliente);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}
