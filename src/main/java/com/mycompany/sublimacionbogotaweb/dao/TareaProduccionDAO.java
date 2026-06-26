/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.dao;

import com.mycompany.sublimacionbogotaweb.conexion.Conexion;
import com.mycompany.sublimacionbogotaweb.modelo.TareaProduccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaProduccionDAO {

    // CREATE
    public boolean insertarTarea(TareaProduccion tarea) {
        String sql = "INSERT INTO TareaProduccion (descripcionTarea, estadoTarea, avanceTarea, Empleado_idEmpleado, Produccion_idProduccion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tarea.getDescripcionTarea());
            ps.setString(2, tarea.getEstadoTarea());
            ps.setDouble(3, tarea.getAvanceTarea());
            ps.setLong(4, tarea.getEmpleadoIdEmpleado());
            ps.setLong(5, tarea.getProduccionIdProduccion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar TareaProducción: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<TareaProduccion> listarTareas() {
        List<TareaProduccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM TareaProduccion";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                TareaProduccion t = new TareaProduccion();
                t.setIdTarea(rs.getLong("idTarea"));
                t.setDescripcionTarea(rs.getString("descripcionTarea"));
                t.setEstadoTarea(rs.getString("estadoTarea"));
                t.setAvanceTarea(rs.getDouble("avanceTarea"));
                t.setEmpleadoIdEmpleado(rs.getLong("Empleado_idEmpleado"));
                t.setProduccionIdProduccion(rs.getLong("Produccion_idProduccion"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Tareas: " + e.getMessage());
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarTarea(TareaProduccion tarea) {
        String sql = "UPDATE TareaProduccion SET descripcionTarea=?, estadoTarea=?, avanceTarea=?, Empleado_idEmpleado=?, Produccion_idProduccion=? WHERE idTarea=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tarea.getDescripcionTarea());
            ps.setString(2, tarea.getEstadoTarea());
            ps.setDouble(3, tarea.getAvanceTarea());
            ps.setLong(4, tarea.getEmpleadoIdEmpleado());
            ps.setLong(5, tarea.getProduccionIdProduccion());
            ps.setLong(6, tarea.getIdTarea());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar TareaProducción: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminarTarea(long idTarea) {
        String sql = "DELETE FROM TareaProduccion WHERE idTarea=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idTarea);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar TareaProducción: " + e.getMessage());
            return false;
        }
    }
}