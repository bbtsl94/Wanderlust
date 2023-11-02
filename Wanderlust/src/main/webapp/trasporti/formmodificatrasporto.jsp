<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %>
<%@ page import="com.agenzia.Wanderlust.entities.Compagnia" %>
<%@ page import="com.agenzia.Wanderlust.entities.Mezzo" %>
<%	Map<String,String> trasporto = (Map<String,String>) request.getAttribute("trasporto"); %>
<% List<Compagnia> compagnie = (List<Compagnia>) request.getAttribute("compagnie"); %> 
<% List<Mezzo> mezzi = (List<Mezzo>) request.getAttribute("mezzi") ;%> 
		
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifica trasporto</title>
		<script src="script/trasporto.js"></script>

<!-- 	 -->

	
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA TRASPORTO
		</h2>
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
			
	<form name="inserimento" action="modifica" method="post">
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Mezzo</h1></th>
			<th><h1>Compagnia</h1></th>	
			<th><h1>Numero posti</h1></th>
			<th><h1>Nome trasporto</h1></th>			
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		<tr>
						<td>
							 <select name="idMezzo" >
						<% for(Mezzo mezzo : mezzi){ %>
							<% if(mezzo.getTipo() == trasporto.get("Tipo mezzo")) {%>
								<option selected value="<%= mezzo.getId() %>"> <%= mezzo.getTipo() %></option>
							<%}else{%>
							<option value="<%= mezzo.getId() %>"> <%= mezzo.getTipo() %></option>
							<%}%>			
						<%}%>
					</select>
						</td>
						<td>
							<select name ="idCompagnia" >
							<% for(Compagnia compagnia : compagnie){ %>
								<% if(compagnia.getNome() ==  trasporto.get("Nome compagnia")) {%>
									<option selected value="<%= compagnia.getId() %>"> <%= compagnia.getNome() %></option>

								<%}else{%>
								<option value="<%= compagnia.getId() %>"> <%= compagnia.getNome() %></option>
								<%}%>
							<%}%>
						</select>
						</td>
						<td>
							<input type="text" name = "nPosti" value = "<%= trasporto.get("posti totali")   %>">
						</td>
						<td>
							<input type="text" name = "nome" value = "<%= trasporto.get("nome trasporto") %>" readonly>
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