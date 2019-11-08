<%@page import="java.util.List"%>
<%@page import="com.ftninformatika.vezbe09.webshop.model.Kategorija"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	@SuppressWarnings("unchecked")
	List<Kategorija> kategorije = (List<Kategorija>) request.getAttribute("kategorije");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dodavanje proizvoda</title>
	<style type="text/css">
		input[type="text"] {
			width: 150px
		}
		input[type="submit"] {
			width: 75px
		}
		option {
			width: 130px
		}
		p.upozorenje {
			color: red
		}
		input.nevalidan {
			background-color: lightcoral
		}
	</style>
	<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="js/PrikaziDodavanjeProizvoda.js"></script>
</head>
<body>
	<form name="dodavanje" method="post" action="DodajProizvodServlet">
		<table>
			<caption>Dodavanje proizvoda</caption>
			<tr><td>Naziv:</td><td><input type="text" name="naziv"/></td></tr>
			<tr><td>Cena:</td><td><input type="text" name="cena"/></td></tr>
			<tr>
				<td>Kategorija:</td>
				<td>
					<select name="kategorijaID">
					<% for (Kategorija itKategorija: kategorije) { %>
						<option value="<%= itKategorija.getID() %>"><%= itKategorija.getNaziv() %></option>
					<% } %>
					</select>
				</td>
			</tr>
			<tr><td></td><td><input type="submit" value="Dodaj"/></td></tr>
		</table>
		<p class="upozorenje"></p>
	</form>
	<a href="SviProizvodiServlet">Proizvodi</a>
</body>
</html>