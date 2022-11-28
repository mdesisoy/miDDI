<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insertar titulacion</title>
</head>
<body>
<br/>
<form action="/TitulacionInsert" method="post">
	<span>Titulo:</span> <input type="text" id="titulo" name="titulo"> <br />
	<input type="submit">
</form>
<br/>
<a href="TitulacionList.jsp">Listado de titulaciones</a>
<a href="../index.jsp">Menu principal</a>
<br/>
</body>
</html>