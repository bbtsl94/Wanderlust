<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Motivazione" %>
<% List<Motivazione> motivazioni= (List<Motivazione>) request.getAttribute("motivazioni");%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Elenco Motivazioni</title>
		<link rel="stylesheet" href="/stile/elenco.css">
		
	</head>
	
	
	<body>
		<h2>MOTIVAZIONI</h2>
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

			<th><h1>Motivazione</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<%for(Motivazione m : motivazioni){ %>
		<tr>
					
						<td>
							 <%= m.getMotivo() %>
						</td>
						
						<td>
							 <button><a href="formmodifica?idViaggio=<%= m.getIdViaggio()%>" style="text-decoration: none; color: white;">Modifica</a></button>
							<button><a href="elimina?idViaggio=<%= m.getIdViaggio()%>" style="text-decoration: none; color: white;">Cancella</a></button>
						</td>
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
	
</html>