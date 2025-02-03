<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Introducir datos para verificar</h2>
<form action="mvcServlet" method="post">

	<p>Email: <input type="text" name="email"></p>
	<p>Password: <input type="text" name="password"></p>
	<p><input type="submit" value="Enviar"></p>
	
<%
String mensaje = (String)request.getAttribute("error");
if (mensaje != null)
{
%>
<h1>Error en los datos <%=mensaje %></h1>	
<%	
}
%>





</form>
</body>
</html>