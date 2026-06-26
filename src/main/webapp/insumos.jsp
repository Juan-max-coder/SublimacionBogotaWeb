<%-- 
    Document   : insumos
    Created on : 26/06/2026, 12:59:51 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insumos</title>
</head>
<body>
<h2>Lista de Insumos</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Costo</th>
        <th>Stock</th>
        <th>Precio</th>
        <th>ID Movimiento</th>
    </tr>
    <c:forEach var="i" items="${insumos}">
        <tr>
            <td>${i.idInsumo}</td>
            <td>${i.nombreInsumo}</td>
            <td>${i.costoInsumo}</td>
            <td>${i.stockInsumo}</td>
            <td>${i.precioInsumo}</td>
            <td>${i.inventarioMovimientoIdMovimiento}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo insumo</h2>
<form action="InsumosServlet" method="post">
    Nombre: <input type="text" name="nombreInsumo"><br>
    Costo: <input type="text" name="costoInsumo"><br>
    Stock: <input type="text" name="stockInsumo"><br>
    Precio: <input type="text" name="precioInsumo"><br>
    ID Movimiento: <input type="text" name="inventarioMovimientoIdMovimiento"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>