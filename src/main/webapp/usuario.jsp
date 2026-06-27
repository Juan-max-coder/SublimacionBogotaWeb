<%-- 
    Document   : usuario
    Created on : 26/06/2026, 11:42:24 a. m.
    Author     : Usuario
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuarios</title>
</head>
<body>
<h2>Lista de Usuarios</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Correo</th>
        <th>Contraseña</th>
        <th>Rol</th>
    </tr>
    <c:forEach var="u" items="${usuarios}">
        <tr>
            <td>${u.idUsuario}</td>
            <td>${u.nombreUsuario}</td>
            <td>${u.apellidoUsuario}</td>
            <td>${u.correoUsuario}</td>
            <td>${u.contrasenaUsuario}</td>
            <td>${u.rolUsuario}</td>
        </tr>
    </c:forEach>
</table>

<h2>Agregar nuevo usuario</h2>
<form action="UsuarioServlet" method="post">
    Nombre: <input type="text" name="nombreUsuario"><br>
    Apellido: <input type="text" name="apellidoUsuario"><br>
    Correo: <input type="email" name="correoUsuario"><br>
    Contraseña: <input type="password" name="contrasenaUsuario"><br>
    Rol: <input type="text" name="rolUsuario" value="Usuario"><br>
    <input type="submit" value="Guardar">
</form>

</body>
</html>