<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado alumnos</title>
</head>
<body>
<h1>Listado alumnos</h1>
<form action="/AlumnoList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<table>
    <tr><td>Id</td><td>Nombre</td><td>Edad</td><td>Titulacion</td><td>Update titulacion</td></tr>
    <c:forEach items="${alumnos}" var="a">
        <tr>
            <td>${a.getId()}</td>
            <td>${a.getNombre()}</td>
            <td>${a.getEdad()}</td>
            <td>${a.getTitulacion()</td>
            <td><form action="/AlumnoUpdate" method="get">
                <input type="hidden" name="idAlumno" value="${a.getId()}"/>
                <input type="hidden" name="idTitulacion" value="${a.getTitulacion()}"/>
                <input type="submit"/>
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>