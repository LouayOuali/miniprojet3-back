package com.louay.conservatoire.entitites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Band {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBand;
	private String nomBand;
	
	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<Musicien> membres;


	public Band(String nomBand, List<Musicien> membres) {
		super();
		this.nomBand = nomBand;
		this.membres = membres;
	}



	public Band() {
		super();
	}
	
	

}
