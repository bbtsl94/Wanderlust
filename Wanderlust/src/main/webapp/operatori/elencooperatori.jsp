<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.agenzia.Wanderlust.entities.Operatore"%>
<% List<Operatore> operatori = (List<Operatore>) request.getAttribute("operatori");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elenco Operatori</title>
<link rel="stylesheet" href="/stile/elenco.css">
</head>

	<body>
		<h2>OPERATORI</h2>
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
			<th><h1>Sconto</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Operatore o : operatori){ %>
		<tr>
						<td>
							<%= o.getCf() %>
						</td>
						<td>
							 <%= o.getSconto() %> %
						</td>
						
						<td>
							 <button><a href="dettagli?cf=<%= o.getCf() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
							<button><a href="elimina?cf=<%= o.getCf() %>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
	
	
</html>