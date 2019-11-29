package com.dtecimax.jpa.dto.admin;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="UsuariosDto.findAll", query="SELECT u FROM UsuariosDto u")
public class UsuariosDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_USUARIO")
	private long numeroUsuario;
	
	@Column(name="CLAVE_USUARIO")
	private String claveUsuario;
	
	@Column(name="NOMBRE_USUARIO",nullable=false,length=50)
	private String nombreUsuario;

	@Column(name="APELLIDO_MATERNO_USUARIO",nullable=false,length=50)
	private String apellidoMaternoUsuario;

	@Column(name="APELLIDO_PATERNO_USUARIO",nullable=false,length=50)
	private String apellidoPaternoUsuario;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="CONTRASENA_USUARIO")
	private String contrasenaUsuario;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public UsuariosDto() {
	}

	public long getNumeroUsuario() {
		return this.numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public String getApellidoMaternoUsuario() {
		return this.apellidoMaternoUsuario;
	}

	public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
		this.apellidoMaternoUsuario = apellidoMaternoUsuario;
	}

	public String getApellidoPaternoUsuario() {
		return this.apellidoPaternoUsuario;
	}

	public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
		this.apellidoPaternoUsuario = apellidoPaternoUsuario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getContrasenaUsuario() {
		return this.contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
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

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public String toString() {
		return "[numero_usuario="+this.numeroUsuario+", nombre_usuario="+this.nombreUsuario+"]"; 
	}

}