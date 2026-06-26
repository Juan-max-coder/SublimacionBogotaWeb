<%-- 
    Document   : detallePedido
    Created on : 26/06/2026, 12:10:30 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalle Pedido</title>
</head>
<body>
<h2>Lista de Detalles de Pedido</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Cantidad</th>
        <th>Precio Unitario</th>
        <th>Costo Mano de Obra</th>
        <th>Subtotal</th>
        <th>Pedido</th>
        <th>Material</th>
        <th>Insumo</th>
    </tr>
    <c:forEach var="d" items="${detalles}">
        <tr>
            <td>${d.idDetalle}</td>
            <td>${d.cantidadMaterial}</td>
            <td>${d.precioUnitarioMaterial}</td>
            <td>${d.costoManoDeObra}</td>
            <td>${d.subtotalPedido}</td>
            <td>${d.pedidoIdPedido}</td>
            <td>${d.materialIdMaterial}</td>
            <td>${d.insumosIdInsumo}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo detalle</h2>
<form action="DetallePedidoServlet" method="post">
    Cantidad: <input type="text" name="cantidadMaterial"><br>
    Precio Unitario: <input type="text" name="precioUnitarioMaterial"><br>
    Costo Mano de Obra: <input type="text" name="costoManoDeObra"><br>
    Subtotal: <input type="text" name="subtotalPedido"><br>
    Pedido ID: <input type="text" name="pedidoIdPedido"><br>
    Material ID: <input type="text" name="materialIdMaterial"><br>
    Insumo ID: <input type="text" name="insumosIdInsumo"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>
