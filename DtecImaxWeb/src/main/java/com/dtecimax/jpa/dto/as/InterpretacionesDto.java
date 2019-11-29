package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the INTERPRETACIONES database table.
 * 
 */
@Entity
@Table(name="INTERPRETACIONES")
@NamedQuery(name="InterpretacionesDto.findAll", query="SELECT i FROM InterpretacionesDto i")
public class InterpretacionesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_INTERPRETACION")
	private long numeroInterpretacion;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="INTERPRETACION")
	private String interpretacion;

	@Column(name="NUMERO_CITA")
	private long numeroCita;

	@Column(name="NUMERO_DOCTOR")
	private long numeroDoctor;

	@Column(name="NUMERO_ESTUDIO")
	private long numeroEstudio;

	@Column(name="NUMERO_ORDEN")
	private long numeroOrden;

	@Column(name="NUMERO_PACIENTE")
	private long numeroPaciente;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="TIPO_ORDEN")
	private short tipoOrden;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public InterpretacionesDto() {
	}

	public long getNumeroInterpretacion() {
		return this.numeroInterpretacion;
	}

	public void setNumeroInterpretacion(long numeroInterpretacion) {
		this.numeroInterpretacion = numeroInterpretacion;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
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

	public String getInterpretacion() {
		return this.interpretacion;
	}

	public void setInterpretacion(String interpretacion) {
		this.interpretacion = interpretacion;
	}

	public long getNumeroCita() {
		return this.numeroCita;
	}

	public void setNumeroCita(long numeroCita) {
		this.numeroCita = numeroCita;
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

	public long getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
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

	public short getTipoOrden() {
		return this.tipoOrden;
	}

	public void setTipoOrden(short tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

}