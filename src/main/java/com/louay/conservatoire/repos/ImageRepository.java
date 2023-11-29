package com.louay.conservatoire.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louay.conservatoire.entitites.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}