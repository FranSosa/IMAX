package com.dtecimax.jpa.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the PERMISOS database table.
 * 
 */
@Entity
@Table(name="PERMISOS")
@NamedQuery(name="PermisosDto.findAll", query="SELECT p FROM PermisosDto p")
public class PermisosDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_PERMISO")
	private long numeroPermiso;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NUMERO_MODULO")
	private long numeroModulo;

	@Column(name="NUMERO_PANTALLA")
	private long numeroPantalla;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="TIPO_ADMINISTRADOR")
	private boolean tipoAdministrador;

	@Column(name="TIPO_PERMISO")
	private long tipoPermiso;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public PermisosDto() {
	}

	public long getNumeroPermiso() {
		return this.numeroPermiso;
	}

	public void setNumeroPermiso(long numeroPermiso) {
		this.numeroPermiso = numeroPermiso;
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

	public long getNumeroModulo() {
		return this.numeroModulo;
	}

	public void setNumeroModulo(long numeroModulo) {
		this.numeroModulo = numeroModulo;
	}

	public long getNumeroPantalla() {
		return this.numeroPantalla;
	}

	public void setNumeroPantalla(long numeroPantalla) {
		this.numeroPantalla = numeroPantalla;
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public boolean getTipoAdministrador() {
		return this.tipoAdministrador;
	}

	public void setTipoAdministrador(boolean tipoAdministrador) {
		this.tipoAdministrador = tipoAdministrador;
	}

	public long getTipoPermiso() {
		return this.tipoPermiso;
	}

	public void setTipoPermiso(long tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

}