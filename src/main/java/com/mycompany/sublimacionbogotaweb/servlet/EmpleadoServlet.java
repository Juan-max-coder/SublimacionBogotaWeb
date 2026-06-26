/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sublimacionbogotaweb.servlet;

import com.mycompany.sublimacionbogotaweb.dao.EmpleadoDAO;
import com.mycompany.sublimacionbogotaweb.modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    private EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleados = dao.listarEmpleados();
        request.setAttribute("empleados", empleados);
        request.getRequestDispatcher("empleado.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibir datos del formulario JSP
        String nombre = request.getParameter("nombreEmpleado");
        String cargo = request.getParameter("cargoEmpleado");
        String area = request.getParameter("areaEmpleado");
        String contacto = request.getParameter("contactoEmpleado");
        long usuarioId = Long.parseLong(request.getParameter("usuarioIdUsuario"));

        Empleado emp = new Empleado(0, nombre, cargo, area, contacto, usuarioId);

        dao.insertarEmpleado(emp);

        // Redirigir al listado
        response.sendRedirect("EmpleadoServlet");
    }
}
