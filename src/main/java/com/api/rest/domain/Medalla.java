package com.api.rest.domain;


import javax.persistence.*;

@Entity
public class Medalla {

	@Id
	@GeneratedValue
	private long id;

	@Enumerated(EnumType.STRING)
	private MedalType tiposMedalla;
	private String especialidad;
	private String competicion;

	@ManyToOne
	private Atleta atleta;

	public Medalla(MedalType tiposMedalla, String especialidad, String competicion) {
		this.tiposMedalla = tiposMedalla;
		this.especialidad = especialidad;
		this.competicion = competicion;
	}

	public Medalla () {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MedalType getTiposMedalla() {
		return tiposMedalla;
	}

	public void setTiposMedalla(MedalType tiposMedalla) {
		this.tiposMedalla = tiposMedalla;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCompeticion() {
		return competicion;
	}

	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Medalla medalla = (Medalla) o;

		if (id != medalla.id) return false;
		if (tiposMedalla != medalla.tiposMedalla) return false;
		if (especialidad != null ? !especialidad.equals(medalla.especialidad) : medalla.especialidad != null) return false;
		if (competicion != null ? !competicion.equals(medalla.competicion) : medalla.competicion != null) return false;
		return atleta != null ? atleta.equals(medalla.atleta) : medalla.atleta == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (tiposMedalla != null ? tiposMedalla.hashCode() : 0);
		result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
		result = 31 * result + (competicion != null ? competicion.hashCode() : 0);
		result = 31 * result + (atleta != null ? atleta.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Medalla{" +
						"id=" + id +
						", tiposMedalla=" + tiposMedalla +
						", especialidad='" + especialidad + '\'' +
						", competicion='" + competicion + '\'' +
						", atleta=" + atleta +
						'}';
	}
}
