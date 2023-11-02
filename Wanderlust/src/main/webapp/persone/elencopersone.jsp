<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Persona" %>
<% List<Persona> persone= (List<Persona>) request.getAttribute("persone");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco Persone</title>
		<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>PERSONE</h2>
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
			
			<th><h1>Nominativo</h1></th>
			<th><h1>Codice fiscale</h1></th>			
			<th><h1>Data di nascita</h1></th>
			<th><h1>Username</h1></th>
			<th><h1>Email</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Persona p : persone){ %>
		<tr>

						<td>
							 <%= p.getNominativo() %>
						</td>
						<td>
							<%= p.getCf() %>
						</td>
						<td>
							<%= p.getDob() %>
						</td>
						<td>
							<%= p.getUsername() %>
						</td>
						<td>
							<%= p.getEmail() %>
						</td>
						
						<td>
							 <button><a href="dettaglio?cf=<%= p.getCf() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?cf=<%= p.getCf() %>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
	
	
</html>