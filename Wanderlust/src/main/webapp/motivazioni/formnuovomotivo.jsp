<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %> 
<% List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Aggiungi motivo</title>
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>AGGIUNGI MOTIVO</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="elenco" class="menu__link r-link text-underlined">Indietro</a></li>
				<li><a href="/sessione/menu" class="menu__link r-link text-underlined">Menu</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
			
	<form name="inserimento" action="aggiungi" method="post">
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Viaggio</h1></th>
			<th><h1>Motivo</h1></th>				
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							 <select name="idViaggio">
								<% for(Viaggio viaggio : viaggi ) {%>
									<option value="<%= viaggio.getId()%>"> <%= viaggio.getId()%> </option>
								<%}%>
							</select>
						</td>
						
						<td>
							<input type="text" name="motivo">
						</td>
						
						
						<td>
							 <button type="submit">Aggiungi</button>
							
						</td>
						
			</tr>	
	</tbody>
	</table>
	</form>
	</body>
	
</html>
	