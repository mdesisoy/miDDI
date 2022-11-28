<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado stats</title>
    <!-- Required meta tags always come first -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<h1>Listado stats</h1>
<form action="/statsList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>

<!--
<table>
    <tr>
    	<td>champion</td>
    	<td>stat_name</td>
    	<td>stat_value</td>
    	<td>modifier_per_level</td>
    </tr>
    <c:forEach items="${stats}" var="s">
        <tr>
            <td>${s.getChampion()}</td>
            <td>${s.getStat_name()}</td>
            <td>${s.getStat_value()}</td>
            <td>${s.getModifier_per_level()}</td>
        </tr>
    </c:forEach>
</table> -->

<!-- tabla con bootstrap-->
<table class="table">
    <thead>
      <tr class="table-info">
        <th scope="col">champion</th>
        <th scope="col">stat_name</th>
        <th scope="col">stat_value</th>
        <th scope="col">modifier_per_level</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${stats}" var="s">
            <tr>
                <td>${s.getChampion()}</td>
                <td>${s.getStat_name()}</td>
                <td>${s.getStat_value()}</td>
                <td>${s.getModifier_per_level()}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>

</body>
</html>