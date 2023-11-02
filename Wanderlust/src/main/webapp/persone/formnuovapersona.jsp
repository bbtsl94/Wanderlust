<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Persone</title>
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>AGGIUNGI Persone</h2>
		<br>

		<div class="page">
		<nav class="page__menu menu">
			<ul class="menu__list r-list">
				<li><a href="elenco" class="menu__link r-link text-underlined">Indietro</a></li>
				<li><a href="/sessione/menu" class="menu__link r-link text-underlined">Menu</a></li>
				<li><a href="/sessione/exit" class="menu__link r-link text-underlined">Exit</a></li>
			</ul>
		</nav>
	</div>
	<br>	
			
	<form name="inserimento" action="aggiungi" method="post">
	<table class="container">
		<thead>
		 	<tr>
			
			<th><h1>Nome e Cognome</h1></th>
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
							 <input type="text" placeholder="Inserisci Dati" name = "nominativo">
						</td>
						<td>
							<input type="text" placeholder="Inserisci Cf" name = "cf">
						</td>
						<td>
							<input type="date"  name="dob">
						</td>
						<td>
							<input type="text" placeholder="Inserisci Username" name ="username">
						</td>
						<td>
							<input type="text" placeholder="Inserisci password" name ="password">
						</td>
						<td>
							<input type="text" placeholder="Inserisci email" name = "email">
						</td>
						
						<td>
							 <button type="submit">Aggiungi</button>
							
						</td>
						
			</tr>	
	</tbody>
	</table>
	</form>
	</body>
	
</html>
