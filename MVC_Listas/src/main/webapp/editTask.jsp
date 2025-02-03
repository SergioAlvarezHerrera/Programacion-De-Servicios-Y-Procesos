<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Tarea</title>
</head>
<body>
    <h2>Editar Tarea</h2>
    <form action="editTask" method="post">
        <input type="hidden" name="id" value="${task.id}">
        Descripción: <input type="text" name="description" value="${task.description}" required>
        <input type="submit" value="Actualizar">
    </form>
    <a href="showTasks">Cancelar</a>
</body>
</html>