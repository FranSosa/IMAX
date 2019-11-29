package com.dtecimax.jpa.dto.ar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ALERGIAS_PACIENTES database table.
 * 
 */
@Entity
@Table(name="ALERGIAS_PACIENTES")
@NamedQuery(name="AlergiasPacientesDto.findAll", query="SELECT a FROM AlergiasPacientesDto a")
public class AlergiasPacientesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_ALERGIA")
	private long numeroAlergia;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="NOMBRE_ALERGIA")
	private String nombreAlergia;

	public AlergiasPacientesDto() {
	}

	public long getNumeroAlergia() {
		return this.numeroAlergia;
	}

	public void setNumeroAlergia(long numeroAlergia) {
		this.numeroAlergia = numeroAlergia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreAlergia() {
		return this.nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

}