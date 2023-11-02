<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %>
<% List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggio");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viaggio</title>

<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>ELENCO VIAGGI</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="/viaggi/cerca" class="menu__link r-link text-underlined">Cerca viaggi</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
<table class="container">
	<thead>
		 <tr>
			
			<th><h1>ID</h1></th>
			<th><h1>Trasporto</h1></th>			
			<th><h1>Ora di partenza</h1></th>
			<th><h1>Ora di arrivo</h1></th>
			<th><h1>Prezzo</h1></th>
			<th><h1>Casse</h1></th>
			<th><h1>Disponibile</h1></th>
			<th><h1>Cancellato</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<% for(Viaggio v : viaggi){%>
		<tr>

						<td>
						<%= v.getId() %>
						</td>
						<td>
						<%= v.getIdTrasporto() %>
						</td>
						<td>
							<%= v.getOraPartenza() %>
						</td>
						<td>
							<%= v.getOraArrivo() %>
						</td>
						<td>
							<%= v.getPrezzo() %>
						</td>
						<td>
							<%= v.getClasse() %>
						</td>
						<td>
							<%= v.isDisponibile() %>
						</td>
						<td>
							<%= v.isCancellato() %>
						</td>
						<td>
							<% if (v.isDisponibile() == true || v.isCancellato() == false){%>
							<a href="prenota?id=<%= v.getId() %>" style="text-decoration: none; color: white;">
							<button id="button" >Prenota</button>
							</a>
						<%}else{%>
								<a href="prenota?id=<%= v.getId() %>" style="text-decoration: none; color: white;">
								<button id="button"disabled>Prenota</button>
								</a>
							 <%} %>
						</td>
						
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
</html>