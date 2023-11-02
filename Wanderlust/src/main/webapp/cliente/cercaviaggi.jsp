<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>    
<% List <Luogo> luoghi = (List <Luogo>) request.getAttribute("luoghi"); %>
<% List <Mezzo> mezzi = (List<Mezzo>) request.getAttribute("mezzi"); %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CERCA VIAGGIO</title>
<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>CERCA VIAGGIO</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
			<li><a href="/biglietti/imieiviaggi" class="menu__link r-link text-underlined">I miei viaggi</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
			
	<form action="viaggipermezzi" method="post">
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Partenza</h1></th>
			<th><h1>Arrivo</h1></th>	
			<th><h1>Mezzo</h1></th>
			
			<th><h1></h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							<select name="idPartenza">
							<%for(Luogo luogo: luoghi){%>
								<option value="<%=luogo.getId()%>"><%= luogo.getName() %></option>
							<%} %>
						</select>
						</td>
						<td>
							<select name="idArrivo">
						<%for(Luogo l: luoghi){%>
						<option value="<%=l.getId()%>"><%= l.getName() %></option>
						<%} %>
						</select>
						</td>
						<td>
						<select name="idMezzo">
						<%for(Mezzo m: mezzi){%>
							<option value="<%=m.getId()%>"><%= m.getTipo() %></option>
						<%} %>
						<option value="tutto">Tutto</option>
						</select>
						<td>
							 <button type="submit">Cerca</button>
							
						</td>
						
			</tr>	
	</tbody>
	</table>
	</form>
	</body>
	
</html>