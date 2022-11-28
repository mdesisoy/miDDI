<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar alumno</title>
</head>
<body>
<br/>
<form action="/AlumnoInsert" method="post">
	<span>Nombre:</span> <input type="text" id="nombre" name="nombre"> <br />
	<span>Edad:</span> <input type="number" id="edad" name="edad"> <br />
	<span>Titulacion:</span> <input type="number" id="titulacion" name="titulacion"> <br />
	<input type="submit">
</form>
<br/>
<a href="AlumnoList.jsp">Listado de alumnos</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>