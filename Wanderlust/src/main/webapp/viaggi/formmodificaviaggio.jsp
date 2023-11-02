<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %>
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %> 
<%@ page import="com.agenzia.Wanderlust.entities.Motivazione" %> 
<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %> 
<%@ page import="java.time.format.DateTimeFormatter" %> 
<% List <Luogo> luoghi = (List <Luogo>) request.getAttribute("luoghi");%>
<% List <Trasporto> trasporti = (List <Trasporto>) request.getAttribute("trasporti");%>
<% Viaggio viaggio = (Viaggio) request.getAttribute("viaggio");%>
<% Motivazione motivazione = (Motivazione) request.getAttribute("motivo");%>
<% DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
   String partenza = viaggio.getOraPartenza().format(format);
   String arrivo = viaggio.getOraArrivo().format(format);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifica viaggio</title>
		<script>
			function changeReasonTextboxStatus()
			{
				var checkbox = document.getElementById("isCancelledCheckbox");
				var reason = document.getElementById("reasonTextbox");
				var availableCheckbox = document.getElementById("isAvailableCheckbox");
				reason.value = "";
				reason.disabled = !checkbox.checked;
				if (availableCheckbox.checked && checkbox.checked)
				{
					availableCheckbox.checked = false;
				}
			}
		</script>

<!-- 	 -->

	
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA VIAGGIO
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
			
	<form action="modifica" method="post">
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Luogo di partenza</h1></th>
			<th><h1>Luogo di arrivo</h1></th>
			<th><h1>Data e ora di partenza</h1></th>
			<th><h1>Data e ora di arrivo</h1></th>	
			<th><h1>Trasporto</h1></th>
			<th><h1>Prezzo</h1></th>
			<th><h1>Classe</h1></th>
			<th><h1>Disponibilità</h1></th>
			<th><h1>Cancellato</h1></th>	
			<th><h1>Motivazione cancellazione</h1></th>			
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							 <select name="idPartenza">
							<% for (Luogo luogo : luoghi) {%>
								<option value=<%=luogo.getId()%> <% if (luogo.getId() == viaggio.getIdLuogoPartenza()) { %> selected <%} %>><%= luogo.getName()%></option>
							<%} %>
						</select>
						</td>
						<td>
							<select name="idArrivo">
							<% for (Luogo luogo : luoghi) {%>
								<option value=<%=luogo.getId()%> <% if (luogo.getId() == viaggio.getIdLuogoArrivo()) { %> selected <%} %>><%= luogo.getName()%></option>
							<%} %>
							</select>
						</td>
						<td>
							<input type="datetime-local" name="oraP" value=<%= partenza %>>
						</td>
						<td>
							<input type="datetime-local" name="oraA" value=<%= arrivo %>>
						</td>
						<td>
							<select name="idTrasporto">
							<% for (Trasporto trasporto : trasporti) {%>
								<option value=<%=trasporto.getNome()%> <% if (trasporto.getNome() == viaggio.getIdTrasporto()) { %> selected <%} %>><%= trasporto.getNome()%></option>
							<%} %>
						</select>
						</td>
						<td>
							<input type="number" name="prezzo" value=<%= viaggio.getPrezzo() %>>
						</td>
						<td>
							<input type="number" name="classe" value=<%= viaggio.getClasse() %>>
						</td>
						<td>
							<input type="checkbox" id=isAvailableCheckbox name="disponibile" <% if (viaggio.isDisponibile()) {%> checked <%} %>>
						</td>
						<td>
							<input type="checkbox" id=isCancelledCheckbox onClick="changeReasonTextboxStatus()" name="cancellato" <% if (viaggio.isCancellato()) {%> checked <%} %>>
						</td>
						<td>
							<input type="text" disabled id="reasonTextbox" name="motivo" value=<% if (viaggio.isCancellato()) {%><%= motivazione.getMotivo()%><%} %>>
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