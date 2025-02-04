<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="modelo.Equipo" import="modelo.Jugador" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Jugadores</title>
</head>
<body>
	<%
		Equipo equipo = (Equipo) request.getAttribute("equipo");
		List<Jugador> list =  equipo.getListaJugadores();
		
		for(Jugador jugador : list){
			if(equipo.getNombre().equalsIgnoreCase("Atletico de madrid"))
			
		
	
	%>
	<ul>
	
		<li><%=equipo.getNombre() %></li>
		<ul>
			<li><%=jugador %></li>
		
		</ul>
	
	</ul>
	
	<% } %>
</body>
</html>