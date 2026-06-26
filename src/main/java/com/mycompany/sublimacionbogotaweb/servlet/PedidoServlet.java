/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.PedidoDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {

    private PedidoDAO dao = new PedidoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> pedidos = dao.listarPedidos();
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("pedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String estado = request.getParameter("estadoPedido");
            String prioridad = request.getParameter("prioridadPedido");
            String fechaRegistroStr = request.getParameter("fechaRegistroPedido");
            String fechaEntregaStr = request.getParameter("fechaEntregaEstimadaPedido");
            long materialId = Long.parseLong(request.getParameter("materialIdMaterial"));
            long clienteId = Long.parseLong(request.getParameter("clienteIdCliente"));
            long empleadoId = Long.parseLong(request.getParameter("empleadoIdEmpleado"));

            // Convertir fechas desde el formulario (yyyy-MM-dd)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaRegistro = sdf.parse(fechaRegistroStr);
            Date fechaEntrega = sdf.parse(fechaEntregaStr);

            Pedido pedido = new Pedido(0, fechaRegistro, estado, prioridad, fechaEntrega, materialId, clienteId, empleadoId);

            dao.insertarPedido(pedido);

            response.sendRedirect("PedidoServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("PedidoServlet");
        }
    }
}