<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="modelo.Bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Bean b = (Bean)request.getAttribute("envio");
%>

<h1> BIENVENIDO</h1>
<h3> USUARIO : <% b.getemail(); %></h3>
<h3>CONTRASEÑA: <%b.getpassword(); %></h3>
<a href="mvcServlet?action=volver">volver</a>
</body>
</html>