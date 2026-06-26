/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.FacturaDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Factura;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/FacturaServlet")
public class FacturaServlet extends HttpServlet {

    private FacturaDAO dao = new FacturaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Factura> facturas = dao.listarFacturas();
        request.setAttribute("facturas", facturas);
        request.getRequestDispatcher("factura.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String estado = request.getParameter("estadoFactura");
            String fechaExportacionStr = request.getParameter("fechaExportacionFactura");
            String fechaConfirmacionStr = request.getParameter("fechaConfirmacionFactura");
            long pedidoId = Long.parseLong(request.getParameter("pedidoIdPedido"));

            // Convertir fechas desde el formulario (yyyy-MM-dd)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaExportacion = sdf.parse(fechaExportacionStr);
            Date fechaConfirmacion = sdf.parse(fechaConfirmacionStr);

            Factura factura = new Factura(0, estado, fechaExportacion, fechaConfirmacion, pedidoId);

            dao.insertarFactura(factura);

            response.sendRedirect("FacturaServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("FacturaServlet");
        }
    }
}
