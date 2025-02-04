<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.User" %>
<%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista Usuarios</title>
</head>
<body>
    <h1> Lista de Usuarios </h1>
    <table border="1">
        <tr> 
            <th> ID </th>
            <th> Nombre </th>
            <th> Mail </th>
            <th> Acciones </th>
        </tr>
        <% 
        List<User> listaUsuarios = (List<User>) request.getAttribute("listaUsuarios"); 
        if (listaUsuarios != null) {
            for (User usuario : listaUsuarios) {
        %>
        <tr> 
            <td><%= usuario.getId() %></td>
            <td><%= usuario.getName() %></td>
            <td><%= usuario.getEmail() %></td>
            <td> 
                <a href="EditUserController?action=edit&id=<%= usuario.getId() %>">Editar</a>
                <a href="UserController?action=delete&id=<%= usuario.getId() %>">Eliminar</a>
            </td>
        </tr>
        <% 
            }
        } 
        %>
    </table>
    <a href="UserController?action=add">Agregar Usuario</a>
</body>
</html>
