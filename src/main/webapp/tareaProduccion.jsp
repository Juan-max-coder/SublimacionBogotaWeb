<%-- 
    Document   : tareaProduccion
    Created on : 26/06/2026, 11:18:37 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tareas de Producción</title>
</head>
<body>
<h2>Lista de Tareas de Producción</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Descripción</th>
        <th>Estado</th>
        <th>Avance</th>
        <th>ID Empleado</th>
        <th>ID Producción</th>
    </tr>
    <c:forEach var="t" items="${tareas}">
        <tr>
            <td>${t.idTarea}</td>
            <td>${t.descripcionTarea}</td>
            <td>${t.estadoTarea}</td>
            <td>${t.avanceTarea}</td>
            <td>${t.empleadoIdEmpleado}</td>
            <td>${t.produccionIdProduccion}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nueva tarea</h2>
<form action="TareaProduccionServlet" method="post">
    Descripción: <input type="text" name="descripcionTarea"><br>
    Estado: <input type="text" name="estadoTarea"><br>
    Avance (%): <input type="text" name="avanceTarea"><br>
    ID Empleado: <input type="text" name="empleadoIdEmpleado"><br>
    ID Producción: <input type="text" name="produccionIdProduccion"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>