<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.agenzia.Wanderlust.entities.Compagnia" %>
<% Compagnia c=(Compagnia) request.getAttribute("compagnia"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Compagnia</title>
<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>DETTAGLI COMPAGNIA</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="elenco"  class="menu__link r-link text-underlined">Indietro</a></li>
				<li><a href="/sessione/menu" class="menu__link r-link text-underlined">Menu</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
<table class="container">
	<thead>
		 <tr>
			
			<th><h1>ID</h1></th>
			<th><h1>Nominativo</h1></th>			
			<th><h1>Supplemento</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>

		<tr>

						<td>
							 <%= c.getId() %>
						</td>
						<td>
							<%= c.getNome() %>
						</td>
						<td>
							<%= c.getSupplemento() %> %
						</td>
						
						<td>
							 <button><a href="formmodifica?id=<%= c.getId() %>"  style="text-decoration: none; color: white;">Modifica</a></button>
							
						</td>
						
			</tr>	
				
	</tbody>
</table>
		
	</body>
</html>