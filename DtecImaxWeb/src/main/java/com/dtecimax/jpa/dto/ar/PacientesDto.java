package com.dtecimax.jpa.dto.ar;

import java.io.Serializable;
import javax.persistence.*;

import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;

import java.sql.Timestamp;


/**
 * The persistent class for the PACIENTES database table.
 * 
 */
@Entity
@Table(name="PACIENTES")
@NamedQuery(name="PacientesDto.findAll", query="SELECT p FROM PacientesDto p")
public class PacientesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_PACIENTE")
	private long numeroPaciente;

	@Column(name="APELLIDO_MATERNO_PACIENTE")
	private String apellidoMaternoPaciente;

	@Column(name="APELLIDO_PATERNO_PACIENTE")
	private String apellidoPaternoPaciente;

	@Column(name="CELULAR_PACIENTE",nullable=false,length=10)
	private String celularPaciente;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="CORREO_PACIENTE")
	private String correoPaciente;

	@Column(name="CURP_PACIENTE")
	private String curpPaciente;

	@Column(name="DOMICILIO_PACIENTE")
	private String domicilioPaciente;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_NACIMIENTO_PACIENTE")
	private Timestamp fechaNacimientoPaciente;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NOMBRE_PACIENTE")
	private String nombrePaciente;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public PacientesDto() {
	}
	
	/****************************************************************
	 ***************************************************************/
	
	/***************************************************************
	 ***************************************************************/

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getApellidoMaternoPaciente() {
		return this.apellidoMaternoPaciente;
	}

	public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
		this.apellidoMaternoPaciente = apellidoMaternoPaciente;
	}

	public String getApellidoPaternoPaciente() {
		return this.apellidoPaternoPaciente;
	}

	public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
	}

	public String getCelularPaciente() {
		return this.celularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoPaciente() {
		return this.correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public String getCurpPaciente() {
		return this.curpPaciente;
	}

	public void setCurpPaciente(String curpPaciente) {
		this.curpPaciente = curpPaciente;
	}

	public String getDomicilioPaciente() {
		return this.domicilioPaciente;
	}

	public void setDomicilioPaciente(String domicilioPaciente) {
		this.domicilioPaciente = domicilioPaciente;
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

	public Timestamp getFechaNacimientoPaciente() {
		return this.fechaNacimientoPaciente;
	}

	public void setFechaNacimientoPaciente(Timestamp fechaNacimientoPaciente) {
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	

}