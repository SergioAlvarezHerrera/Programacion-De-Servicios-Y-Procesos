<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Usuario</title>
</head>
<body>
    <h2>Editar Usuario</h2>
    <form action="EditUserController" method="post">
        <input type="hidden" name="id" value="${user.id}" />
        <label>Nombre:</label>
        <input type="text" name="name" value="${user.name}" /><br/>
        <label>Email:</label>
        <input type="text" name="email" value="${user.email}" /><br/>
        <input type="submit" value="Guardar Cambios" />
    </form>
</body>
</html>
