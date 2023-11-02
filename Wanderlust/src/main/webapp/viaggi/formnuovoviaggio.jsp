<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %> 
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %>

<% List<Luogo> luoghi = (List<Luogo>) request.getAttribute("luoghi");%>
<% List<Trasporto> trasporto = (List<Trasporto>) request.getAttribute("trasporti");%>


<!DOCTYPE html>
<html>
    <head>
        <title>Nuovo viaggio</title>
    </head>
    <body>
        <h1> CREA VIAGGIO</h1>
		<br>
		<a href="elenco"><input type="button" value="Elenco viaggi"></a>
		<br>
		<hr>
        <form action="aggiungi" method="get">
            <table>
				<!-- blocco partenza -->
				<tr>
					<td>
						Luogo partenza
					</td>
				</tr>
				<tr>
					<td>
						<select name="idPartenza" >
							<% for(Luogo l : luoghi){ %>
								<option value="<%=  l.getId() %>"> <%=  l.getName() %> </option>
							<%}%>
						</select>
					</td>
				</tr>
				<!-- blocco arrivo -->
				<tr>
					<td>
						Luogo arrivo
					</td>
				</tr>
				<tr>
					<td>
						<select name="idArrivo" >
							<% for(Luogo l : luoghi){ %>
								<option value="<%=  l.getId() %>"> <%=  l.getName() %> </option>
							<%}%>
						</select>
					</td>
				</tr>

				<!-- blocco trasporto -->
				<tr>
					<td>
						Trasporto
					</td>
				</tr>
				<tr>
					<td>
						<select name="idTrasporto" >
							<% for(Trasporto t : trasporto){ %>
								<option value="<%= t.getNome() %>"> <%=  t.getNome() %> </option>
							<%}%>
						</select>
					</td>
				</tr>

				<!-- blocco partenza -->
				<tr>
					<td>
						Data e ora partenza
					</td>
				</tr>
				<tr>
					<td>
						<input type="datetime-local"  name="oraP">
					</td>
				</tr>

				<!-- blocco arrivo -->
				<tr>
					<td>
						Data e ora arrivo
					</td>
				</tr>
				<tr>
					<td>
						<input type="datetime-local"  name="oraA">
					</td>
				</tr>
				<!-- blocco prezzo -->
				<tr>
					<td>
						Prezzo
					</td>
				</tr>
				<tr>
					<td>
						<input type="number"  name="prezzo">
					</td>
				</tr>
				<!-- blocco classe -->
				<tr>
					<td>
						Classe
					</td>
				</tr>
				<tr>
					<td>
						<input type="number"  name="classe">
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Crea">
        </form>
    </body>
</html>