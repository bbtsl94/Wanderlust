<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %> 
<% Persona p = (Persona) request.getAttribute("persona"); %>
<% List<Biglietto> biglietti = (List<Biglietto>) request.getAttribute("biglietti");%>
<% List<Luogo> luoghi = (List<Luogo>) request.getAttribute("luoghi");%>
<% List<Viaggio> viaggi = (List<Viaggio>) request.getAttribute("viaggi");%>
<!DOCTYPE html>
<html>
	<head>
		<title>I MIEI VIAGGI</title>

<link rel="stylesheet" href="/stile/elenco.css">
	</head>
	<body>
		<h2>I MIEI VIAGGI</h2>
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
			
			<th><h1>Partenza</h1></th>
			<th><h1>Arrivo</h1></th>			
			<th><h1>Data e ora di partenza</h1></th>
			<th><h1>Data e ora di arrivo</h1></th>
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
		<% for(Biglietto b : biglietti){%>
		<tr>

						<td>
						<% for (Viaggio viaggio : viaggi) {%>
							<% if (viaggio.getId() == b.getIdViaggio()) {%>
								<% for (Luogo luogo : luoghi) {%>
									<% if (viaggio.getIdLuogoPartenza() == luogo.getId()) {%>
										<%=luogo.getName() %>
									<%} %>
								<%} %>
							<%} %>
						<%} %>
						</td>
						<td>
						<% for (Viaggio viaggio : viaggi) {%>
						<% if (viaggio.getId() == b.getIdViaggio()) {%>
							<% for (Luogo luogo : luoghi) {%>
								<% if (viaggio.getIdLuogoArrivo() == luogo.getId()) {%>
									<%=luogo.getName() %>
								<%} %>
							<%} %>
						<%} %>
					<%} %>
						</td>
						<td>
							<% for (Viaggio viaggio : viaggi) {%>
							<% if (viaggio.getId() == b.getIdViaggio()) {%>
								<%= viaggio.getOraPartenza().toString().replace("T", " ") %>
							<%} %>
						<%} %>
						</td>
						<td>
							<% for (Viaggio viaggio : viaggi) {%>
							<% if (viaggio.getId() == b.getIdViaggio()) {%>
								<%= viaggio.getOraArrivo().toString().replace("T", " ") %>
							<%} %>
						<%} %>
						</td>
					
						<td>
							<button><a href="dettagliimieiviaggi?id=<%= b.getIdViaggio() %>" style="text-decoration: none; color: white;">Dettagli</a></button>
						</td>
						
						
			</tr>	
				<% } %>
	</tbody>
</table>
		
	</body>
</html>