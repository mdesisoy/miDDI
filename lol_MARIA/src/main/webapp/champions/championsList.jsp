<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado champions</title>
    <!-- Required meta tags always come first -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<h1>Listado champions</h1>
<form action="/championsList" method="post">
    <br/>
    <a href="../index.jsp">Menu principal</a>
    <br/>
    <input type="submit"/>
</form>
<!--
<table>
    <tr>
    	<td>id</td>
    	<td>champion_name</td>
    	<td>title</td>
    	<td>lore</td>
    	<td>tags</td>
    </tr>
    <c:forEach items="${champions}" var="c">
        <tr>
            <td>${c.getId()}</td>
            <td>${c.getChampion_name()}</td>
            <td>${c.getTitle()}</td>
            <td>${c.getLore()}</td>
            <td>${c.getTags()}</td>
        </tr>
    </c:forEach>
</table> -->

<!-- tabla con bootstrap-->
<table class="table">
    <thead>
      <tr class="table-info">
        <th scope="col">id</th>
        <th scope="col">champion_name</th>
        <th scope="col">tittle</th>
        <th scope="col">lore</th>
        <th scope="col">tags</th>
        <th scope="col">abilities</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${champions}" var="c">
            <tr>
                <td>${c.getId()}</td>
                <td>${c.getChampion_name()}</td>
                <td>${c.getTitle()}</td>
                <td>${c.getLore()}</td>
                <td>${c.getTags()}</td>
                <td>
                    <form action="/abilitiesList" method="post">
                        <input type="hidden" name="id" value="${c.id}"/>
                        <input type="hidden" name="champion_name" value="${c.champion_name}"/>
                        <input type="hidden" name="title" value="${c.title}"/>
                        <input type="hidden" name="lore" value="${c.lore}"/>
                        <input type="hidden" name="tags" value="${c.tags}"/>
                        <input type="submit" value="Habilidades Campeón">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
  </table>

</body>
</html>