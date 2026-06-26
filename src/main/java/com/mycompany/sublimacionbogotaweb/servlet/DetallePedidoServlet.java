/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.DetallePedidoDAO;
import com.mycompany.sublimacionbogotaweb.modelo.DetallePedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DetallePedidoServlet")
public class DetallePedidoServlet extends HttpServlet {

    private DetallePedidoDAO dao = new DetallePedidoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DetallePedido> detalles = dao.listarDetalles();
        request.setAttribute("detalles", detalles);
        request.getRequestDispatcher("detallePedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibir datos del formulario JSP
        double cantidadMaterial = Double.parseDouble(request.getParameter("cantidadMaterial"));
        double precioUnitario = Double.parseDouble(request.getParameter("precioUnitarioMaterial"));
        double costoManoObra = Double.parseDouble(request.getParameter("costoManoDeObra"));
        double subtotal = Double.parseDouble(request.getParameter("subtotalPedido"));
        long pedidoId = Long.parseLong(request.getParameter("pedidoIdPedido"));
        long materialId = Long.parseLong(request.getParameter("materialIdMaterial"));
        long insumoId = Long.parseLong(request.getParameter("insumosIdInsumo"));

        DetallePedido detalle = new DetallePedido(0, cantidadMaterial, precioUnitario,
                costoManoObra, subtotal, pedidoId, materialId, insumoId);

        dao.insertarDetalle(detalle);

        // Redirigir al listado
        response.sendRedirect("DetallePedidoServlet");
    }
}
