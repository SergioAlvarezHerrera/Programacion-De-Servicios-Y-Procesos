<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Tarea</title>
</head>
<body>
    <h2>Agregar Tarea</h2>
    <form action="AddTaskServlets" method="post">
        Descripción: <input type="text" name="description">
        <input type="submit" value="Agregar">
    </form>
    <a href="ShowTasksServlet">Ver todas las tareas</a>
</body>
</html>