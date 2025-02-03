<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Usuario</title>
</head>
<body>
    <h2>Agregar Usuario</h2>
    <form action="UserController" method="post">
        <label>Nombre:</label>
        <input type="text" name="name" /><br/>
        <label>Email:</label>
        <input type="text" name="email" /><br/>
        <input type="submit" value="Agregar Usuario" />
    </form>

    
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>
</body>
</html>
