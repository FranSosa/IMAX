package com.dtecimax.jpa.dto.hr;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="DOCTORES_REFERENTES")
@NamedQuery(name="DoctoresReferentesDto.findAll", query="SELECT d FROM DoctoresReferentesDto d")
public class DoctoresReferentesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_DOCTOR_REFERENTE")
	private long numeroDoctorReferente;

	@Column(name="APELLIDO_MATERNO_DOCTOR_REFERENTE")
	private String apellidoMaternoDoctorReferente;

	@Column(name="APELLIDO_PATERNO_DOCTOR_REFERENTE")
	private String apellidoPaternoDoctorReferente;

	@Column(name="CEDULA_DOCTOR_REFERENTE")
	private String cedulaDoctorReferente;

	@Column(name="CELULAR_DOCTOR_REFERENTE")
	private String celularDoctorReferente;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="CORREO_DOCTOR_REFERENTE")
	private String correoDoctorReferente;

	@Column(name="CURP_DOCTOR_REFERENTE")
	private String curpDoctorReferente;

	@Column(name="DOMICILIO_DOCTOR_REFERENTE")
	private String domicilioDoctorReferente;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_NACIMIENTO_DOCTOR_REFERENTE")
	private Timestamp fechaNacimientoDoctorReferente;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NOMBRE_DOCTOR_REFERENTE")
	private String nombreDoctorReferente;

	@Column(name="AREA_DOCTOR_REFERENTE")
	private String areaDoctorReferente;
	
	@Column(name="LUGAR_TRABAJO")
	private String lugarTrabajo;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;


	public DoctoresReferentesDto() {
	}

	public long getNumeroDoctorReferente() {
		return this.numeroDoctorReferente;
	}

	public void setNumeroDoctorReferente(long numeroDoctorReferente) {
		this.numeroDoctorReferente = numeroDoctorReferente;
	}

	public String getApellidoMaternoDoctorReferente() {
		return this.apellidoMaternoDoctorReferente;
	}

	public void setApellidoMaternoDoctorReferente(String apellidoMaternoDoctorReferente) {
		this.apellidoMaternoDoctorReferente = apellidoMaternoDoctorReferente;
	}

	public String getApellidoPaternoDoctorReferente() {
		return this.apellidoPaternoDoctorReferente;
	}

	public void setApellidoPaternoDoctorReferente(String apellidoPaternoDoctorReferente) {
		this.apellidoPaternoDoctorReferente = apellidoPaternoDoctorReferente;
	}

	public String getCedulaDoctorReferente() {
		return this.cedulaDoctorReferente;
	}

	public void setCedulaDoctorReferente(String cedulaDoctorReferente) {
		this.cedulaDoctorReferente = cedulaDoctorReferente;
	}

	public String getCelularDoctorReferente() {
		return this.celularDoctorReferente;
	}

	public void setCelularDoctorReferente(String celularDoctorReferente) {
		this.celularDoctorReferente = celularDoctorReferente;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoDoctorReferente() {
		return this.correoDoctorReferente;
	}

	public void setCorreoDoctorReferente(String correoDoctorReferente) {
		this.correoDoctorReferente = correoDoctorReferente;
	}

	public String getCurpDoctorReferente() {
		return this.curpDoctorReferente;
	}

	public void setCurpDoctorReferente(String curpDoctorReferente) {
		this.curpDoctorReferente = curpDoctorReferente;
	}

	public String getDomicilioDoctorReferente() {
		return this.domicilioDoctorReferente;
	}

	public void setDomicilioDoctorReferente(String domicilioDoctorReferente) {
		this.domicilioDoctorReferente = domicilioDoctorReferente;
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

	public Timestamp getFechaNacimientoDoctorReferente() {
		return this.fechaNacimientoDoctorReferente;
	}

	public void setFechaNacimientoDoctorReferente(Timestamp fechaNacimientoDoctorReferente) {
		this.fechaNacimientoDoctorReferente = fechaNacimientoDoctorReferente;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombreDoctorReferente() {
		return this.nombreDoctorReferente;
	}

	public void setNombreDoctorReferente(String nombreDoctorReferente) {
		this.nombreDoctorReferente = nombreDoctorReferente;
	}


	public String getAreaDoctorReferente() {
		return this.areaDoctorReferente;
	}

	public void setAreaDoctorReferente(String areaDoctorReferente) {
		this.areaDoctorReferente = areaDoctorReferente;
	}
	
	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}




}