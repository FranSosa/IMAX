package com.dtecimax.ejb.model.hr;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class DoctoresReferentes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date sysdate = new Date();
	
	private long numeroDoctorReferente;
	private String apellidoMaternoDoctorReferente;
	private String apellidoPaternoDoctorReferente;
	private String cedulaDoctorReferente;
	private String celularDoctorReferente;
	private String comentarios;
	private String correoDoctorReferente;
	private String curpDoctorReferente;
	private String domicilioDoctorReferente;
	private String areaDoctorReferente;
	private String nombreDoctorReferente;
	private String lugarTrabajo;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaNacimientoDoctorReferente;
	private Timestamp fechaUltimaActualizacion;
	
	private long usuarioUltimaActualizacion;
	
	private Date utilFechaNacimientoDoctorReferente = sysdate;
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;

	public DoctoresReferentes() {
	}

	public long getNumeroDoctorReferente() {
		return this.numeroDoctorReferente;
	}

	public void setNumeroDoctorReferente(long numeroDoctorReferente) {
		this.numeroDoctorReferente = numeroDoctorReferente;
		
	}
	
	public String getNombreDoctorReferente() {
		return this.nombreDoctorReferente;
		
	}
	
	public void setNombreDoctorReferente(String nombreDoctorReferente) {
		this.nombreDoctorReferente = nombreDoctorReferente;
		
	}

	public String getApellidoMaternoDoctorReferente() {
		return this.apellidoMaternoDoctorReferente;
	}

	public void setApellidoMaternoDoctorReferente(String apellidoMaternoDoctorReferente) {
		this.apellidoMaternoDoctorReferente = apellidoMaternoDoctorReferente;
	}

	public String getApellidoPaternoDoctorReferente() {
		return this.apellidoPaternoDoctorReferente;
	}

	public void setApellidoPaternoDoctorReferente(String apellidoPaternoDoctorReferente) {
		this.apellidoPaternoDoctorReferente = apellidoPaternoDoctorReferente;
	}

	public String getCedulaDoctorReferente() {
		return this.cedulaDoctorReferente;
	}

	public void setCedulaDoctorReferente(String cedulaDoctorReferente) {
		this.cedulaDoctorReferente = cedulaDoctorReferente;
	}

	public String getCelularDoctorReferente() {
		return this.celularDoctorReferente;
	}

	public void setCelularDoctorReferente(String celularDoctorReferente) {
		this.celularDoctorReferente = celularDoctorReferente;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoDoctorReferente() {
		return this.correoDoctorReferente;
	}

	public void setCorreoDoctorReferente(String correoDoctorReferente) {
		this.correoDoctorReferente = correoDoctorReferente;
	}

	public String getCurpDoctorReferente() {
		return this.curpDoctorReferente;
	}

	public void setCurpDoctorReferente(String curpDoctorReferente) {
		this.curpDoctorReferente = curpDoctorReferente;
	}

	public String getDomicilioDoctorReferente() {
		return this.domicilioDoctorReferente;
	}

	public void setDomicilioDoctorReferente(String domicilioDoctorReferente) {
		this.domicilioDoctorReferente = domicilioDoctorReferente;
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

	public Timestamp getFechaNacimientoDoctorReferente() {
		return this.fechaNacimientoDoctorReferente;
	}

	public void setFechaNacimientoDoctorReferente(Timestamp fechaNacimientoDoctorReferente) {
		this.fechaNacimientoDoctorReferente = fechaNacimientoDoctorReferente;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	
	public String getAreaDoctorReferente() {
		return this.areaDoctorReferente;
	}

	public void setAreaDoctorReferente(String areaDoctorReferente) {
		this.areaDoctorReferente = areaDoctorReferente;
	}
	
	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public Date getUtilFechaNacimientoDoctorReferente() {
		return utilFechaNacimientoDoctorReferente;
	}

	public void setUtilFechaNacimientoDoctorReferente(Date utilFechaNacimientoDoctorReferente) {
		this.utilFechaNacimientoDoctorReferente = utilFechaNacimientoDoctorReferente;
		this.setFechaNacimientoDoctorReferente(new Timestamp(utilFechaNacimientoDoctorReferente.getTime()));
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