<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%List<Estudiante> listaEstudiantes = (List<Estudiante>)request.getAttribute("lista");%>
	
	<table border=1>
		
		<tr> <td>Id</td> <td>Nombre</td> <td>Apellido</td> <td>Edad</td> </tr>
		
		<%for ( Estudiante e : listaEstudiantes){ %>
	
	
		<tr>
		
		<td><%=e.getId()%></td>
		<td><%=e.getNombre()%></td>
		<td><%=e.getApellido()%></td>
		<td><%=e.getEdad()%></td>
		<td><a href="servlet?action=eliminar&id=<%=e.getId()%>">eliminar</a> 
		
		</tr>
	
	
	
	<%}%>
	
	
	</table>



</body>
</html>