<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.*" %>
<% Persona persona = (Persona) request.getAttribute("persona");%>
<% Compagnia compagnia = (Compagnia) request.getAttribute("compagnia");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Menu</title>
	<link rel="stylesheet" href="/stile/menu.css">
</head>
	<body>
		<div class="page  ">
		  <nav class="page__menu menu">
		    <ul class="menu__list r-list">
		      <li class="menu__group">
		      	<div class="dropdown ">
		      		<a href = "/persone/dettaglio?cf=<%= persona.getCf() %>"style="color: var(--rLinkColor) !important; text-decoration: var(--rLinkTextDecoration, none) !important" class="menu__link r-link text-underlined">Profilo</a>
		      		<div class=" dropdown-options">
				  		<a href = "/persone/dettaglio?cf=<%= persona.getCf() %>" style="color: var(--rLinkColor) !important;text-decoration: var(--rLinkTextDecoration, none) !important" class="menu__link r-link text-underlined"><%= persona.getCf() %></a>
				    	<a href="/sessione/exit" class="menu__link r-link text-underlined">Logout</a>
				   	</div>
				</div>
			  </li>
		      <li class="menu__group"><a href="/viaggi/cerca" class="menu__link r-link text-underlined">Cerca viaggi</a></li>
		      <li class="menu__group"><a href="/biglietti/imieiviaggi" class="menu__link r-link text-underlined">I miei viaggi</a></li>	  
		    </ul>
		  </nav>
		</div>
	</body>
</html>