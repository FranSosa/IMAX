package com.dtecimax.ejb.model.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class Permisos implements Serializable {
	private static final long serialVersionUID = 1L;

	private long numeroPermiso;
	private String comentarios;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private long numeroModulo;
	private String descNumeroModulo;
	private long numeroPantalla;
	private String descNumeroPantalla;
	private long numeroUbicacion;
	private boolean tipoAdministrador;
	private String descTipoAdministrador;
	private long tipoPermiso;
	private String descTipoPermiso;
	private long usuarioUltimaActualizacion;
	
   private Date sysdate = new Date();
	
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;


	public Permisos() {
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

	public String getDescNumeroModulo() {
		
		if(1l==this.numeroModulo) {
			return "Modulo1";
		}else if(2l==this.numeroModulo) {
			return "Modulo2";
		}else if(3l==this.numeroModulo) {
			return "Modulo3";
		}	
		return descNumeroModulo;
	
	}

	public String getDescNumeroPantalla() {
		if(1l==this.numeroPantalla) {
			return "Pantalla1";
		}else if(2l==this.numeroPantalla) {
			return "Pantalla2";
		}else if(3l==this.numeroPantalla) {
			return "Pantalla3";
		}
		
		return descNumeroPantalla;
	}

	public void setDescNumeroPantalla(String descNumeroPantalla) {
		this.descNumeroPantalla = descNumeroPantalla;
	}

	public String getDescTipoPermiso() {
		if(1l==this.tipoPermiso) {
			return "Completo";
		}else if(2l==this.tipoPermiso) {
			return "Solo Lectura";
		}
		return descTipoPermiso;
	}

	public String getDescTipoAdministrador() {
		if(this.tipoAdministrador) {
		  return "Activo";
		}else {
		  return "Inactivo";	
		}
	}

	public void setDescTipoAdministrador(String descTipoAdministrador) {
		this.descTipoAdministrador = descTipoAdministrador;
	}

	

}