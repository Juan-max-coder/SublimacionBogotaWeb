/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // CREATE
    public boolean insertarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Empleado (nombreEmpleado, cargoEmpleado, areaEmpleado, contactoEmpleado, Usuario_idUsuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombreEmpleado());
            ps.setString(2, empleado.getCargoEmpleado());
            ps.setString(3, empleado.getAreaEmpleado());
            ps.setString(4, empleado.getContactoEmpleado());
            ps.setLong(5, empleado.getUsuarioIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<Empleado> listarEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado emp = new Empleado(
                    rs.getLong("idEmpleado"),
                    rs.getString("nombreEmpleado"),
                    rs.getString("cargoEmpleado"),
                    rs.getString("areaEmpleado"),
                    rs.getString("contactoEmpleado"),
                    rs.getLong("Usuario_idUsuario")
                );
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE Empleado SET nombreEmpleado=?, cargoEmpleado=?, areaEmpleado=?, contactoEmpleado=?, Usuario_idUsuario=? WHERE idEmpleado=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombreEmpleado());
            ps.setString(2, empleado.getCargoEmpleado());
            ps.setString(3, empleado.getAreaEmpleado());
            ps.setString(4, empleado.getContactoEmpleado());
            ps.setLong(5, empleado.getUsuarioIdUsuario());
            ps.setLong(6, empleado.getIdEmpleado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarEmpleado(long idEmpleado) {
        String sql = "DELETE FROM Empleado WHERE idEmpleado=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idEmpleado);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }
}