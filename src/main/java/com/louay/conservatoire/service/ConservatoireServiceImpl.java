package com.louay.conservatoire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louay.conservatoire.entitites.Band;
import com.louay.conservatoire.entitites.Musicien;
import com.louay.conservatoire.repos.MusicienRepository;

@Service
public class ConservatoireServiceImpl implements ConservatoireService {

	@Autowired
	MusicienRepository mr;

	@Override
	public Musicien saveMusicien(Musicien m) {
		return mr.save(m);
	}

	@Override
	public Musicien updateMusicien(Musicien m) {
		return mr.save(m);
	}

	@Override
	public void deleteMusicien(Musicien m) {
		mr.delete(m);
	}

	@Override
	public void deleteMusicienById(Long id) {
		mr.deleteById(id);
	}

	@Override
	public Musicien getMusicien(Long id) {
		return mr.findById(id).get();
	}

	@Override
	public List<Musicien> getAllMusicien() {
		return mr.findAll();
	}

	@Override
	public List<Musicien> findByNomMusicien(String nom) {
		return mr.findByNomMusicien(nom);
	}

	@Override
	public List<Musicien> findByNomMusicienContains(String nom) {
		return mr.findByNomMusicienContains(nom);
	}

	@Override
	public List<Musicien> findByNomInstrument(String nom, String instru) {
		return mr.findByNomInstrument(nom, instru);
	}

	@Override
	public List<Musicien> findByBand(Band band) {
		return mr.findByBand(band);
	}

	@Override
	public List<Musicien> findByBandIdBand(Long id) {
		return mr.findByBandIdBand(id);
	}

	@Override
	public List<Musicien> findByOrderByNomMusicientAsc() {
		return mr.findByOrderByNomMusicienAsc();
	}

	@Override
	public List<Musicien> trierMusiciensNomsSalaire() {
		return mr.trierMusiciensNomsSalaire();
	}

}
