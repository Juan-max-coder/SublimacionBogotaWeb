<%-- 
    Document   : material
    Created on : 26/06/2026, 10:28:29 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Materiales</title>
</head>
<body>
<h2>Lista de Materiales</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Tipo</th>
        <th>Color</th>
        <th>Cantidad Disponible</th>
        <th>ID Cliente</th>
    </tr>
    <c:forEach var="m" items="${materiales}">
        <tr>
            <td>${m.idMaterial}</td>
            <td>${m.nombreMaterial}</td>
            <td>${m.tipoMaterial}</td>
            <td>${m.colorMaterial}</td>
            <td>${m.cantidadDisponibleMaterial}</td>
            <td>${m.clienteIdCliente}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo material</h2>
<form action="MaterialServlet" method="post">
    Nombre: <input type="text" name="nombreMaterial"><br>
    Tipo: <input type="text" name="tipoMaterial"><br>
    Color: <input type="text" name="colorMaterial"><br>
    Cantidad Disponible: <input type="text" name="cantidadDisponibleMaterial"><br>
    ID Cliente: <input type="text" name="clienteIdCliente"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>