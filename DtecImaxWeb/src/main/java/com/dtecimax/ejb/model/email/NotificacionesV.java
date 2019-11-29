package com.dtecimax.ejb.model.email;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class NotificacionesV implements Serializable {
	private static final long serialVersionUID = 1L;

	private String correoElectronico;
	private String nombreDoctor;
	private String nombrePaciente;
	private String nombreUsuario;
	private long numeroDoctor;
	private long numeroNtf;
	private long numeroPaciente;
	private long numeroUsuario;
	private long tipoNtf;
	private String vcharBody;
	private String vcharSubject;
	private long creadoPor;
	private Timestamp fechaCreacion; 
	private long actualizadoPor; 
	private Timestamp fechaActualizacion; 
	
	public NotificacionesV() {
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombreDoctor() {
		return this.nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public long getNumeroNtf() {
		return this.numeroNtf;
	}

	public void setNumeroNtf(long numeroNtf) {
		this.numeroNtf = numeroNtf;
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public long getNumeroUsuario() {
		return this.numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public long getTipoNtf() {
		return this.tipoNtf;
	}

	public void setTipoNtf(long tipoNtf) {
		this.tipoNtf = tipoNtf;
	}

	public String getVcharBody() {
		return this.vcharBody;
	}

	public void setVcharBody(String vcharBody) {
		this.vcharBody = vcharBody;
	}

	public String getVcharSubject() {
		return this.vcharSubject;
	}

	public void setVcharSubject(String vcharSubject) {
		this.vcharSubject = vcharSubject;
	}
	
	public long getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(long creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(long actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}