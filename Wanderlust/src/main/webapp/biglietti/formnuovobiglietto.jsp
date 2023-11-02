<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.agenzia.Wanderlust.entities.Persona" %>
<% List<Persona> persone = (List<Persona>) request.getAttribute("persone");%>
<% List<Map<String, String>> datiViaggi = (List<Map<String, String>>) request.getAttribute("viaggi");%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Nuovo biglietto</title>
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>AGGIUNGI TRASPORTO</h2>
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
			
			<th><h1>Titolare</h1></th>
			<th><h1>Prezzo</h1></th>	
			<th><h1>Viaggio</h1></th>		
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							 <select name="cf">
							<% for (Persona persona : persone) {%>
								<option value=<%=persona.getCf()%>><%= persona.getNominativo()%></option>
							<%} %>
						</select>
						</td>
						<td>
							<input type="number" name="prezzo">
						</td>
						<td>
							<select name="idViaggio">
							<% for (Map<String, String> datiViaggio : datiViaggi) {%>
								<option value=<%=datiViaggio.get("id")%>><%= datiViaggio.get("partenza")%> -> <%= datiViaggio.get("arrivo") %></option>
							<%} %>
						</select>
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
	
</html>