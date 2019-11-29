package com.dtecimax.jpa.dto.admin;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the UBICACIONES database table.
 * 
 */
@Entity
@Table(name="dbo.UBICACIONES")
@NamedQuery(name="UbicacionesDto.findAll", query="SELECT u FROM UbicacionesDto u")
public class UbicacionesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="COMENTARIOS",length=200)
	private String comentarios;

	@Column(name="CORREO_UBICACION",nullable=false,length=50)
	private String correoUbicacion;

	@Column(name="DOMICILIO_UBICACION",nullable=false,length=50)
	private String domicilioUbicacion;

	@Column(name="ESTATUS",nullable=false)
	private boolean estatus;

	@Column(name="FECHA_CREACION",nullable=false)
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION",nullable=false)
	private Timestamp fechaUltimaActualizacion;

	@Column(name="HORARIO_UBICACION",nullable=false,length=50)
	private String horarioUbicacion;

	@Column(name="NOMBRE_UBICACION",nullable=false,length=50)
	private String nombreUbicacion;

	@Column(name="TELEFONO_UBICACION",nullable=false,length=50)
	private String telefonoUbicacion;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION",nullable=false)
	private long usuarioUltimaActualizacion;

	public UbicacionesDto() {
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoUbicacion() {
		return this.correoUbicacion;
	}

	public void setCorreoUbicacion(String correoUbicacion) {
		this.correoUbicacion = correoUbicacion;
	}

	public String getDomicilioUbicacion() {
		return this.domicilioUbicacion;
	}

	public void setDomicilioUbicacion(String domicilioUbicacion) {
		this.domicilioUbicacion = domicilioUbicacion;
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

	public String getHorarioUbicacion() {
		return this.horarioUbicacion;
	}

	public void setHorarioUbicacion(String horarioUbicacion) {
		this.horarioUbicacion = horarioUbicacion;
	}

	public String getNombreUbicacion() {
		return this.nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}

	public String getTelefonoUbicacion() {
		return this.telefonoUbicacion;
	}

	public void setTelefonoUbicacion(String telefonoUbicacion) {
		this.telefonoUbicacion = telefonoUbicacion;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

}