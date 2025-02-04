<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page  import="java.util.List"  %>
 <%@ page import="modelo.Tarea"    %>
 
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tareas</title>
</head>
<body>
    <h2>Lista de Tareas</h2>
   <%
   
   List<Tarea> tarea = (List<Tarea>) request.getAttribute("tasks");
   for(Tarea tarea1 : tarea){
	 %> 
	 <p><%=tarea1.getDescription()%><p>
	 <a href="DeleteTaskServlet?id=<%=tarea1.getId()%>">Eliminar</a>
	 
	<%	} %>

	   
   
    <a href="index.jsp">Agregar nueva tarea</a>
    
</body>
</html>