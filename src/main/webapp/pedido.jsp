<%-- 
    Document   : pedido
    Created on : 26/06/2026, 10:47:10 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pedidos</title>
</head>
<body>
<h2>Lista de Pedidos</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Fecha Registro</th>
        <th>Estado</th>
        <th>Prioridad</th>
        <th>Fecha Entrega Estimada</th>
        <th>ID Material</th>
        <th>ID Cliente</th>
        <th>ID Empleado</th>
    </tr>
    <c:forEach var="p" items="${pedidos}">
        <tr>
            <td>${p.idPedido}</td>
            <td>${p.fechaRegistroPedido}</td>
            <td>${p.estadoPedido}</td>
            <td>${p.prioridadPedido}</td>
            <td>${p.fechaEntregaEstimadaPedido}</td>
            <td>${p.materialIdMaterial}</td>
            <td>${p.clienteIdCliente}</td>
            <td>${p.empleadoIdEmpleado}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo pedido</h2>
<form action="PedidoServlet" method="post">
    Fecha Registro: <input type="date" name="fechaRegistroPedido"><br>
    Estado: <input type="text" name="estadoPedido"><br>
    Prioridad: <input type="text" name="prioridadPedido"><br>
    Fecha Entrega Estimada: <input type="date" name="fechaEntregaEstimadaPedido"><br>
    ID Material: <input type="text" name="materialIdMaterial"><br>
    ID Cliente: <input type="text" name="clienteIdCliente"><br>
    ID Empleado: <input type="text" name="empleadoIdEmpleado"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>