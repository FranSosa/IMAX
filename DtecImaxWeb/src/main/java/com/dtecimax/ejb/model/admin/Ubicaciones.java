package com.dtecimax.ejb.model.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class Ubicaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date sysdate = new Date();
	
	private long numeroUbicacion;
	private String comentarios ="comentarios";
	private String correoUbicacion="x";
	private String domicilioUbicacion="x";
	private boolean estatus=false;
	private Date utilFechaCreacion = sysdate;
	private Timestamp fechaCreacion;
	private Date utilFechaUltimaActualizacion = sysdate;
	private Timestamp fechaUltimaActualizacion;
	private String horarioUbicacion="x";
	private String nombreUbicacion="x";
	private String telefonoUbicacion="x";
	private long usuarioUltimaActualizacion=1l;
	

	private String estatusDes;
	
	public Ubicaciones() {
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

	public String getEstatusDes() {
		if(this.estatus) {
		  return "Activo";	
		}else {
	      return "Inactivo";
		}
	}

	public void setEstatusDes(String estatusDes) {
		this.estatusDes = estatusDes;
	}
	
	@Override
	public String toString() {
		return "[numeroUbicacion="+numeroUbicacion+", nombreUbicacion="+nombreUbicacion+"]";
	}
	
	public void clean() {
		this.setComentarios(null);
		this.setNombreUbicacion(null);
		this.setDomicilioUbicacion(null);
		this.setTelefonoUbicacion(null);
		this.setComentarios(null);
		this.setHorarioUbicacion(null);
	}
	

}