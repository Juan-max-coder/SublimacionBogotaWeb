/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.InsumosDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Insumos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/InsumosServlet")
public class InsumosServlet extends HttpServlet {

    private InsumosDAO dao = new InsumosDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Insumos> insumos = dao.listarInsumos();
        request.setAttribute("insumos", insumos);
        request.getRequestDispatcher("insumos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombreInsumo");
        double costo = Double.parseDouble(request.getParameter("costoInsumo"));
        int stock = Integer.parseInt(request.getParameter("stockInsumo"));
        double precio = Double.parseDouble(request.getParameter("precioInsumo"));
        long movimientoId = Long.parseLong(request.getParameter("inventarioMovimientoIdMovimiento"));

        Insumos insumo = new Insumos(0, nombre, costo, stock, precio, movimientoId);

        dao.insertarInsumo(insumo);

        response.sendRedirect("InsumosServlet");
    }
}