package com.dtecimax.jpa.dto.email;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the NOTIFICACIONES_V database table.
 * 
 */
@Entity
@Table(name="NOTIFICACIONES_V")
@NamedQuery(name="NotificacionesVDto.findAll", query="SELECT n FROM NotificacionesVDto n")
public class NotificacionesVDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CORREO_ELECTRONICO")
	private String correoElectronico;

	@Column(name="NOMBRE_DOCTOR")
	private String nombreDoctor;

	@Column(name="NOMBRE_PACIENTE")
	private String nombrePaciente;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name="NUMERO_DOCTOR")
	private long numeroDoctor;

	@Id
	@Column(name="NUMERO_NTF")
	private long numeroNtf;

	@Column(name="NUMERO_PACIENTE")
	private long numeroPaciente;

	@Column(name="NUMERO_USUARIO")
	private long numeroUsuario;

	@Column(name="TIPO_NTF")
	private long tipoNtf;

	@Column(name="VCHAR_BODY")
	private String vcharBody;

	@Column(name="VCHAR_SUBJECT")
	private String vcharSubject;

	@Column(name="CREADO_POR")
	private long creadoPor;
	
	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion; 
	
	@Column(name="ACTUALIZADO_POR")
	private long actualizadoPor; 
	
	@Column(name="FECHA_ACTUALIZACION")
	private Timestamp fechaActualizacion; 
	
	@Column(name="CAST_FECHA_CREACION")
	private Date castFechaCreacion;
	
	public NotificacionesVDto() {
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombreDoctor() {
		return this.nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public long getNumeroNtf() {
		return this.numeroNtf;
	}

	public void setNumeroNtf(long numeroNtf) {
		this.numeroNtf = numeroNtf;
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public long getNumeroUsuario() {
		return this.numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public long getTipoNtf() {
		return this.tipoNtf;
	}

	public void setTipoNtf(long tipoNtf) {
		this.tipoNtf = tipoNtf;
	}

	public String getVcharBody() {
		return this.vcharBody;
	}

	public void setVcharBody(String vcharBody) {
		this.vcharBody = vcharBody;
	}

	public String getVcharSubject() {
		return this.vcharSubject;
	}

	public void setVcharSubject(String vcharSubject) {
		this.vcharSubject = vcharSubject;
	}
	
	public long getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(long creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(long actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getCastFechaCreacion() {
		return castFechaCreacion;
	}

	public void setCastFechaCreacion(Date castFechaCreacion) {
		this.castFechaCreacion = castFechaCreacion;
	}

}