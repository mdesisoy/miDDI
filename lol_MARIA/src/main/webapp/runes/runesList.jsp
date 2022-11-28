<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado runes</title>
    <!-- Required meta tags always come first -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<h1>Listado runes</h1>
<form action="/runesList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>
<div class="container-fluid">
    <form class="d-flex" role="search" action="/runesSearch" method="post">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" id="rune_name" name="rune_name">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<!--
<table>
    <tr>
    	<td>id</td>
    	<td>tier</td>
    	<td>rune_name</td>
    	<td>rune_description</td>
    </tr>
    <c:forEach items="${runes}" var="r">
        <tr>
            <td>${r.getId()}</td>
            <td>${r.getTier()}</td>
            <td>${r.getRune_name()}</td>
            <td>${r.getRune_description()}</td>
        </tr>
    </c:forEach>
</table> -->

<!-- tabla con bootstrap-->
<table class="table">
    <thead>
      <tr class="table-info">
        <th scope="col">id</th>
        <th scope="col">tier</th>
        <th scope="col">rune_name</th>
        <th scope="col">rune_description</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${runes}" var="r">
            <tr>
                <td>${r.getId()}</td>
                <td>${r.getTier()}</td>
                <td>${r.getRune_name()}</td>
                <td>${r.getRune_description()}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>

</body>
</html>