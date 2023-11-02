<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>
<%	Operatore o = (Operatore) request.getAttribute("operatore"); %>
<%   List<Compagnia> compagnie = (List<Compagnia>) request.getAttribute("compagnie"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica Operatore</title>
<!-- 	 -->

	
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA OPERATORE
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
			
			<th><h1>Codice fiscale</h1></th>
			<th><h1>ID compagnia</h1></th>	
			<th><h1>Sconto</h1></th>		
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		<tr>

						<td>
							 <input type="text" name = "cf" value = "<%=o.getCf()%>" readonly>
						</td>
						<td>
							<select name="idCompagnia" >
						 <%for (Compagnia c: compagnie){%>
						 
							 <%if(c.getId() == o.getIdcompagnia()){ %>
								<option selected value=<%= c.getId()%> > <%= c.getNome() %></option>
							<%}else {  %>
								<option value=<%= c.getId()%> > <%= c.getNome() %></option>
								<%} %>
							<%} %>
						</select>
						</td>
						<td>
							 <input type="text" name = "sconto" value = "<%=o.getSconto()%>">
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