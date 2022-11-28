<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado tips</title>
    <!-- Required meta tags always come first -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
    <!--Barra navegadora con bootstrap-->
    <nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
		  <a class="navbar-brand" href="#">Listado tips</a>
		  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
			  <li class="nav-item">
				<a class="nav-link active" aria-current="page" href="../index.jsp">Índice</a>
              </li>
			</ul>
		  </div>
		</div>
	  </nav>

      <form action="/tipsList" method="post">
        <button type="submit" class="btn btn-info">Cargar Info</button>
      </form>
<!--<h1>Listado tips</h1>
<form action="/tipsList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>-->

<!--<table>
    <tr>
    	<td>id</td>
    	<td>champion</td>
    	<td>tips</td>
    </tr>
    <c:forEach items="${tips}" var="t">
        <tr>
            <td>${t.getId()}</td>
            <td>${t.getChampion()}</td>
            <td>${t.getTip()}</td>
        </tr>
    </c:forEach>
</table>-->

<!-- tabla con bootstrap-->
<table class="table">
    <thead>
      <tr class="table-info">
        <th scope="col">id</th>
        <th scope="col">champion</th>
        <th scope="col">tips</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${tips}" var="t">
            <tr>
                <td>${t.getId()}</td>
                <td>${t.getChampion()}</td>
                <td>${t.getTip()}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>

</body>
</html>