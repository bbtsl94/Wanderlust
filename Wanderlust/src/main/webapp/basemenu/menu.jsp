<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Persona" %>
<% Persona p = (Persona) request.getAttribute("persona");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="../stile/menu.css">
</head>
<body>
<div><h1>Wanderlust</h1></DIV>
<p>
<select onChange="Menu(this)">
<option value="menu.html">Menu</option>
<option value="dettaglipersona.jsp">Il mio account</option>
<option value="elencoviaggi.jsp">I miei viaggi</option>
<option value="?">Voucher regalo</option>
<option value="?">Contatta assistenza</option>
<option value="home.html">Logout</option>
</select>
</p>
 <%= p.getUsername() %>
</body>
</html>