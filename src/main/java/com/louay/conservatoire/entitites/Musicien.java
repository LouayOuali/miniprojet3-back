package com.louay.conservatoire.entitites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data

@Entity
public class Musicien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMusicien;
	private String nomMusicien;
	private String instrument;
	private double salaire;
	private int experienceYear;
	
	/*@OneToOne
	private Image image; */
	
	@OneToMany (mappedBy = "musicien")
	 private List<Image> images;
	 
	 private String imagePath;
	
	@ManyToOne
	private Band band;
	
	public Musicien(String nomMusicien, String instrument, double salaire, int experienceYear) {
		super();
		this.nomMusicien = nomMusicien;
		this.instrument = instrument;
		this.salaire = salaire;
		this.experienceYear = experienceYear;
	}

	@Override
	public String toString() {
		return "Musicien [idMusicien=" + idMusicien + ", nomMusicien=" + nomMusicien + ", instrument=" + instrument
				+ ", salaire=" + salaire + ", experienceYear=" + experienceYear + "]";
	}

	public Musicien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

}


