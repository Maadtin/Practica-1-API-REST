package com.api.rest.repositories;

import com.api.rest.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AtletaRepository extends JpaRepository<Atleta, Long>{


	List<Atleta> findAtletasByNacionalidadEquals(String nacionalidad);

	List<Atleta> findByFechaNacimientoBefore(LocalDate date);

	Atleta findAtletaByNombre(String nombre);

	// Devolver atletas agrupados por nacionalidad: Ejemplo ->
	// España   Francia
	// - Diego  - Angelo
	// - Martin - Rusty







}
