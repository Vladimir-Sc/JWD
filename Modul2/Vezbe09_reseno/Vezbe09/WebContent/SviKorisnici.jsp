<%@page import="com.ftninformatika.vezbe09.webshop.model.Korisnik"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Korisnik> korisnici = (List<Korisnik>) request.getAttribute("korisnici");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Korisnici</title>
</head>
<body>
	<table border="1">
		<caption>Korisnici</caption>
		<tr><th>Korisničko ime</th></tr>
	<% for (Korisnik itKorisnik: korisnici) { %>
		<tr><td><a href="PrikaziKorisnikaServlet?korisnickoIme=<%= itKorisnik.getKorisnickoIme() %>"><%= itKorisnik.getKorisnickoIme() %></a></td></tr>
	<% } %>
	</table>
	<a href="Registracija.html">Registracija</a><br/>
	<br/>
	<a href="PocetnaServlet">Početna strana</a><br/>
</body>
</html>