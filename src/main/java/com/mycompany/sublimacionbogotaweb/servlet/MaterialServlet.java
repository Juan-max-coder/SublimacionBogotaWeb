/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.MaterialDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Material;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/MaterialServlet")
public class MaterialServlet extends HttpServlet {

    private MaterialDAO dao = new MaterialDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener lista de materiales desde el DAO
        List<Material> materiales = dao.listarMateriales();
        // Pasar la lista al JSP
        request.setAttribute("materiales", materiales);
        request.getRequestDispatcher("material.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Recibir datos del formulario
            String nombre = request.getParameter("nombreMaterial");
            String tipo = request.getParameter("tipoMaterial");
            String color = request.getParameter("colorMaterial");
            double cantidad = Double.parseDouble(request.getParameter("cantidadDisponibleMaterial"));
            long clienteId = Long.parseLong(request.getParameter("clienteIdCliente"));

            // Crear objeto Material
            Material material = new Material(0, nombre, tipo, color, cantidad, clienteId);

            // Insertar en la BD
            dao.insertarMaterial(material);

            // Redirigir al listado
            response.sendRedirect("MaterialServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("MaterialServlet");
        }
    }
}