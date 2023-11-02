<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<% List<Map<String, String>> biglietti = (List <Map<String, String>>) request.getAttribute("biglietti");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco biglietti</title>
	
	<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>BIGLIETTI
		</h2>
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
			
			<th><h1>Codice fiscale</h1></th>
			<th><h1>Luogo di partenza</h1></th>			
			<th><h1>Luogo di arrivo</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>

			<% if (biglietti != null) {%>
			<% for (Map<String, String> biglietto : biglietti) {%>
	<tbody>
		
		<tr>
			
						<td>
							 <%= biglietto.get("cf") %>
						</td>
						<td>
							<%= biglietto.get("partenza") %>
						</td>
						<td>
							<%= biglietto.get("arrivo") %>
						</td>
						
						
						<td>
							 <button><a href="dettaglio?id=<%= biglietto.get("idbiglietto")%>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?id=<%= biglietto.get("idbiglietto")%>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
		
			</tr>	
						<%} %>
		<%} %>	
	</tbody>
</table>
		
	</body>
	
</html>