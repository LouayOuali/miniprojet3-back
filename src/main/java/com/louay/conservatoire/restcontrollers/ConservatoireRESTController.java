package com.louay.conservatoire.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.louay.conservatoire.entitites.Musicien;
import com.louay.conservatoire.service.ConservatoireService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class ConservatoireRESTController {

	@Autowired(required = true)
	ConservatoireService cs;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Musicien> getAllMusicien() {
		return cs.getAllMusicien();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Musicien getMusicienById(@PathVariable("id") Long id) {
		return cs.getMusicien(id);
	}

	@RequestMapping(value="/addMus",method = RequestMethod.POST)
	public Musicien createMusicien(@RequestBody Musicien musicien) {
		return cs.saveMusicien(musicien);
	}

	@RequestMapping(value="/updateMus",method = RequestMethod.PUT)
	public Musicien updateMusicien(@RequestBody Musicien produit) {
		return cs.updateMusicien(produit);
	}

	@RequestMapping(value = "/delMus/{id}", method = RequestMethod.DELETE)
	public void deleteMusicien(@PathVariable("id") Long id) {
		cs.deleteMusicienById(id);
	}

	@RequestMapping(value = "/bands/{idBand}", method = RequestMethod.GET)
	public List<Musicien> findByBandIdBand(@PathVariable("idBand") Long idBand) {
		return cs.findByBandIdBand(idBand);
	}

	@RequestMapping(value = "/musByName/{nom}", method = RequestMethod.GET)
	public List<Musicien> findByNomMusicienContains(@PathVariable("nom") String nom) {
		return cs.findByNomMusicienContains(nom);
	}
}
