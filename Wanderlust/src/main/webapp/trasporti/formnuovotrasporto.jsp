<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>
<% List<Compagnia> compagnie = (List<Compagnia>) request.getAttribute("compagnie"); %> 
<% List<Mezzo> mezzi = (List<Mezzo>) request.getAttribute("mezzi") ;%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiungi trasporto</title>
<script src="script/trasporto.js"></script>
</head>
<body>
	<h1>AGGIUNGI TRASPORTO</h1>
	<br>
	<br>
		<a href="elenco"><button>Return</button></a>
		<a href="/"><button >Exit</button></a>
	<hr>
	<form name="inserimento" action="aggiungi" method="post">
		<table>
			<tr>
				<td>
					MEZZO:
				</td>
				<td>
					<select name="idMezzo" >
						<% for(Mezzo mezzo : mezzi){ %>
							<option value="<%= mezzo.getId() %>"> <%= mezzo.getTipo() %></option>
						<%}%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					COMPAGNIA:
				</td>
				<td>
					<select name ="idCompagnia">
						<% for(Compagnia compagnia : compagnie){ %>
							<option value="<%= compagnia.getId() %>"> <%= compagnia.getNome() %></option>
						<%}%>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					NUMERO POSTI:
				</td>
				<td>
					<input type="number" name="nPosti"
						onKeyup="controlloPosti()">
				</td>
			</tr>
			<tr>
				<td>
					NOME TRASPORTO:
				</td>
				<td>
					<input type="text" name="nome">
				</td>
			</tr>
		</table>
  			<input type="submit" value="Inserisci">
	</form>
</body>
</html>