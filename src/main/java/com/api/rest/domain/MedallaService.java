package com.api.rest.domain;

import com.api.rest.repositories.AtletaRepository;
import com.api.rest.repositories.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedallaService {

	@Autowired
	AtletaRepository atletaRepository;

	@Autowired
	MedallaRepository medallaRepository;

	public void setMedallas () {
		Medalla medalla1 = new Medalla(MedalType.ORO, "eqwe", "eqweqw");
		medalla1.setAtleta(atletaRepository.findAtletaByNombre("Martin"));
		medallaRepository.save(medalla1);
	}




}
