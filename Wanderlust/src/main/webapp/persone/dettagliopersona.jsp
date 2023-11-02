
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.agenzia.Wanderlust.entities.Persona" %>
<% Persona p= (Persona) request.getAttribute("persona");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dettagli persona</title>

<link rel="stylesheet" href="/stile/elenco.css">
    </head>
    <body>
        <h2>DETTAGLI PERSONE</h2>
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

            <th><h1>Nominativo</h1></th>
            <th><h1>Codice Fiscale</h1></th>
            <th><h1>Data Nascita</h1></th>
            <th><h1>Username</h1></th>
            <th><h1>Password</h1></th>
            <th><h1>Email</h1></th>
            <th><h1>Setting</h1></th>
        </tr>
    </thead>
    <tbody>

        <tr>

                        <td>
                             <%= p.getNominativo() %>
                        </td>
                        <td>
                           <%= p.getCf() %>
                        </td>
                        <td>
                            <%= p.getDob() %>
                        </td>
                        <td>
                            <%= p.getUsername() %>
                        </td>
                        <td>
                           <%= p.getPassword() %>
                        </td>
                        <td>
                           <%= p.getEmail() %>
                        </td>


                        <td>
                             <button><a href="formmodifica?cf=<%= p.getCf() %>"  style="text-decoration: none; color: white;">Modifica</a></button>

                        </td>

            </tr>

    </tbody>
</table>

    </body>

</html>
