<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Persona" %>
<%	Persona p= (Persona) request.getAttribute("persona"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica persona</title>
<!-- 	 -->	
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA PERSONA</h2>
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
					
					<th><h1>Nominativo</h1></th>
					<th><h1>Codice fiscale</h1></th>	
					<th><h1>Data di nascita</h1></th>
					<th><h1>Username</h1></th>	
					<th><h1>Password</h1></th>
					<th><h1>Email</h1></th>			
					<th><h1>Setting</h1></th>
					</tr>
				</thead>
				<tbody>	
					<tr>
						<td>
							 <input type="text" name = "nominativo" value = "<%=p.getNominativo()%>">
						</td>
						<td>
							<input type="text" name = "cf" value = "<%=p.getCf()%>" readonly>
						</td>
						<td>
							 <input type="text" name = "dob" value = "<%=p.getDob()%>">
						</td>
						<td>
							<input type="text" name = "username" value = "<%=p.getUsername()%>">
						</td>
						<td>
							 <input type="text" name = "password" value = "<%=p.getPassword()%>">
						</td>
						<td>
							<input type="text" name = "email" value = "<%=p.getEmail()%>">
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