package com.api.rest.services;

import com.api.rest.domain.Atleta;
import com.api.rest.domain.MedalType;
import com.api.rest.domain.Medalla;
import com.api.rest.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtletaService {

	@Autowired
	AtletaRepository atletaRepository;
//
	public void testAtleta () {
//
		Atleta martin = new Atleta("Martin", "Hernández", "España", LocalDate.of(1995, 7, 28));
		Atleta rusty = new Atleta("Rusty", "Gallardo", "Filipinas", LocalDate.of(2016, 7, 28));

//
		atletaRepository.save(martin);
		atletaRepository.save(rusty);
//
//
//		System.out.println("Atletas por nacionalidad");
//		System.out.println(atletaRepository.findAtletasByNacionalidadEquals("España")); ;


	}


}
