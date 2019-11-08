<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Ucesnik"%>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Ucesnik> ucesnici = (ArrayList<Ucesnik>) getServletContext().getAttribute("ucesniciTrke");
%>


<% 

System.out.println(ucesnici);

%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	
	<body>
		
		<%
		
		if(ucesnici == null) { %>
			
			<h2>Nema prijavljenih ucesnika</h2>
			<a href="index.html">Forma za upis ucesnika</a>
		<%  return;} %>
		
		<table>
			<!-- <caption>Korisnik</caption>  -->
			<tr>
				<th>Ime i prezime</th>
				<th>Kilometri</th>
				<th>Vreme</th>
				<th>Tip ucesnika</th>
				<th>Zavrsio trku</th>
				<th>Napomena</th>
				<th>Tip ucesca</th>
			</tr>
			
			<% for (Ucesnik itUcesnik: ucesnici) {  %>
			<tr>
			<td> <%= itUcesnik.getImePrezime() %> </td>
			<td> <%= itUcesnik.getBrKm() %> </td>
			<td> <%= itUcesnik.getVremeMin() %> </td>
			<td> <%= itUcesnik.getTipUcesnika() %> </td>
			<td> <%= itUcesnik.getZavrsioTrku() %>  </td>
			<td> <%= itUcesnik.getNapomena() %>  </td>
			<td> <%= itUcesnik.getTipUcesca().getNaziv() %>  </td>
			</tr>
			<% }  %>
		
			
		</table>
		
		<br>
		<a href=index.html>Prkazi formu</a>

	</body>
</html>