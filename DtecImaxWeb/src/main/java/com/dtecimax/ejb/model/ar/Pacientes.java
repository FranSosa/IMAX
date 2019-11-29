package com.dtecimax.ejb.model.ar;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class Pacientes implements Serializable {
    
	private Date sysdate = new Date();
	
	private static final long serialVersionUID = 1L;
	private long numeroPaciente;
	private String apellidoMaternoPaciente = "apellidoMaternoPaciente";
	private String apellidoPaternoPaciente = "apellidoPaternoPaciente";
	private String celularPaciente = "123456789";
	private String comentarios = "comentarios";
	private String correoPaciente = "correoPaciente";
	private String curpPaciente = "curpPaciente";
	private String domicilioPaciente="domicilioPaciente";
	private boolean estatus = true;
	private Timestamp fechaCreacion;
	private Timestamp fechaNacimientoPaciente;
	private Timestamp fechaUltimaActualizacion;
	private String nombrePaciente ="nombrePaciente";
	private long usuarioUltimaActualizacion;
	
	private Date utilFechaNacimientoPaciente = sysdate;
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;

	public Pacientes() {
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getApellidoMaternoPaciente() {
		return this.apellidoMaternoPaciente;
	}

	public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
		this.apellidoMaternoPaciente = apellidoMaternoPaciente;
	}

	public String getApellidoPaternoPaciente() {
		return this.apellidoPaternoPaciente;
	}

	public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
	}

	public String getCelularPaciente() {
		return this.celularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoPaciente() {
		return this.correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public String getCurpPaciente() {
		return this.curpPaciente;
	}

	public void setCurpPaciente(String curpPaciente) {
		this.curpPaciente = curpPaciente;
	}

	public String getDomicilioPaciente() {
		return this.domicilioPaciente;
	}

	public void setDomicilioPaciente(String domicilioPaciente) {
		this.domicilioPaciente = domicilioPaciente;
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

	public Timestamp getFechaNacimientoPaciente() {
		return this.fechaNacimientoPaciente;
	}

	public void setFechaNacimientoPaciente(Timestamp fechaNacimientoPaciente) {
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}
	
	public Date getUtilFechaNacimientoPaciente() {
		if(null!=this.fechaNacimientoPaciente) {
			utilFechaNacimientoPaciente = new Date(fechaNacimientoPaciente.getTime());
		}
		return utilFechaNacimientoPaciente;
	}

	public void setUtilFechaNacimientoPaciente(Date utilFechaNacimientoPaciente) {
		this.utilFechaNacimientoPaciente = utilFechaNacimientoPaciente;
		this.setFechaNacimientoPaciente(new Timestamp(utilFechaNacimientoPaciente.getTime()));
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