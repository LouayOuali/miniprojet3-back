package com.louay.conservatoire.restcontrollers;

import com.louay.conservatoire.entitites.Band;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.louay.conservatoire.repos.BandRepository;

@RestController
@RequestMapping("/api/band")
@CrossOrigin("*")
public class BandRESTController {
	
	@Autowired
	BandRepository bandRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Band> getAllBands() {
		return bandRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Band getBandById(@PathVariable("id") Long id) {
		return bandRepository.findById(id).get();
	}
	
}
