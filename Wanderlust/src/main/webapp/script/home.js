
 function login() 
 {
	 var username= inserimento.username.value;
	 var password= inserimento.password.value;
	 
  if (username === ""  || password === "")	
   		inserimento.bottone.disabled= true;
   	else
   	   	inserimento.bottone.disabled= false;

}

