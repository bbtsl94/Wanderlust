<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.agenzia.Wanderlust.entities.Viaggio" %>
<%@ page import="com.agenzia.Wanderlust.entities.Luogo" %>
<%@ page import="com.agenzia.Wanderlust.entities.Motivazione" %>
<%@ page import="com.agenzia.Wanderlust.entities.Mezzo" %>
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %>

<% Luogo luogoPartenza = (Luogo) request.getAttribute("luogoPartenza");%>
<% Luogo luogoArrivo = (Luogo) request.getAttribute("luogoArrivo");%>
<% Viaggio viaggio = (Viaggio) request.getAttribute("viaggio");%>
<% Motivazione motivo = (Motivazione) request.getAttribute("motivo"); %>
<% Mezzo mezzo = (Mezzo) request.getAttribute("mezzo");%>
<% Trasporto trasporto = (Trasporto) request.getAttribute("trasporto");%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dettagli viaggio</title>
	<link rel="stylesheet" href="/stile/elenco.css">
    </head>
    <body>
        <h2>DETTAGLI VIAGGIO</h2>
        <br>

        <div class="page">
        <nav class="page__menu menu">
            <ul class="menu__list r-list">
                <li><a href="elenco"  class="menu__link r-link text-underlined">Indietro</a></li>
                <li><a href="/sessione/menu" class="menu__link r-link text-underlined">Menu</a></li>
                <li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
            </ul>
        </nav>
    </div>
    <br>
<table class="container">
    <thead>
         <tr>

            <th><h1>Luogo partenza</h1></th>
            <th><h1>Luogo arrivo</h1></th>
            <th><h1>Data di partenza</h1></th>
            <th><h1>Ora di partenza</h1></th>
            <th><h1>Data di arrivo</h1></th>
            <th><h1>Ora di arrivo</h1></th>
            <th><h1>Nome trasporto</h1></th>
            <th><h1>Mezzo di trasporto</h1></th>
            <th><h1>Prezzo</h1></th>
            <th><h1>Classe</h1></th>
            <th><h1>Disponibile</h1></th>
            <th><h1>Cancellato</h1></th>
            <th><h1>Setting</h1></th>
        </tr>
    </thead>
    <tbody>

        <tr>

                        <td>
                            <%= luogoPartenza.getName()%>
                        </td>
                        <td>
                            <%= luogoArrivo.getName()%>
                        </td>
                        <td>
                            <%= viaggio.getOraPartenza().toLocalDate().toString()%>
                        </td>
                        <td>
                           <%=  viaggio.getOraPartenza().toLocalTime().toString()%>
                        </td>
                        <td>
                            <%= viaggio.getOraArrivo().toLocalDate().toString()%>
                        </td>
                        <td>
                            <%= viaggio.getOraArrivo().toLocalTime().toString()%>
                        </td>
                        <td>
                            <%= trasporto.getNome()%>
                        </td>
                        <td>
                            <%= mezzo.getTipo()%>
                        </td>
                        <td>
                            <%= viaggio.getPrezzo()%>
                        </td>
                        <td>
                            <%= viaggio.getClasse()%>
                        </td>
                        <td>
                            <%= viaggio.isDisponibile() ? "Si" : "No" %>
                        </td>
                        <td>
                            <% if (viaggio.isCancellato()) {%>
				 		      <%= motivo.getMotivo()%>
					        <%} else {%>
						         No
					           <%}%>	
                        </td>


                        <td>
                             <button><a href="formmodifica?id=<%= viaggio.getId()%>"  style="text-decoration: none; color: white;">Modifica</a></button>

                        </td>

            </tr>

    </tbody>
</table>

    </body>
		
</html>