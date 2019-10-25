<%@page import="com.ftninformatika.vezbe07.webshop.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// čitanje prijavljenog korisnika iz sesije
	Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Web shop</title>
</head>
<body>
	<h3>Web shop</h3>
	<a href="SveKategorijeServlet">Kategorije</a><br/>
	<a href="SviProizvodiServlet">Proizvodi</a>&nbsp;<a href="SviProizvodiServlet2">Proizvodi2</a><br/>
	<a href="SviKorisniciServlet">Korisnici</a><br/>
	<br/>
<% if (prijavljeniKorisnik == null) { %>
	<a href="Prijava.html">Prijava</a><br/>
<% } else { %>
	<a href="PrikaziKorpuServlet">Korpa</a><br/>
	<a href="OdjavaServlet">Odjava</a>
<% } %>
</body>
</html>

