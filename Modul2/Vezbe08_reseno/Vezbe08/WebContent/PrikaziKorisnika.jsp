<%@page import="com.ftninformatika.vezbe08.webshop.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Korisnik korisnik = (Korisnik) request.getAttribute("korisnik");
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
	</style>
</head>
<body>
	<form>
		<table>
			<caption>Korisnik</caption>
			<tr><td>Korisničko ime:</td><td><input type="text" value="<%= korisnik.getKorisnickoIme() %>" readonly/></td></tr>
		</table>
	</form>
	<br/>
	<a href="SviKorisniciServlet">Korisnici</a>
</body>
</html>