<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Trasporto" %>
<%@ page import="com.agenzia.Wanderlust.entities.Compagnia" %>
<%@ page import="com.agenzia.Wanderlust.entities.Mezzo" %>
<%	Map<String,String> trasporto = (Map<String,String>) request.getAttribute("trasporto"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettagli trasporto</title>

<link rel="stylesheet" href="/stile/elenco.css">
    </head>
    <body>
        <h2>DETTAGLI TRASPORTI</h2>
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

            <th><h1>Nome Trasporto</h1></th>
            <th><h1>Totale Posti</h1></th>
            <th><h1>Tipo</h1></th>
            <th><h1>Prezzo Base</h1></th>
            <th><h1>Nome Compagnia</h1></th>
            <th><h1>Supplemento Compagnia</h1></th>
            <th><h1>Setting</h1></th>
        </tr>
    </thead>
    <tbody>

        <tr>

                        <td>
                             <%=trasporto.get("nome trasporto") %>
                        </td>
                        <td>
                             <%=trasporto.get("posti totali") %>
                        </td>
                        <td>
                          	 <%=trasporto.get("tipo mezzo") %>
					       	 <%=trasporto.get("idmezzo")%>
                        </td>
                        <td>
                             <%=trasporto.get("prezzo base mezzo") %>
                        </td>
                        <td>
                             <%=trasporto.get("nome compagnia") %>
                        </td>
                        <td>
                             <%=trasporto.get("supplemento compagnia") %> %
                        </td>
                        


                        <td>
                             <button><a href="formmodifica?nome=<%=trasporto.get("nome") %>"  style="text-decoration: none; color: white;">Modifica</a></button>

                        </td>

            </tr>

    </tbody>
</table>

    </body>


</html>