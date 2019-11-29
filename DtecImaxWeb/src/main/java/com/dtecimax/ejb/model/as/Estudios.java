package com.dtecimax.ejb.model.as;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean  
@ViewScoped
public class Estudios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date sysdate = new Date();
	
	private long numeroEstudio;
	private String comentarios ="comentarios";
	private long costoEstudio;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private String nombreEstudio ="nombre estudio";
	private long numeroUbicacion;
	private long realizaEstudio;
	private String tipoEstudio;
	private long usuarioUltimaActualizacion;
	private String colorEstudio;
	
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;

	public Estudios() {
	}

	public long getNumeroEstudio() {
		return this.numeroEstudio;
	}

	public void setNumeroEstudio(long numeroEstudio) {
		this.numeroEstudio = numeroEstudio;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public long getCostoEstudio() {
		return this.costoEstudio;
	}

	public void setCostoEstudio(long costoEstudio) {
		this.costoEstudio = costoEstudio;
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

	public String getNombreEstudio() {
		return this.nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public long getRealizaEstudio() {
		return this.realizaEstudio;
	}

	public void setRealizaEstudio(long realizaEstudio) {
		this.realizaEstudio = realizaEstudio;
	}

	public String getTipoEstudio() {
		return this.tipoEstudio;
	}

	public void setTipoEstudio(String tipoEstudio) {
		this.tipoEstudio = tipoEstudio;
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

	public String getColorEstudio() {
		return colorEstudio;
	}

	public void setColorEstudio(String colorEstudio) {
		this.colorEstudio = colorEstudio;
	}
}