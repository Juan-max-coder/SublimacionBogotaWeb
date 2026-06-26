/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.ProduccionDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Produccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ProduccionServlet")
public class ProduccionServlet extends HttpServlet {

    private ProduccionDAO dao = new ProduccionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produccion> producciones = dao.listarProducciones();
        request.setAttribute("producciones", producciones);
        request.getRequestDispatcher("produccion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String fechaInicioStr = request.getParameter("fechaInicioProduccion");
            String fechaFinStr = request.getParameter("fechaFinProduccion");
            String estado = request.getParameter("estadoProduccion");
            long pedidoId = Long.parseLong(request.getParameter("pedidoIdPedido"));

            // Convertir fechas desde el formulario (yyyy-MM-dd)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = sdf.parse(fechaInicioStr);
            Date fechaFin = sdf.parse(fechaFinStr);

            Produccion produccion = new Produccion(0, fechaInicio, fechaFin, estado, pedidoId);

            dao.insertarProduccion(produccion);

            response.sendRedirect("ProduccionServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ProduccionServlet");
        }
    }
}
