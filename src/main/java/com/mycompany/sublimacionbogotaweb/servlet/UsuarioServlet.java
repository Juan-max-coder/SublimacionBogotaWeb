/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.UsuarioDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Listar usuarios
        List<Usuario> usuarios = dao.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Capturar datos del formulario
            String nombre = request.getParameter("nombreUsuario");
            String apellido = request.getParameter("apellidoUsuario");
            String correo = request.getParameter("correoUsuario");
            String contrasena = request.getParameter("contrasenaUsuario");
            String rol = request.getParameter("rolUsuario");

            // Crear objeto Usuario
            Usuario u = new Usuario(0, nombre, apellido, correo, contrasena);
            u.setRolUsuario(rol);

            // Insertar en la BD
            dao.insertarUsuario(u);

            // Redirigir al listado
            response.sendRedirect("UsuarioServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("UsuarioServlet");
        }
    }
}
