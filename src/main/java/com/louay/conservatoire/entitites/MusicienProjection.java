package com.louay.conservatoire.entitites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMusicien", types = { Musicien.class })

public interface MusicienProjection {
	public String getNomMusicien();
}
