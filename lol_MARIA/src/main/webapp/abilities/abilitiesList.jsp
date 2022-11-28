<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado abilities</title>
    <!-- Required meta tags always come first -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<h1>Listado abilities</h1>
<form action="/abilitiesList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>
<!--
<table>
    <tr>
    	<td>id</td>
    	<td>champion</td>
    	<td>champion_name</td>
    	<td>champion_description</td>
    	<td>effect</td>
    	<td>cost</td>
    	<td>rango</td>
    </tr>
    <c:forEach items="${abilities}" var="a">
        <tr>
            <td>${a.getId()}</td>
            <td>${a.getChampion()}</td>
            <td>${a.getChampion_name()}</td>
            <td>${a.getChampion_description()}</td>
            <td>${a.getEffect()}</td>
            <td>${a.getCost()}</td>
            <td>${a.getRango()}</td>
        </tr>
    </c:forEach>
</table> -->

<!-- tabla con bootstrap-->
<table class="table">
    <thead>
      <tr class="table-info">
        <th scope="col">id</th>
        <th scope="col">champion</th>
        <th scope="col">champion_name</th>
        <th scope="col">champion_description</th>
        <th scope="col">effect</th>
        <th scope="col">cost</th>
        <th scope="col">rango</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${abilities}" var="a">
            <tr>
                <td>${a.getId()}</td>
                <td>${a.getChampion()}</td>
                <td>${a.getChampion_name()}</td>
                <td>${a.getChampion_description()}</td>
                <td>${a.getEffect()}</td>
                <td>${a.getCost()}</td>
                <td>${a.getRango()}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>

</body>
</html>