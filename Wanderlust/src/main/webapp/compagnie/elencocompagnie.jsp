<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Compagnia" %>
<% List<Compagnia> compagnie = (List<Compagnia>) request.getAttribute("compagnie");%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco compagnie</title>
		<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>COMPAGNIA</h2>
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
		 
			<th><h1>Compagnia</h1></th>
			<th><h1>Supplemento</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Compagnia c : compagnie){ %>
		<tr>
						
						<td>
							 <%= c.getNome() %>
						</td>
						<td>
							 <%= c.getSupplemento() %> %
						</td>
						
						<td>
							 <button><a href="dettaglio?id=<%= c.getId() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?id=<%= c.getId() %>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
</html>