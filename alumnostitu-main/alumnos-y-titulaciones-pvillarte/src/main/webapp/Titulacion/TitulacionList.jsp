<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado titulaciones</title>
</head>
<body>
<h1>Listado titulaciones</h1>
<form action="/TitulacionList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit">
</form>
<table>
    <tr><td>Id</td><td>Titulo</td><td>Eliminar titulacion</td></tr>
    <c:forEach items="${titulaciones}" var="titulacion">
        <tr>
            <td>${titulacion.getId()}</td>
            <td>${titulacion.getTitulo()}</td>
            <td>
                <form action="/TitulacionDelete" method="get">
                    <input type="hidden" name="nomTitulacion" value="${titulacion.getTitulo()}"/>
                    <input type="hidden" name="idTitulacion" value="${titulacion.getId()}"/>
                    <input type="submit"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>