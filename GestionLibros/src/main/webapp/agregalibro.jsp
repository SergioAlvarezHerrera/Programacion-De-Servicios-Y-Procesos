<!DOCTYPE html>
<html>
<head>
    <title>Agregar Libro</title>
</head>
<body>
    <h1>Agregar Libro</h1>
    <form action="ServletLibro" method="post">
	    <label for="titulo">Título:</label>
	    <input type="text" id="titulo" name="titulo"><br>
	    <label for="autor">Autor:</label>
	    <input type="text" id="autor" name="autor"><br>
	    <input type="submit" value="Agregar">
	</form>
    <a href="ServletLibro?action=list">Ver lista de libros</a>
</body>
</html>