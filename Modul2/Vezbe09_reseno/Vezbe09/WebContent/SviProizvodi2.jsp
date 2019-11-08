<%@page import="com.ftninformatika.vezbe09.webshop.model.Proizvod"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Proizvod> proizvodi = (List<Proizvod>) request.getAttribute("proizvodi");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Proizvodi</title>
	<style type="text/css">
		input[type="text"] {
			width: 68px
		}
		input[type="submit"] {
			width: 75px
		}
	</style>
</head>
<body>
<% if (session.getAttribute("prijavljeniKorisnik") == null) { %>
	<table border="1">
		<caption>Proizvodi</caption>
		<tr>
			<th>Naziv</th>
			<th>Cena</th>
			<th>Kategorija</th>
		</tr>
	<% for (Proizvod itProizvod: proizvodi) { %>
		<tr>
			<td><a href="PrikaziProizvodServlet?id=<%= itProizvod.getID() %>"><%= itProizvod.getNaziv() %></a></td>
			<td><%= itProizvod.getCena() %></td>
			<td><a href="PrikaziKategorijuServlet?id=<%= itProizvod.getKategorija().getID() %>"><%= itProizvod.getKategorija().getNaziv() %></a></td>
		</tr>
	<% } %>
	</table>
<% } else { %>
	<form method="post" action="DodajUKorpuServlet2">
		<table border="1">
			<caption>Proizvodi</caption>
			<tr>
				<th>Naziv</th>
				<th>Cena</th>
				<th>Kategorija</th>
				<th></th>
			</tr>
		<% for (Proizvod itProizvod: proizvodi) { %>
			<tr>
				<td><a href="PrikaziProizvodServlet?id=<%= itProizvod.getID() %>"><%= itProizvod.getNaziv() %></a></td>
				<td><%= itProizvod.getCena() %></td>
				<td><a href="PrikaziKategorijuServlet?id=<%= itProizvod.getKategorija().getID() %>"><%= itProizvod.getKategorija().getNaziv() %></a></td>
				<td><input type="text" name="<%= itProizvod.getID() %>" value="1"/></td>
			</tr>
		<% } %>
			<tr><td colspan="3"></td><td><input type="submit" value="U korpu"/></td></tr>
		</table>
	</form>
<% } %>
	<br/>
	<a href="PocetnaServlet">Početna strana</a><br/>
</body>
</html>