<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Compagnia" %>
<%	Compagnia c = (Compagnia) request.getAttribute("compagnia"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica compagnia</title>
<!-- 	 -->

	
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>MODIFICA COMPAGNIA
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
			
			<th><h1>ID</h1></th>
			<th><h1>Nome</h1></th>		
			<th><h1>Supplemento</h1></th>	
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
							 <input type="text" name = "id" value = "<%=c.getId()%>" readonly>
						</td>
						<td>
							<input type="text" name = "nome" value = "<%=c.getNome()%>">
						</td>
						<td>
							<input type="text" name = "supplemento" value = "<%=c.getSupplemento()%>">
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