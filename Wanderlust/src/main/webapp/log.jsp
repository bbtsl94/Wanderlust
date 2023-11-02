<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*" %>
  <%@ page import="com.agenzia.Wanderlust.entities.*" %>
  <% List<Log> l= (List<Log>) request.getAttribute("log");%>
<!DOCTYPE html>
<html>
	<head>
		<title>LOG</title>
	</head>
	<body>
		<form name="inserimento">
			<table>
					<tr>
						<td>
						Inserisci testo:
						</td>
						<td>
							<input type="text" id="text-box" name="testo">
						</td>
					</tr>
					<tr>
						<td>
							Inserisci data:
						</td>
						<td>
							<input type="date" id="date-box" name="data">
						</td>
					</tr>
					<tr>
						<td>
							<a href="Enter"> <button type="button">Invia</button> </a> 
						</td>
					</tr>
				</table>
		</form>
	
		<div>
			<table class="log">
				<% for (Log x : l){%>
					<tr>
						<td>
							<%= x.getId() %>
						</td>
						<td>
							<%= x.getMex() %>	
						</td>
						<td>
							<%= x.getData() %>
						</td>
					</tr>						
				<%}%>
			</table>	
	    </div>
	</body>
</html>