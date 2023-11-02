<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<% Map<String, String> biglietto = (Map<String, String>) request.getAttribute("biglietto");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettagli biglietto</title>
	
	<link rel="stylesheet" href="/stile/elenco.css">
    </head>
    <body>
        <h2>DETTAGLI BIGLIETTO</h2>
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

            <th><h1>Codice Fiscale</h1></th>
            <th><h1>Luogo Partenza</h1></th>
            <th><h1>Luogo Arrivo</h1></th>
            <th><h1>Data e ora di partenza</h1></th>
            <th><h1>Data e ora di arrivo</h1></th>
            <th><h1>Trasporto</h1></th>
            <th><h1>Classe</h1></th>
            <th><h1>Cancellato</h1></th>
            <th><h1>Setting</h1></th>
        </tr>
    </thead>
    <tbody>

        <tr>

                        <td>
                             <%= biglietto.get("cf") %>
                        </td>
                        <td>
                            <%= biglietto.get("partenza")%>
                        </td>
                        <td>
                            <%= biglietto.get("arrivo") %>
                        </td>
                         <td>
                           <%= biglietto.get("orapartenza") %>
                        </td>
                         <td>
                            <%= biglietto.get("oraarrivo") %>
                        </td>
                         <td>
                            <%= biglietto.get("trasporto") %>
                        </td>
                         <td>
                           <%= biglietto.get("classe") %>
                        </td>
                        <td>
                           <%= biglietto.get("cancellato").equals("1") ? "Si" : "No" %>
                        </td>


                        <td>
                             <button><a href="formmodifica?id=<%= biglietto.get("idbiglietto")%>"  style="text-decoration: none; color: white;">Modifica</a></button>

                        </td>

            </tr>

    </tbody>
</table>

    </body>	
</html>