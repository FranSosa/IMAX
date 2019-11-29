package com.dtecimax.ejb.model.as;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class Citas implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date sysdate = new Date();
	
	private long numeroCita;
	private String comentarios;
	private boolean estatus;
	private Timestamp fechaCita;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private Time horaFinalCita;
	private Time horaInicialCita;
	private long numeroDoctor;
	private long numeroEstudio;
	private long numeroPaciente;
	private long numeroUbicacion;
	private long usuarioUltimaActualizacion;
	
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;
    private Date utilFechaCita = sysdate;
    private Date utilHoraInicialCita;
    private Date utilHoraFinalCita;
    
	public Citas() {
	}

	public long getNumeroCita() {
		return this.numeroCita;
	}

	public void setNumeroCita(long numeroCita) {
		this.numeroCita = numeroCita;
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

	public Timestamp getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Timestamp fechaCita) {
		this.fechaCita = fechaCita;
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

	public Time getHoraFinalCita() {
		return this.horaFinalCita;
	}

	public void setHoraFinalCita(Time horaFinalCita) {
		this.horaFinalCita = horaFinalCita;
	}

	public Time getHoraInicialCita() {
		return this.horaInicialCita;
	}

	public void setHoraInicialCita(Time horaInicialCita) {
		this.horaInicialCita = horaInicialCita;
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public long getNumeroEstudio() {
		return this.numeroEstudio;
	}

	public void setNumeroEstudio(long numeroEstudio) {
		this.numeroEstudio = numeroEstudio;
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
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
	
	public Date getUtilFechaCreacion() {
		return utilFechaCreacion;
	}

	public void setUtilFechaCreacion(Date utilFechaCreacion) {
		this.utilFechaCreacion = utilFechaCreacion;
		if(null!=utilFechaCreacion) {
		this.setFechaCreacion(new Timestamp(utilFechaCreacion.getTime()));
		}
	}

	public Date getUtilFechaUltimaActualizacion() {
		return utilFechaUltimaActualizacion;
	}

	public void setUtilFechaUltimaActualizacion(Date utilFechaUltimaActualizacion) {
		this.utilFechaUltimaActualizacion = utilFechaUltimaActualizacion;
		if(null!=utilFechaUltimaActualizacion) {
		this.setFechaUltimaActualizacion(new Timestamp(utilFechaUltimaActualizacion.getTime()));
		}
	}

	public Date getUtilFechaCita() {
		return utilFechaCita;
	}

	public void setUtilFechaCita(Date utilFechaCita) {
		this.utilFechaCita = utilFechaCita;
		this.setFechaCita(new Timestamp(utilFechaCita.getTime()));

	}

	public Date getUtilHoraInicialCita() {
		return utilHoraInicialCita;
	}

	public void setUtilHoraInicialCita(Date utilHoraInicialCita) {
		this.utilHoraInicialCita = utilHoraInicialCita;
		if(null!=utilHoraInicialCita) {
		this.setHoraInicialCita(new java.sql.Time(utilHoraInicialCita.getTime()));
		}
	}

	public Date getUtilHoraFinalCita() {
		return utilHoraFinalCita;
	}

	public void setUtilHoraFinalCita(Date utilHoraFinalCita) {
		this.utilHoraFinalCita = utilHoraFinalCita;
		if(null!=utilHoraFinalCita) {
		this.setHoraFinalCita(new java.sql.Time(utilHoraFinalCita.getTime()));
		}
	}

}
