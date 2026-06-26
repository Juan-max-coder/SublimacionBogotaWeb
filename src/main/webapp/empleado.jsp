<%-- 
    Document   : empleado
    Created on : 26/06/2026, 12:19:26 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Empleados</title>
</head>
<body>
<h2>Lista de Empleados</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Área</th>
        <th>Contacto</th>
        <th>Usuario ID</th>
    </tr>
    <c:forEach var="e" items="${empleados}">
        <tr>
            <td>${e.idEmpleado}</td>
            <td>${e.nombreEmpleado}</td>
            <td>${e.cargoEmpleado}</td>
            <td>${e.areaEmpleado}</td>
            <td>${e.contactoEmpleado}</td>
            <td>${e.usuarioIdUsuario}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo empleado</h2>
<form action="EmpleadoServlet" method="post">
    Nombre: <input type="text" name="nombreEmpleado"><br>
    Cargo: <input type="text" name="cargoEmpleado"><br>
    Área: <input type="text" name="areaEmpleado"><br>
    Contacto: <input type="text" name="contactoEmpleado"><br>
    Usuario ID: <input type="text" name="usuarioIdUsuario"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>