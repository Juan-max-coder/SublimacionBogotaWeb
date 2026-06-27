/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public boolean insertarUsuario(Usuario u) {
        String sql = "INSERT INTO Usuario (nombreUsuario, apellidoUsuario, correoUsuario, contrasenaUsuario, rolUsuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getApellidoUsuario());
            ps.setString(3, u.getCorreoUsuario());
            ps.setString(4, u.getContrasenaUsuario());
            ps.setString(5, u.getRolUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    // READ por correo
    public Usuario consultarUsuarioPorCorreo(String correo) {
        String sql = "SELECT * FROM Usuario WHERE correoUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getLong("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("apellidoUsuario"),
                    rs.getString("correoUsuario"),
                    rs.getString("contrasenaUsuario"),
                    rs.getString("rolUsuario")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }
        return null;
    }

    // READ listar todos
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getLong("idUsuario"),
                    rs.getString("nombreUsuario"),
                    rs.getString("apellidoUsuario"),
                    rs.getString("correoUsuario"),
                    rs.getString("contrasenaUsuario"),
                    rs.getString("rolUsuario")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarUsuario(Usuario u) {
        String sql = "UPDATE Usuario SET nombreUsuario=?, apellidoUsuario=?, correoUsuario=?, contrasenaUsuario=?, rolUsuario=? WHERE idUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getApellidoUsuario());
            ps.setString(3, u.getCorreoUsuario());
            ps.setString(4, u.getContrasenaUsuario());
            ps.setString(5, u.getRolUsuario());
            ps.setLong(6, u.getIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarUsuario(long id) {
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}