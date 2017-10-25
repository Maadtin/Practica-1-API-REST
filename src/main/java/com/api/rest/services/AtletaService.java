package com.api.rest.services;

import com.api.rest.domain.Atleta;
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
		Atleta angelo = new Atleta("Angelo", "Danan", "Filipinas", LocalDate.of(2001, 7, 28));
		
//
		atletaRepository.save(martin);
		atletaRepository.save(rusty);
		atletaRepository.save(angelo);
		
		System.out.println("Jugadores que nacieron antes del 2005");
		System.out.println(atletaRepository.findByFechaNacimientoBefore(LocalDate.of(2005, 6, 28)));
//
//
//		System.out.println("Atletas por nacionalidad");
//		System.out.println(atletaRepository.findAtletasByNacionalidadEquals("España")); ;


	}


}
