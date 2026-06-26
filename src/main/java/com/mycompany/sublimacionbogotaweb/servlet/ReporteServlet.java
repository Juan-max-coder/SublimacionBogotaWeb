/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.ReporteDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Reporte;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {

    private ReporteDAO dao = new ReporteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reporte> reportes = dao.listarReportes();
        request.setAttribute("reportes", reportes);
        request.getRequestDispatcher("reporte.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tipo = request.getParameter("tipoReporte");
            String fechaStr = request.getParameter("fechaReporte");
            long usuarioId = Long.parseLong(request.getParameter("usuarioIdUsuario"));

            // Convertir fecha desde el formulario (yyyy-MM-dd)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(fechaStr);

            Reporte reporte = new Reporte(0, tipo, fecha, usuarioId);

            dao.insertarReporte(reporte);

            response.sendRedirect("ReporteServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ReporteServlet");
        }
    }
}