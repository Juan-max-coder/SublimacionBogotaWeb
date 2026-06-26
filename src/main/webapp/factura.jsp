<%-- 
    Document   : factura
    Created on : 26/06/2026, 12:42:48 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Facturas</title>
</head>
<body>
<h2>Lista de Facturas</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Estado</th>
        <th>Fecha Exportación</th>
        <th>Fecha Confirmación</th>
        <th>Pedido ID</th>
    </tr>
    <c:forEach var="f" items="${facturas}">
        <tr>
            <td>${f.idFactura}</td>
            <td>${f.estadoFactura}</td>
            <td>${f.fechaExportacionFactura}</td>
            <td>${f.fechaConfirmacionFactura}</td>
            <td>${f.pedidoIdPedido}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nueva factura</h2>
<form action="FacturaServlet" method="post">
    Estado: <input type="text" name="estadoFactura"><br>
    Fecha Exportación: <input type="date" name="fechaExportacionFactura"><br>
    Fecha Confirmación: <input type="date" name="fechaConfirmacionFactura"><br>
    Pedido ID: <input type="text" name="pedidoIdPedido"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>
