<%@page import="com.ftninformatika.vezbe07.webshop.model.Kategorija"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Kategorija kategorija = (Kategorija) request.getAttribute("kategorija");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Kategorija</title>
	<style type="text/css">
		input[type="text"] {
			width: 150px
		}
		input[type="submit"] {
			width: 75px
		}
		td.labela {
			width: 50px
		}
	</style>
</head>
<body>
	<form method="post" action="IzmeniKategorijuServlet">
		<input type="hidden" name="id" value="<%= kategorija.getID() %>"/>
		<table>
			<caption>Kategorija</caption>
			<tr><td class="labela">Naziv:</td><td><input type="text" name="naziv" value="<%= kategorija.getNaziv() %>"/></td></tr>
			<tr><td class="labela"></td><td><input type="submit" value="Izmeni"/></td></tr>
		</table>
	</form>
	<form method="post" action="ObrisiKategorijuServlet">
		<input type="hidden" name="id" value="<%= kategorija.getID() %>"/>
		<table>
			<tr><td class="labela"></td><td><input type="submit" value="Obriši"/></td></tr>
		</table>
	</form>
	<a href="SveKategorijeServlet">Kategorije</a>
</body>
</html>