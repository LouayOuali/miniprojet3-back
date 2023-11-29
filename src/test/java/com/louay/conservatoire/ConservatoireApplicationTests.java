package com.louay.conservatoire;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.louay.conservatoire.entitites.Musicien;
import com.louay.conservatoire.repos.MusicienRepository;
import com.louay.conservatoire.entitites.Band;

@SpringBootTest
class ConservatoireApplicationTests {

	@Autowired
	private MusicienRepository musicienRepository;

	@Test
	public void testCreateMusicien() {
		Musicien mus = new Musicien("Youssef", "Violon", 1300.00, 6);
		musicienRepository.save(mus);
	}

	@Test
	public void testFindMusicien() {
		Musicien m = musicienRepository.findById(1L).get();
		System.out.println(m);
	}

	@Test
	public void testUpdateMusicien() {
		Musicien m = musicienRepository.findById(1L).get();
		m.setSalaire(1000.0);
		musicienRepository.save(m);
	}

	@Test
	public void testDeleteMusicien() {
		musicienRepository.deleteById(2L);
		;
	}

	@Test
	public void testListerTousMusiciens() {
		List<Musicien> musiciens = musicienRepository.findAll();
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByNomMusicien() {
		List<Musicien> musiciens = musicienRepository.findByNomMusicien("Louay Ouali");
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByNomMusicienContains() {
		List<Musicien> musiciens = musicienRepository.findByNomMusicienContains("Louay");
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByNomInstrument() {
		List<Musicien> musiciens = musicienRepository.findByNomInstrument("Louay Ouali", "Guitar");
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByBand() {
		Band band = new Band();
		band.setIdBand(1L);
		List<Musicien> musicien = musicienRepository.findByBand(band);
		for (Musicien p : musicien) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByBandIdBand() {
		List<Musicien> musiciens = musicienRepository.findByBandIdBand(1L);
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testFindByOrderByNomMusicienAsc() {
		List<Musicien> musiciens = musicienRepository.findByOrderByNomMusicienAsc();
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}

	@Test
	public void testTrierMusiciensNomsSalaire() {
		List<Musicien> musiciens = musicienRepository.trierMusiciensNomsSalaire();
		for (Musicien m : musiciens) {
			System.out.println(m);
		}
	}
}
