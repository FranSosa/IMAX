package com.dtecimax.jpa.dto.admin;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PERMISOS_USUARIOS database table.
 * 
 */
@Entity
@Table(name="PERMISOS_USUARIOS")
@NamedQuery(name="PermisosUsuariosDto.findAll", query="SELECT p FROM PermisosUsuariosDto p")
public class PermisosUsuariosDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_PERMISO_USUARIOS")
	private long numeroPermisoUsuario;

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

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="NUMERO_USUARIO")
	private long numeroUsuario;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public PermisosUsuariosDto() {
	}
	
	
	public long getNumeroPermisoUsuario() {
		return this.numeroPermisoUsuario;
	}

	public void setNumeroPermisoUsuario(long numeroPermisoUsuario) {
		this.numeroPermisoUsuario = numeroPermisoUsuario;
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

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public long getNumeroUsuario() {
		return this.numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

}