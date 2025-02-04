<%@page import="modelo.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Libros</title>
</head>
<body>
    <h1>Listado de Libros</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Acciones</th>
        </tr>
        <%
            List <modelo.Libro> libros  = (List<Libro>) request.getAttribute("listalibros");
            for (modelo.Libro libro1 : libros) {
        %>
        <tr>
            <td><%= libro1.getId_libro() %></td>
            <td><%= libro1.getTitulo() %></td>
            <td><%= libro1.getAutor() %></td>
            <td>
                <a href="ServletLibro?action=delete&id=<%= libro1.getId_libro() %>">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
