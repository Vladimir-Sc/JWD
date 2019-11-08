<%@page import="com.ftninformatika.vezbe08.webshop.model.Proizvod"%>
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
			width: 20px
		}
		input[type="submit"] {
			width: 75px
		}
		input.plusIMinus {
			width: 30px
		}
	</style>
	<script type="text/javascript" src="js/SviProizvodi.js"></script>
</head>
<body>
	<table border="1">
		<caption>Proizvodi</caption>
		<tr>
			<th>Naziv</th>
			<th>Cena</th>
			<th>Kategorija</th>
		<% if (session.getAttribute("prijavljeniKorisnik") != null) { %>
			<th></th>
		<% } %>
		</tr>
	<% for (Proizvod itProizvod: proizvodi) { %>
		<tr>
			<td><a href="PrikaziProizvodServlet?id=<%= itProizvod.getID() %>"><%= itProizvod.getNaziv() %></a></td>
			<td><%= itProizvod.getCena() %></td>
			<td><a href="PrikaziKategorijuServlet?id=<%= itProizvod.getKategorija().getID() %>"><%= itProizvod.getKategorija().getNaziv() %></a></td>
		<% if (session.getAttribute("prijavljeniKorisnik") != null) { %>
			<td>
				<form method="post" action="DodajUKorpuServlet">
					<input type="hidden" name="proizvodID" value="<%= itProizvod.getID() %>"/>
					<input type="submit" value="-" class="plusIMinus" onclick="return klikNaMinus(this)"/>
					<input type="text" name="komada" value="1" readonly/>
					<input type="submit" value="+" class="plusIMinus" onclick="return klikNaPlus(this)"/>
					<input type="submit" value="U korpu"/>
				</form>
			</td>
		<% } %>
		</tr>
	<% } %>
	</table>
	<a href="PrikaziDodavanjeProizvodaServlet">Dodaj proizvod</a><br/>
	<br/>
	<a href="PocetnaServlet">Početna strana</a><br/>
</body>
</html>