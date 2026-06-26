<%-- 
    Document   : cliente
    Created on : 25/06/2026, 11:38:48 p. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Lista de Clientes</title></head>
<body>
    <h2>Clientes registrados</h2>
    <table border="1">
        <tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Correo</th></tr>
        <c:forEach var="c" items="${clientes}">
            <tr>
                <td>${c.idCliente}</td>
                <td>${c.nombreCliente}</td>
                <td>${c.apellidoCliente}</td>
                <td>${c.correoCliente}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
