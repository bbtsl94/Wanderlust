<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %>   
<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %>  

<% List <Luogo> luoghi = (List <Luogo>) request.getAttribute("luoghi");%>
<% List <Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco viaggi</title>
	
	<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>VIAGGI</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="formnuovo" class="menu__link r-link text-underlined">Aggiungi</a></li>
				<li><a href="/sessione/menu" class="menu__link r-link text-underlined">Menu</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
<table class="container">
	<thead>
		 <tr>
			
			<th><h1>Partenza</h1></th>
			<th><h1>Arrivo</h1></th>			
			<th><h1>Data di partenza</h1></th>
			<th><h1>Ora di partenza</h1></th>
			<th><h1>Data di arrivo</h1></th>
			<th><h1>Ora di arrivo</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Viaggio viaggio : viaggi){ %>
		<tr>

						<td>
						<% for (Luogo luogo : luoghi) { %>
							<% if (luogo.getId() == viaggio.getIdLuogoPartenza()) {%>
								<%= luogo.getName()%>
							<%} %>
						<%} %>
						</td>
						<td>
						<% for (Luogo luogo : luoghi) { %>
							<% if (luogo.getId() == viaggio.getIdLuogoArrivo()) {%>
								<%= luogo.getName()%>
							<%} %>
						<%} %>
						</td>
						<td>
							<%= viaggio.getOraPartenza().toLocalDate().toString()%>
						</td>
						<td>
							<%= viaggio.getOraPartenza().toLocalTime().toString()%>
						</td>
						<td>
							<%= viaggio.getOraArrivo().toLocalDate().toString()%>
						</td>
						<td>
							<%= viaggio.getOraArrivo().toLocalTime().toString()%>
						</td>
						
						<td>
							 <button><a href="dettaglio?id=<%= viaggio.getId()%>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?id=<%= viaggio.getId()%>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
</html>