<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>
<%   List<Compagnia> compagnie = (List<Compagnia>) request.getAttribute("compagnie"); %>
<%   List<Persona> persone = (List<Persona>) request.getAttribute("persone"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
    <head>
        <title>Operatori</title>   
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
			
			<th><h1>Codice Fiscale</h1></th>
			<th><h1>id Compagnia</h1></th>	
			<th><h1>Sconto</h1></th>		
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td><select name="cf" >
                            <%for ( Persona persona : persone){%>
                               <option value=<%= persona.getCf() %> > <%= persona.getCf() %> </option>
                               <%} %>
                           </select>
						</td>
						<td>
						<select name="idCompagnia" >
						 <%for (Compagnia c: compagnie){%>
							<option value=<%= c.getId()%> > <%= c.getNome() %></option>
							<%} %>
						</select>
						</td>
						<td>
							<input type="number" placeholder="Inserisci sconto" name="sconto">
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