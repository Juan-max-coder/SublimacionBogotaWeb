/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.InventarioMovimientoDAO;
import com.mycompany.sublimacionbogotaweb.modelo.InventarioMovimiento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/InventarioMovimientoServlet")
public class InventarioMovimientoServlet extends HttpServlet {

    private InventarioMovimientoDAO dao = new InventarioMovimientoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<InventarioMovimiento> movimientos = dao.listarMovimientos();
        request.setAttribute("movimientos", movimientos);
        request.getRequestDispatcher("inventarioMovimiento.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipoMovimiento");
        double cantidad = Double.parseDouble(request.getParameter("cantidadDelMovimiento"));
        String detalles = request.getParameter("detallesDelMaterialEnMovimiento");
        long materialId = Long.parseLong(request.getParameter("materialIdMaterial"));

        InventarioMovimiento movimiento = new InventarioMovimiento(0, tipo, cantidad, detalles, materialId);

        dao.insertarMovimiento(movimiento);

        response.sendRedirect("InventarioMovimientoServlet");
    }
}