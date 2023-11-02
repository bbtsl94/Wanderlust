<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>

<% Biglietto biglietto = (Biglietto) request.getAttribute("biglietto");%>
<% List<Persona> persone = (List<Persona>) request.getAttribute("persone"); %>

<!DOCTYPE html>
<!-- ------------- -->


<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifica Biglietto</title>
		<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA BIGLIETTO</h2>
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
			
		<form action="modifica" method="get">
			<table class="container">
				<thead>
		 			<tr>
						<th><h1>Nominativo</h1></th>
            			<th><h1>Setting</h1></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="text" name = "id" value = "<%=biglietto.getId() %>" hidden=true>
						</td>
						<td>
							<input type="text" name = "idViaggio" value = "<%=biglietto.getIdViaggio()%>" hidden=true>
						</td>
						<td>
							<input type="number" name = "prezzo" value = "<%=biglietto.getPrezzo() %>" hidden=true>
						</td>
						<td>
							<select name="cf">
								<%for (Persona persona : persone) {%>
									<%if (persona.getCf().equals(biglietto.getCf())) {%>
										<option value=<%= persona.getCf()%> selected><%= persona.getNominativo() %></option>
									<%} else {%>
										<option value=<%= persona.getCf()%> selected><%= persona.getNominativo() %></option>
									<%} %>
								<%} %>
							</select>
						</td>
						<td>
							<button type="submit">Modifica</button>
						</td>					
					</tr>	
				</tbody>
			</table>
		</form>
	</body>
</html>