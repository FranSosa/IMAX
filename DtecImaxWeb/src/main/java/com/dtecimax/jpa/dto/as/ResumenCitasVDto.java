package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


/**
 * The persistent class for the RESUMEN_CITAS_V database table.
 * 
 */
@Entity
@Table(name="RESUMEN_CITAS_V")
@NamedQuery(name="ResumenCitasVDto.findAll", query="SELECT r FROM ResumenCitasVDto r")
public class ResumenCitasVDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="HORA_FINAL_CITA")
	private String horaFinalCita;

	@Column(name="HORA_INICIAL_CITA")
	private String horaInicialCita;

	@Column(name="NOMBRE_DOCTOR")
	private String nombreDoctor;

	@Id
	@Column(name="NUMERO_CITA")
	private long numeroCita;

	@Column(name="TIPO_ESTUDIO")
	private String tipoEstudio;
	
	@Column(name="NOMBRE_ESTUDIO")
	private String nombreEstudio;
	
	@Column(name="FECHA_CITA")
	private Date fechaCita;

	public ResumenCitasVDto() {
	}

	public String getHoraFinalCita() {
		return this.horaFinalCita;
	}

	public void setHoraFinalCita(String horaFinalCita) {
		this.horaFinalCita = horaFinalCita;
	}

	public String getHoraInicialCita() {
		return this.horaInicialCita;
	}

	public void setHoraInicialCita(String horaInicialCita) {
		this.horaInicialCita = horaInicialCita;
	}

	public String getNombreDoctor() {
		return this.nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public long getNumeroCita() {
		return this.numeroCita;
	}

	public void setNumeroCita(long numeroCita) {
		this.numeroCita = numeroCita;
	}

	public String getTipoEstudio() {
		return this.tipoEstudio;
	}

	public void setTipoEstudio(String tipoEstudio) {
		this.tipoEstudio = tipoEstudio;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getNombreEstudio() {
		return nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

}
