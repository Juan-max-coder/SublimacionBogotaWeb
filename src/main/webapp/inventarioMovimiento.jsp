<%-- 
    Document   : inventarioMovimiento
    Created on : 26/06/2026, 10:17:51 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inventario Movimientos</title>
</head>
<body>
<h2>Lista de Movimientos de Inventario</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Tipo</th>
        <th>Cantidad</th>
        <th>Detalles</th>
        <th>ID Material</th>
    </tr>
    <c:forEach var="m" items="${movimientos}">
        <tr>
            <td>${m.idMovimiento}</td>
            <td>${m.tipoMovimiento}</td>
            <td>${m.cantidadDelMovimiento}</td>
            <td>${m.detallesDelMaterialEnMovimiento}</td>
            <td>${m.materialIdMaterial}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo movimiento</h2>
<form action="InventarioMovimientoServlet" method="post">
    Tipo: <input type="text" name="tipoMovimiento"><br>
    Cantidad: <input type="text" name="cantidadDelMovimiento"><br>
    Detalles: <input type="text" name="detallesDelMaterialEnMovimiento"><br>
    ID Material: <input type="text" name="materialIdMaterial"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>