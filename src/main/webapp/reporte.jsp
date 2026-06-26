<%-- 
    Document   : reporte
    Created on : 26/06/2026, 11:11:02 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reportes</title>
</head>
<body>
<h2>Lista de Reportes</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tipo</th>
        <th>Fecha</th>
        <th>ID Usuario</th>
    </tr>
    <c:forEach var="r" items="${reportes}">
        <tr>
            <td>${r.idReporte}</td>
            <td>${r.tipoReporte}</td>
            <td>${r.fechaReporte}</td>
            <td>${r.usuarioIdUsuario}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo reporte</h2>
<form action="ReporteServlet" method="post">
    Tipo: <input type="text" name="tipoReporte"><br>
    Fecha: <input type="date" name="fechaReporte"><br>
    ID Usuario: <input type="text" name="usuarioIdUsuario"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>