<%@page import="java.util.List"%>
<%@page import="com.ftninformatika.vezbe08.webshop.model.Stavka"%>
<%@page import="com.ftninformatika.vezbe08.webshop.model.Korpa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Korpa korpa = (Korpa) request.getAttribute("korpa");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Korpa</title>
	<style type="text/css">
		input[type="submit"] {
			width: 75px
		}
	</style>
</head>
<body>
	<table border="1">
		<caption>Korpa</caption>
		<tr>
			<th>Naziv</th>
			<th>Cena</th>
			<th>Kategorija</th>
			<th>Komada</th>
			<th>Ukupna cena</th>
			<th></th>
		</tr>
	<%
		List<Stavka> stavke = korpa.getStavke();
		for (int redniBrojStavke = 0; redniBrojStavke < stavke.size(); redniBrojStavke++) {
			Stavka itStavka = stavke.get(redniBrojStavke);
	%>
		<tr>
			<td><a href="PrikaziProizvodServlet?id=<%= itStavka.getProizvod().getID() %>"><%= itStavka.getProizvod().getNaziv() %></a></td>
			<td><%= itStavka.getProizvod().getCena() %></td>
			<td><a href="PrikaziKategorijuServlet?id=<%= itStavka.getProizvod().getKategorija().getID() %>"><%= itStavka.getProizvod().getKategorija().getNaziv() %></a></td>
			<td><%= itStavka.getKomada() %></td>
			<td><%= itStavka.getCena() %></td>
			<td>
				<form method="post" action="UkloniIzKorpeServlet">
					<input type="hidden" name="redniBrojStavke" value="<%= redniBrojStavke %>"/>
					<input type="submit" value="Ukloni"/>
				</form>
			</td>
		</tr>
	<% } %>
		<tr>
			<td colspan="4"></td>
			<td><%= korpa.getCena() %></td>
			<td>
				<form method="post" action="IsprazniKorpuServlet">
					<input type="submit" value="Isprazni"/>
				</form>
			</td>
		</tr>
	</table>
	<br/>
	<a href="SviProizvodiServlet">Proizvodi</a><br/>
</body>
</html>