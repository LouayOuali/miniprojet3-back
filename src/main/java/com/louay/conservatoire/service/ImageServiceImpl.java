package com.louay.conservatoire.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.louay.conservatoire.entitites.Image;
import com.louay.conservatoire.entitites.Musicien;
import com.louay.conservatoire.repos.ImageRepository;
import com.louay.conservatoire.repos.MusicienRepository;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {
	
	 @Autowired
	 ImageRepository imageRepository;


	 @Autowired
	 ConservatoireService conservatoireService;
	 
	 @Autowired
	 MusicienRepository musicienRepository;
	 
		@Override
		public Image uplaodImage(MultipartFile file) throws IOException {
			/*
			 * Ce code commenté est équivalent au code utilisant le design pattern Builder
			 * Image image = new Image(null, file.getOriginalFilename(),
			 * file.getContentType(), file.getBytes(), null);
			 *   return imageRepository.save(image);
			 */
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).build());
		}

		@Override
		public Image getImageDetails(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return Image.builder()
					.idImage(dbImage
					.get().getIdImage()).name(dbImage.get().getName())
					.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
		}

		@Override
		public ResponseEntity<byte[]> getImage(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
					.body(dbImage.get().getImage());
		}

		@Override
		public void deleteImage(Long id) {
			imageRepository.deleteById(id);
		}

		@Override
		public Image uplaodImageMus(MultipartFile file,Long idMus) 
		throws IOException {
				Musicien m = new Musicien();
				m.setIdMusicien(idMus);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .musicien(m).build() );
		}

		@Override
		public List<Image> getImagesParMus(Long musId) {
			Musicien m = musicienRepository.findById(musId).get();
				return m.getImages();
		}

		
		
		
		
		
	}