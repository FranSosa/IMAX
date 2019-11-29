package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * The persistent class for the CITAS database table.
 * 
 */
@Entity
@Table(name="CITAS")
@NamedQuery(name="CitasDto.findAll", query="SELECT c FROM CitasDto c")
public class CitasDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_CITA")
	private long numeroCita;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CITA")
	private Timestamp fechaCita;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="HORA_FINAL_CITA")
	private Time horaFinalCita;

	@Column(name="HORA_INICIAL_CITA")
	private Time horaInicialCita;

	@Column(name="NUMERO_DOCTOR")
	private long numeroDoctor;

	@Column(name="NUMERO_ESTUDIO")
	private long numeroEstudio;

	@Column(name="NUMERO_PACIENTE")
	private long numeroPaciente;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public CitasDto() {
	}

	public long getNumeroCita() {
		return this.numeroCita;
	}

	public void setNumeroCita(long numeroCita) {
		this.numeroCita = numeroCita;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Timestamp fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Time getHoraFinalCita() {
		return this.horaFinalCita;
	}

	public void setHoraFinalCita(Time horaFinalCita) {
		this.horaFinalCita = horaFinalCita;
	}

	public Time getHoraInicialCita() {
		return this.horaInicialCita;
	}

	public void setHoraInicialCita(Time horaInicialCita) {
		this.horaInicialCita = horaInicialCita;
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public long getNumeroEstudio() {
		return this.numeroEstudio;
	}

	public void setNumeroEstudio(long numeroEstudio) {
		this.numeroEstudio = numeroEstudio;
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

}