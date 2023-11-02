<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.agenzia.Wanderlust.entities.Operatore" %>
<% Operatore o=(Operatore) request.getAttribute("operatore"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Operatore</title>

<link rel="stylesheet" href="/stile/elenco.css">
    </head>
    <body>
        <h2>DETTAGLI OPERATORE</h2>
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
            <th><h1>Id Compagnia</h1></th>
            <th><h1>Sconto</h1></th>
            <th><h1>Setting</h1></th>
        </tr>
    </thead>
    <tbody>

        <tr>

                        <td>
                             <%= o.getCf() %>
                        </td>
                        <td>
                            <%= o.getIdcompagnia() %>
                        </td>
                        <td>
                          <%= o.getSconto() %>
                        </td>


                        <td>
                             <button><a href="formmodifica?cf=<%=o.getCf() %>"  style="text-decoration: none; color: white;">Modifica</a></button>

                        </td>

            </tr>

    </tbody>
</table>

    </body>

</html>