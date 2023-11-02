package com.agenzia.Wanderlust.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.agenzia.Wanderlust.Dao.*;
import com.agenzia.Wanderlust.entities.Biglietto;
import com.agenzia.Wanderlust.entities.Luogo;
import com.agenzia.Wanderlust.entities.Persona;
import com.agenzia.Wanderlust.entities.Viaggio;

@Controller
@RequestMapping("/biglietti")
public class BigliettiController
{
	private static final String PREFISSO = "/biglietti/";
	
	@Autowired
	private DaoBiglietto daoBiglietto;
	
	@Autowired
	private DaoPersona daoPersona;
	
	@Autowired
	private DaoViaggio daoViaggio;
	
	@Autowired
	private DaoLuogo daoLuogo;
	
	//creazione di elencobiglietti.jsp
	@GetMapping("elenco")
	public String elencoBiglietti(Model model , HttpSession sessione) 
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		model.addAttribute("biglietti",daoBiglietto.readMList("  select distinct  b.id as idBiglietto,\n"
															+ "		b.cf as CF,\n"
															+ "		b.prezzo as Prezzo,\n"
															+ "		info.Partenza as Partenza,\n"
															+ "		info.Arrivo as Arrivo,\n"
															+ "		info.Trasporto as Trasporto,\n"
															+ "		info.OraPartenza as OraPartenza,\n"
															+ "		info.OraArrivo as OraArrivo,\n"
															+ "		info.Classe as Classe,\n"
															+ "		info.Cancellato as Cancellato\n"
															+ "\n"
															+ "from 	biglietti b inner join \n"
															+ "( \n"
															+ "	select  v.id as IdViaggio,\n"
															+ "			Partenza.Nome as Partenza,\n"
															+ "			Arrivo.Nome as Arrivo ,\n"
															+ "			v.idTrasporto as Trasporto,\n"
															+ "			v.oraP as OraPartenza,\n"
															+ "			v.oraA as OraArrivo,\n"
															+ "			v.classe as Classe ,\n"
															+ "			v.cancellato as Cancellato\n"
															+ "\n"
															+ "from\n"
															+ "	(\n"
															+ "		select l.id as id , l.nome as nome \n"
															+ "		from luoghi l inner join viaggi v \n"
															+ "			 on v.idPartenza=l.id\n"
															+ "    ) as Partenza,\n"
															+ "\n"
															+ "    (\n"
															+ "		select l.id as id , l.nome as nome \n"
															+ "        from luoghi l inner join viaggi v\n"
															+ "            on v.idArrivo=l.id\n"
															+ "    ) as Arrivo, viaggi v \n"
															+ "    where Partenza.id=v.idPartenza and Arrivo.id=v.idArrivo\n"
															+ ")as info\n"
															+ "on info.IdViaggio = b.idViaggio;"));
		return PREFISSO + "elencobiglietti.jsp"; 
	}
	
	//cancellazione di un biglietto
	@GetMapping("elimina")
	public String elimina(@RequestParam("id") int idBiglietto , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		daoBiglietto.delete(idBiglietto);
		return "redirect:elenco";
	}
	
	
	@GetMapping("formnuovo")
	public String formNuovoBiglietto(Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		List<Persona> persone = daoPersona.readAll();
		List<Map<String, String>> datiViaggi = new ArrayList<Map<String, String>>();
		Map<String, String> datiViaggio;
		Luogo partenza;
		Luogo arrivo;
		for (Viaggio viaggio : daoViaggio.readAll())
		{
			datiViaggio = new HashMap<String, String>();
			datiViaggio.put("id", Integer.toString(viaggio.getId()));
			partenza = daoLuogo.cercaLuogo(viaggio.getIdLuogoPartenza());
			arrivo = daoLuogo.cercaLuogo(viaggio.getIdLuogoArrivo());
			datiViaggio.put("partenza", partenza.getName());
			datiViaggio.put("arrivo", arrivo.getName());
			datiViaggi.add(datiViaggio);
		}
		model.addAttribute("persone", persone);
		model.addAttribute("viaggi", datiViaggi);
		return PREFISSO + "formnuovobiglietto.jsp";
	}
	
	//aggiungiamo un biglietto
	@PostMapping("aggiungi")
	public String aggiungi(@RequestParam Map<String,String> m , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		if(daoBiglietto.create(m))
			return "redirect:elenco";
		else
			return m + "non è stato possibile aggiungere il biglietto";
	}
	
	//dettaglio di biglietto
	@GetMapping("dettaglio")
	public String dettaglio(@RequestParam("id") int idBiglietto , Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		Map<String, String > b= daoBiglietto.readM("select  b.id as idBiglietto,\n"
										+ "		b.cf as CF,\n"
										+ "		b.prezzo as Prezzo,\n"
										+ "		info.Partenza as Partenza,\n"
										+ "		info.Arrivo as Arrivo,\n"
										+ "		info.Trasporto as Trasporto,\n"
										+ "		info.OraPartenza as OraPartenza,\n"
										+ "		info.OraArrivo as OraArrivo,\n"
										+ "		info.Classe as Classe,\n"
										+ "		info.Cancellato as Cancellato\n"
										+ "\n"
										+ "from 	biglietti b inner join \n"
										+ "( \n"
										+ "	select  v.id as IdViaggio,\n"
										+ "			Partenza.Nome as Partenza,\n"
										+ "			Arrivo.Nome as Arrivo ,\n"
										+ "			v.idTrasporto as Trasporto,\n"
										+ "			v.oraP as OraPartenza,\n"
										+ "			v.oraA as OraArrivo,\n"
										+ "			v.classe as Classe ,\n"
										+ "			v.cancellato as Cancellato\n"
										+ "\n"
										+ "from\n"
										+ "	(\n"
										+ "		select l.id as id , l.nome as nome \n"
										+ "		from luoghi l inner join viaggi v \n"
										+ "			 on v.idPartenza=l.id\n"
										+ "    ) as Partenza,\n"
										+ "\n"
										+ "    (\n"
										+ "		select l.id as id , l.nome as nome \n"
										+ "        from luoghi l inner join viaggi v\n"
										+ "            on v.idArrivo=l.id\n"
										+ "    ) as Arrivo, viaggi v \n"
										+ "    where Partenza.id=v.idPartenza and Arrivo.id=v.idArrivo\n"
										+ ")as info\n"
										+ "on info.IdViaggio = b.idViaggio\n"
										+ "where b.id= ? ;", idBiglietto + "");

		model.addAttribute("biglietto", b);
		return PREFISSO + "dettaglibiglietto.jsp";
	}
	
	//modifica Biglietto
	@GetMapping("formmodifica")
	public String formModificaBiglietto(@RequestParam("id") int idBiglietto, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		Biglietto biglietto = daoBiglietto.cercaBiglietto(idBiglietto);
		if(biglietto != null)
		{
			model.addAttribute("biglietto", biglietto);
			model.addAttribute("persone", daoPersona.readAll());
			return PREFISSO + "formmodificabiglietto.jsp";
		}
		else
			return "redirect:elenco";
	}
	
	@GetMapping("modifica")
	public String modifica(@RequestParam Map<String, String> dati , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		daoBiglietto.update(dati);
		return "redirect:elenco";
	}
	
	@GetMapping("imieiviaggi")
	public String elencomieiviaggi(HttpSession sessione, Model model )
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}
		Persona persona = (Persona)sessione.getAttribute("persona");
		List<Biglietto> biglietti = daoBiglietto.cercaPerCodiceFiscale(persona.getCf());
		List<Luogo> luoghi = daoLuogo.readAll();
		List<Viaggio> viaggi = new ArrayList<>();
		for (Biglietto biglietto : biglietti)
		{
			viaggi.add(daoViaggio.cercaPerID(biglietto.getIdViaggio()));
		}
		model.addAttribute("persona", persona);
		model.addAttribute("biglietti", biglietti);
		model.addAttribute("luoghi", luoghi);
		model.addAttribute("viaggi", viaggi);
		return "/cliente/imieiviaggi.jsp";
	}
	
	@GetMapping("dettagliimieiviaggi")
	public String dettagli(@RequestParam("id") int idBiglietto, Model model , HttpSession sessione)
	{
		if(sessione.getAttribute("connesso") == null)
		{
			return "redirect:/sessione/home";
		}

		Biglietto biglietto = daoBiglietto.cercaBiglietto(idBiglietto);
		Persona persona = daoPersona.cercaPersona(biglietto.getCf());
		Viaggio viaggio = daoViaggio.cercaPerID(biglietto.getIdViaggio());
		List<Luogo> luoghi = daoLuogo.readAll();
		model.addAttribute("biglietto", biglietto);
		model.addAttribute("persona", persona);
		model.addAttribute("viaggio", viaggio);
		model.addAttribute("luoghi", luoghi);
		return "/cliente/dettagliimieiviaggi.jsp";
	}
}
