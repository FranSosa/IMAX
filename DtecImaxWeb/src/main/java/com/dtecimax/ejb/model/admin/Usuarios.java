package com.dtecimax.ejb.model.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean  
@ViewScoped
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date sysdate = new Date();
	
	private long numeroUsuario;
	private String claveUsuario ="x";
	private String nombreUsuario ="x";
	private String apellidoMaternoUsuario="x";
	private String apellidoPaternoUsuario="x";
	private String comentarios="comentarios";
	private String contrasenaUsuario="x";
	private boolean estatus = true;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private long numeroUbicacion;
	private long usuarioUltimaActualizacion;
	
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;
	

	public Usuarios() {
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
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


}
