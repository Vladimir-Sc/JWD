<%@page import="java.util.List"%>
<%@page import="com.ftninformatika.vezbe08.webshop.model.Kategorija"%>
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
		td.upozorenje {
			color: red
		}
	</style>
	<script type="text/javascript" src="js/PrikaziDodavanjeProizvoda.js"></script>
</head>
<body>
	<form method="post" action="DodajProizvodServlet" name="dodavanje">
		<table>
			<caption>Dodavanje proizvoda</caption>
			<tr><td>Naziv:</td><td><input type="text" name="naziv" onfocus="ulazakUPolje(this)" onfocusout="izlazakIzPolja(this)"/></td><td class="upozorenje">*</td></tr>
			<tr><td>Cena:</td><td><input type="text" name="cena" onfocus="ulazakUPolje(this)" onfocusout="izlazakIzPolja(this)"/></td><td class="upozorenje">*</td></tr>
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
			<tr><td></td><td><input type="submit" value="Dodaj" onclick="return validacija()"/></td></tr>
		</table>
	</form>
	<a href="SviProizvodiServlet">Proizvodi</a>
</body>
</html>