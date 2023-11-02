<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %>
<% List<Luogo> luoghi = (List<Luogo>) request.getAttribute("luoghi");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Elenco luoghi</title>
		<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>LOCALITA'</h2>
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
			
			<th><h1>Luogo</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Luogo l : luoghi){ %>
		<tr>
						
						<td>
							 <%= l.getName()%>
						</td>
						
						<td>
							 <button><a href="dettaglio?id=<%= l.getId() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?id=<%= l.getId() %>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
	</body>
</html>