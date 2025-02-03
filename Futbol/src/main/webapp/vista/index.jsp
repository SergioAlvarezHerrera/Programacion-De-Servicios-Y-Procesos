<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="../servletFutbol" method="post">
		
		<p>dorsal: <input type="text" name="dorsal"></input></p>
		<p>nombre: <input type="text" name="nombre"></input></p>
		<p>edad:<input type="text" name="edad"></input></p>
			
		<p>Equipo: 
		<select name="equipos">
			<option>Atletico de madrid</option>
			<option>Real Vardrid</option>
			<option>Farsa</option>
		</select>
		</p>
		<input type="submit" value="ENVIAR"></input> 
		
	</form>

</body>
</html>