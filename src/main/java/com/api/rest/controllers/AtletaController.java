package com.api.rest.controllers;

import com.api.rest.domain.Atleta;
import com.api.rest.domain.MedalType;
import com.api.rest.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.groupingBy;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@CrossOrigin (origins = "http://localhost:63342")
@RestController
@RequestMapping("/atletas")
public class AtletaController {

	@Autowired
	AtletaRepository atletaRepository;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Atleta createPlayer (@RequestBody Atleta atleta) {
		return atletaRepository.save(atleta);
	}

	@GetMapping
	public List<Atleta> getAtletas () {
		return atletaRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAtleta(@PathVariable Long id) {
		atletaRepository.delete(id);
	}

	@PutMapping("/update")
	public Atleta updateAtleta(@RequestBody Atleta atleta) {
		return atletaRepository.save(atleta);
	}

	// Devolver atletas según nacionalidad
	@GetMapping("/nationality/{nacionalidad}")
	public List<Atleta> getAtletasByNationality(@PathVariable String nacionalidad) {
		return atletaRepository.findAtletasByNacionalidadEquals(nacionalidad);
	}

	// Devolver todos los atletas que sean menor a la fecha por parametro
	@GetMapping("/birthdate/{date}")
	public List<Atleta> getAtletaByBirthDateLowerThan(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
		return atletaRepository.findAtletasByFechaNacimientoBefore(date);
	}

	// Devolver todos los atletas agrupados por nacionalidad
	@GetMapping("/groupedByNationality")
	public Map<String, List<Atleta>> getAtletasByPais() {

		return atletaRepository
						.findAll()
						.parallelStream()
						.collect(groupingBy(Atleta::getNacionalidad));

	}


	@GetMapping("/groupedByMedallas")
	public Map<MedalType, List<Atleta>> getAtletasGroupedByMedallas () {

			return atletaRepository
					.findAll()
					.parallelStream()
					.collect(groupingBy(atleta -> {
						if (atleta.getMedalla().stream().anyMatch(medalla -> medalla.getTiposMedalla() == MedalType.ORO)) {
							return MedalType.ORO;
						}else if (atleta.getMedalla().stream().anyMatch(medalla -> medalla.getTiposMedalla() == MedalType.PLATA)){
							return MedalType.PLATA;
						}else if (atleta.getMedalla().stream().anyMatch(medalla -> medalla.getTiposMedalla() == MedalType.BRONCE)){
							return MedalType.BRONCE;
						} else {
							return MedalType.NONE;
						}
					}));
	}




}
