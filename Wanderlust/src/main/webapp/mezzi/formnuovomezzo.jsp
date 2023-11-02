<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>MEZZI</title>
	<link rel="stylesheet" href="/stile/formmodifica.css">
	</head>
	<body>
		<h2>AGGIUNGI MEZZI</h2>
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
			
			<th><h1>Tipo</h1></th>
			<th><h1>Prezzo</h1></th>				
			<th><h1>Setting</h1></th>
		</tr>
	</thead>
	<tbody>
		
	
		<tr>

						<td>
					       <input type="text" placeholder="Inserisci il tuo mezzo" name= "tipo">
						</td>
						<td>
							<input type="text" placeholder="Inserisci prezzo" name="prezzoBase">
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
</html>