<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.agenzia.Wanderlust.entities.Mezzo" %>
<% Mezzo m=(Mezzo) request.getAttribute("mezzo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettagli mezzo</title>

<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>DETTAGLI MEZZO</h2>
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
			<th><h1>Tipo</h1></th>	
			<th><h1>Prezzo base</h1></th>			
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>

		<tr>

						<td>
							 <%= m.getId() %> 
						</td>
						<td>
							<%= m.getTipo() %>
						</td>
						<td>
							<%= m.getPrezzoBase() %>
						</td>
						
						
						<td>
							 <button><a href="formmodifica?id=<%= m.getId() %>"  style="text-decoration: none; color: white;">Modifica</a></button>
							
						</td>
						
			</tr>	
				
	</tbody>
</table>
		
	</body>


</html>