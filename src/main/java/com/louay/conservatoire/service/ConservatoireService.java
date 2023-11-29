package com.louay.conservatoire.service;

import java.util.List;


import com.louay.conservatoire.entitites.Band;
import com.louay.conservatoire.entitites.Musicien;



public interface ConservatoireService {
	Musicien saveMusicien(Musicien m);
	Musicien updateMusicien(Musicien m);
	void deleteMusicien(Musicien m);
	void deleteMusicienById(Long id);
	Musicien getMusicien(Long id);
	List<Musicien> getAllMusicien();
	List<Musicien> findByNomMusicien(String nom);
	List<Musicien> findByNomMusicienContains(String nom);
	List<Musicien> findByNomInstrument (String nom, String instru);
	List<Musicien> findByBand (Band band);
	List<Musicien> findByBandIdBand(Long id);
	List<Musicien> findByOrderByNomMusicientAsc();
	List<Musicien> trierMusiciensNomsSalaire();
	
}
