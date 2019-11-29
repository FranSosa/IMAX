package com.dtecimax.ejb.model.admin;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class PermisosUsuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date sysdate = new Date();
	
	private long numeroPermisoUsuario;
	private long numeroUbicacion;
	private long numeroUsuario;
	private long numeroPermiso;
	private String nombreUbicacion; 
	private boolean estatus;
	private Timestamp fechaCreacion ;
	private Timestamp fechaUltimaActualizacion;
	private long usuarioUltimaActualizacion;
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;
	private String comentarios ="comentarios";
	
	public PermisosUsuarios() {
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

	public Date getUtilFechaCreacion() {
		return utilFechaCreacion;
	}

	public void setUtilFechaCreacion(Date utilFechaCreacion) {
		this.utilFechaCreacion = utilFechaCreacion;
		this.setFechaCreacion(new Timestamp(utilFechaCreacion.getTime()));
	}

	public Date getUtilFechaUltimaActualizacion() {
		return utilFechaUltimaActualizacion;
	}

	public void setUtilFechaUltimaActualizacion(Date utilFechaUltimaActualizacion) {
		this.utilFechaUltimaActualizacion = utilFechaUltimaActualizacion;
		this.setFechaUltimaActualizacion(new Timestamp(utilFechaUltimaActualizacion.getTime()));
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
		

}