package com.api.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Atleta {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String apellido;
	private String nacionalidad;

	@JsonIgnore
	private LocalDate fechaNacimiento;



	@OneToMany(mappedBy = "atleta")
	@JsonIgnore
	private Set<Medalla> medalla = new HashSet<>();

	public Atleta () {

	}

	public Atleta(String nombre, String apellido, String nacionalidad, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<Medalla> getMedalla () {
		return medalla;
	}

	public void setMedalla(Set<Medalla> medalla) {
		this.medalla   = medalla;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Atleta atleta = (Atleta) o;

		if (id != atleta.id) return false;
		if (nombre != null ? !nombre.equals(atleta.nombre) : atleta.nombre != null) return false;
		if (apellido != null ? !apellido.equals(atleta.apellido) : atleta.apellido != null) return false;
		if (nacionalidad != null ? !nacionalidad.equals(atleta.nacionalidad) : atleta.nacionalidad != null) return false;
		return fechaNacimiento != null ? fechaNacimiento.equals(atleta.fechaNacimiento) : atleta.fechaNacimiento == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
		result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
		result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
		result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
		return result;
	}


	@Override
	public String toString() {
		return "Atleta{" +
						"id=" + id +
						", nombre='" + nombre + '\'' +
						", apellido='" + apellido + '\'' +
						", nacionalidad='" + nacionalidad + '\'' +
						", fechaNacimiento=" + fechaNacimiento +
						'}';
	}


}
