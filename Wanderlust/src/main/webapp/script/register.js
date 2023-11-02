function register() 
{
	//Info: https://alvarotrigo.com/blog/disable-button-javascript/
	if(controlla())
	{
		//ABILITATO
		document.querySelector('#partofdafamily').disabled = false;
	}
	else
	{
		//DISABILITATO
		document.querySelector('#partofdafamily').disabled = true;
	}
}

function controlla()
{
	var nome= inserimento.nome.value;
	var cognome= inserimento.cognome.value;
	var codiceFiscale= inserimento.codiceFiscale.value;
	var username= inserimento.username.value;
	var email= inserimento.email.value;
	var password= inserimento.password.value;
	
	var ris = false;
	if(	nome !== "" 			&&
		cognome !== ""  		&& 
		codiceFiscale !== ""  	&& 
		username !== ""  		&& 
		email !== ""  			&& 
		password !== ""			)
			ris = true;
	console.log("Controlla: " + ris);
	return ris;
}

function laviamolemani()
{
	var inputs = inserimento.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++)
	{
		console.log(inputs[i].type);
		/* 	Se il type dell'input Ã¨ diverso da submit e diverso da button
			imposta il suo valore a ""; In questo modo non cancella i valori
			dei pulsanti della form ;-)
		*/
		if(inputs[i].type != "submit" && inputs[i].type != "button")
			inputs[i].value = "";
	}
	console.log("DAJE!");
}