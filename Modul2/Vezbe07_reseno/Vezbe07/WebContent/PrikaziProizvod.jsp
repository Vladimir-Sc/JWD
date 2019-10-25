<%@page import="com.ftninformatika.vezbe07.webshop.model.Proizvod"%>
<%@page import="java.util.List"%>
<%@page import="com.ftninformatika.vezbe07.webshop.model.Kategorija"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Proizvod proizvod = (Proizvod) request.getAttribute("proizvod");
	@SuppressWarnings("unchecked")
	List<Kategorija> kategorije = (List<Kategorija>) request.getAttribute("kategorije");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Proizvod</title>
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
		td.labela {
			width: 75px
		}
	</style>
</head>
<body>
	<form method="post" action="IzmeniProizvodServlet">
		<input type="hidden" name="id" value="<%= proizvod.getID() %>"/>
		<table>
			<caption>Proizvod</caption>
			<tr><td class="labela">Naziv:</td><td><input type="text" name="naziv" value="<%= proizvod.getNaziv() %>"/></td></tr>
			<tr><td class="labela">Cena:</td><td><input type="text" name="cena" value="<%= proizvod.getCena() %>"/></td></tr>
			<tr>
				<td class="labela">Kategorija:</td>
				<td>
					<select name="kategorijaID">
					<% for (Kategorija itKategorija: kategorije) { %>
						<% if (itKategorija.equals(proizvod.getKategorija())) { %>
							<option value="<%= itKategorija.getID() %>" selected><%= itKategorija.getNaziv() %></option>
						<% } else { %>
							<option value="<%= itKategorija.getID() %>"><%= itKategorija.getNaziv() %></option>
						<% } %>
					<% } %>
					</select>
				</td>
			</tr>
			<tr><td class="labela"></td><td><input type="submit" value="Izmeni"/></td></tr>
		</table>
	</form>
	<form method="post" action="ObrisiProizvodServlet">
		<input type="hidden" name="id" value="<%= proizvod.getID() %>"/>
		<table>
			<tr><td class="labela"></td><td><input type="submit" value="Obriši"/></td></tr>
		</table>
	</form>
	<a href="SviProizvodiServlet">Proizvodi</a>
</body>
</html>