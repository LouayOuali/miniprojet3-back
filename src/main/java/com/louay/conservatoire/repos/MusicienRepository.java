package com.louay.conservatoire.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.louay.conservatoire.entitites.Band;
import com.louay.conservatoire.entitites.Musicien;

@RepositoryRestResource(path = "rest")
public interface MusicienRepository extends JpaRepository <Musicien, Long>{
	List<Musicien> findByNomMusicien(String nom);
	List<Musicien> findByNomMusicienContains(String nom);
	
	@Query("select m from Musicien m where m.nomMusicien like %?1 and m.instrument like %?2") 
	List<Musicien> findByNomInstrument (String nom, String instrument);
	
	@Query("select m from Musicien m where m.band = ?1") 
	List<Musicien> findByBand (Band band);
	
	List<Musicien> findByBandIdBand(Long id);
	
	List<Musicien> findByOrderByNomMusicienAsc();
	
	@Query("select m from Musicien m order by m.nomMusicien ASC, m.salaire DESC")
	List<Musicien> trierMusiciensNomsSalaire ();
}
