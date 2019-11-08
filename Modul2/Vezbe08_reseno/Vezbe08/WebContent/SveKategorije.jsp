<%@page import="com.ftninformatika.vezbe08.webshop.model.Kategorija"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Kategorija> kategorije = (List<Kategorija>) request.getAttribute("kategorije");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Kategorije</title>
</head>
<body>
	<table border="1">
		<caption>Kategorije</caption>
		<tr><th>Naziv</th></tr>
	<% for (Kategorija itKategorija: kategorije) { %>
		<tr><td><a href="PrikaziKategorijuServlet?id=<%= itKategorija.getID() %>"><%= itKategorija.getNaziv() %></a></td></tr>
	<% } %>
	</table>
	<a href="DodajKategoriju.html">Dodaj kategoriju</a><br/>
	<br/>
	<a href="PocetnaServlet">Početna strana</a><br/>
</body>
</html>