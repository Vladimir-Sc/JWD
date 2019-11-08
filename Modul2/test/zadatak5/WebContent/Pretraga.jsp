
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="model.Ucesnik"%>    
<%@page import="java.util.List"%>


<%
	@SuppressWarnings("unchecked")
	List<Ucesnik> ucesnici = (List<Ucesnik>) request.getAttribute("pretragaPoKm");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezultat pretrage po km</title>
</head>
<body>
<h1>Rezultat pretrage po km</h1>

		<table border="1">
			<caption>Pretraga po predjenim kilometrima</caption>
		<tr>
			<th>Ucesnik</th>
			<th>Broj predjenih kilometara</th>
		</tr>
	<% for (Ucesnik itUcesnik: ucesnici) { %>
		<tr>
			<td> <%= itUcesnik.getImePrezime() %></td>
			<td> <%= itUcesnik.getBrKm() %> </td>
		</tr>
	<% } %>
	</table>
	<br>
	<a href="index.html">Početna strana</a>
	
</body>
</html>