/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.TareaProduccionDAO;
import com.mycompany.sublimacionbogotaweb.modelo.TareaProduccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/TareaProduccionServlet")
public class TareaProduccionServlet extends HttpServlet {

    private TareaProduccionDAO dao = new TareaProduccionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TareaProduccion> tareas = dao.listarTareas();
        request.setAttribute("tareas", tareas);
        request.getRequestDispatcher("tareaProduccion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String descripcion = request.getParameter("descripcionTarea");
            String estado = request.getParameter("estadoTarea");
            double avance = Double.parseDouble(request.getParameter("avanceTarea"));
            long empleadoId = Long.parseLong(request.getParameter("empleadoIdEmpleado"));
            long produccionId = Long.parseLong(request.getParameter("produccionIdProduccion"));

            TareaProduccion tarea = new TareaProduccion(0, descripcion, estado, avance, empleadoId, produccionId);

            dao.insertarTarea(tarea);

            response.sendRedirect("TareaProduccionServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("TareaProduccionServlet");
        }
    }
}