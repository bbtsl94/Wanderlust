<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %>
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %>
<% Viaggio v = (Viaggio)request.getAttribute("viaggio");%>
<% Trasporto t = (Trasporto)request.getAttribute("trasporto");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prenota</title>

<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>PRENOTAZIONE</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
			<li><a href="imieiviaggi" class="menu__link r-link text-underlined">I miei viaggi</a></li>
			<li><a href="cercaviaggi" class="menu__link r-link text-underlined">Cerca viaggi</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
			
	<form>
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Partenza</h1></th>
			<th><h1>Arrivo</h1></th>	
			<th><h1>Orario partenza</h1></th>
			<th><h1>Orario arrivo</h1></th>
			<th><h1>Trasporto</h1></th>	
			<th><h1>Casse</h1></th>
			<th><h1>Prezzo</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							<%= v.getIdLuogoPartenza() %> 
						</td>
						<td>
							<%= v.getIdLuogoArrivo() %> 
						</td>
						<td>
						<%= v.getOraPartenza() %>
						</td>
						<td>
							<%= v.getOraArrivo() %> 
						</td>
						<td>
						<%= t.getNome() %> 
						</td>
						<td>
						<%= v.getClasse() %> 
						</td>
						<td>
						<%= v.getPrezzo() %> 
						</td>
					
						<td>
							 <a href="compra"><button>Acquista</button></a>
							
						</td>
						
			</tr>	
	</tbody>
	</table>
	</form>
	</body>
	
</html>