package com.louay.conservatoire.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.louay.conservatoire.entitites.Band;

@RepositoryRestResource(path = "band")
@CrossOrigin("http://localhost:4200/")
public interface BandRepository extends JpaRepository<Band, Long>{

	List<Band> findAll();
	
	
	
}
