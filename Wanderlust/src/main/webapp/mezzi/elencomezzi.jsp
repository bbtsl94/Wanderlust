<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.agenzia.Wanderlust.entities.Mezzo"%>
<% List<Mezzo> mezzi= (List<Mezzo>) request.getAttribute("mezzi");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elenco Mezzi</title>
<link rel="stylesheet" href="/stile/elenco.css">
</head>

<body>
	<h2>MEZZI</h2>

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
			<th><h1>Mezzo</h1></th>
			<th><h1>Prezzo base</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Mezzo m : mezzi){ %>
		<tr>
						<td>
							 <%= m.getTipo() %>
						</td>
						<td>
							 <%= m.getPrezzoBase() %>
						</td>
						
						<td>
							 <button><a href="dettagli?id=<%= m.getId() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
							 <button><a href="elimina?id=<%= m.getId() %>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>

</body>
</html>