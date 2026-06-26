<%-- 
    Document   : produccion
    Created on : 26/06/2026, 10:50:44 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Producción</title>
</head>
<body>
<h2>Lista de Producciones</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Fecha Inicio</th>
        <th>Fecha Fin</th>
        <th>Estado</th>
        <th>ID Pedido</th>
    </tr>
    <c:forEach var="p" items="${producciones}">
        <tr>
            <td>${p.idProduccion}</td>
            <td>${p.fechaInicioProduccion}</td>
            <td>${p.fechaFinProduccion}</td>
            <td>${p.estadoProduccion}</td>
            <td>${p.pedidoIdPedido}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nueva producción</h2>
<form action="ProduccionServlet" method="post">
    Fecha Inicio: <input type="date" name="fechaInicioProduccion"><br>
    Fecha Fin: <input type="date" name="fechaFinProduccion"><br>
    Estado: <input type="text" name="estadoProduccion"><br>
    ID Pedido: <input type="text" name="pedidoIdPedido"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>