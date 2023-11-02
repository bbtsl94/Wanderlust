<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %>
<% Luogo luogo = (Luogo) request.getAttribute("luogo");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dettaglio luogo</title>
	
<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>DETTAGLI LUOGO</h2>
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
			<th><h1>Luogo</h1></th>			
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>

		<tr>

						<td>
							 <%=luogo.getId()%> 
						</td>
						<td>
							<%=luogo.getName()%>
						</td>
						
						
						<td>
							 <button><a href="formmodifica?id=<%=luogo.getId()%>"  style="text-decoration: none; color: white;">Modifica</a></button>
							
						</td>
						
			</tr>	
				
	</tbody>
</table>
		
	</body>

</html>