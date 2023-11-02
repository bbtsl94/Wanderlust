<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>    
<% Biglietto b = (Biglietto) request.getAttribute("biglietto"); %>
<% Persona p = (Persona) request.getAttribute("persona"); %>
<% Viaggio v = (Viaggio) request.getAttribute("viaggio"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>DETTAGLI</title>

<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>DETTAGLI VIAGGIO</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="imieiviaggi"  class="menu__link r-link text-underlined">Indietro</a></li>
				<li><a href="cercaviaggi" class="menu__link r-link text-underlined">Cerca viaggi</a></li>
				<li><a href="exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
<table class="container">
	<thead>
		 <tr>
			
			<th><h1>ID</h1></th>
			<th><h1>ID Prenotazione</h1></th>	
			<th><h1>Passeggero</h1></th>	
			<th><h1>Mezzo di trasporto</h1></th>
			<th><h1>Ora di partenza</h1></th>	
			<th><h1>Luogo di partenza</h1></th>	
			<th><h1>Ora di arrivo</h1></th>
			<th><h1>Luogo di arrivo</h1></th>	
			<th><h1>Classe</h1></th>	
			<th><h1>Stato di prenotazione</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>

		<tr>

						<td>
							<%= b.getId() %> 
						</td>
						<td>
							<%= b.getIdViaggio() %>
						</td>
						<td>
							<%= p.getCf() %>
						</td>
						<td>
							<%= v.getIdTrasporto() %> 
						</td>
						<td>
							<%= v.getOraPartenza() %>
						</td>
						<td>
							<%= v.getIdLuogoPartenza() %>
						</td>
						<td>
							<%= v.getOraArrivo() %>
						</td>
						<td>
							<%= v.getIdLuogoArrivo() %>
						</td>
						<td>
							<%= v.getClasse() %>
						</td>
						<td>
							<%= v.isDisponibile() %>
						</td>
						<td>
							<%= v.getClasse() %>
						</td>
						
						
						
						
						<td>
							 <button><a href="formmodifica?id=<%= v.getId() %>"  style="text-decoration: none; color: white;">Modifica</a></button>
							
						</td>
						
			</tr>	
				
	</tbody>
</table>
		
	</body>


</html>