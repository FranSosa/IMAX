package com.dtecimax.ejb.model.hr;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class Doctores implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date sysdate = new Date();
	
	private long numeroDoctor;
	private String apellidoMaternoDoctor;
	private String apellidoPaternoDoctor;
	private String cedulaDoctor;
	private String celularDoctor;
	private String comentarios;
	private String correoDoctor;
	private String curpDoctor;
	private String domicilioDoctor;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaNacimientoDoctor;
	private Timestamp fechaUltimaActualizacion;
	private String nombreDoctor;
	private long numeroUbicacion;
	private short tipoDoctor;
	private long usuarioUltimaActualizacion;
	
	private Date utilFechaNacimientoDoctor = sysdate;
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;

	public Doctores() {
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public String getApellidoMaternoDoctor() {
		return this.apellidoMaternoDoctor;
	}

	public void setApellidoMaternoDoctor(String apellidoMaternoDoctor) {
		this.apellidoMaternoDoctor = apellidoMaternoDoctor;
	}

	public String getApellidoPaternoDoctor() {
		return this.apellidoPaternoDoctor;
	}

	public void setApellidoPaternoDoctor(String apellidoPaternoDoctor) {
		this.apellidoPaternoDoctor = apellidoPaternoDoctor;
	}

	public String getCedulaDoctor() {
		return this.cedulaDoctor;
	}

	public void setCedulaDoctor(String cedulaDoctor) {
		this.cedulaDoctor = cedulaDoctor;
	}

	public String getCelularDoctor() {
		return this.celularDoctor;
	}

	public void setCelularDoctor(String celularDoctor) {
		this.celularDoctor = celularDoctor;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getCorreoDoctor() {
		return this.correoDoctor;
	}

	public void setCorreoDoctor(String correoDoctor) {
		this.correoDoctor = correoDoctor;
	}

	public String getCurpDoctor() {
		return this.curpDoctor;
	}

	public void setCurpDoctor(String curpDoctor) {
		this.curpDoctor = curpDoctor;
	}

	public String getDomicilioDoctor() {
		return this.domicilioDoctor;
	}

	public void setDomicilioDoctor(String domicilioDoctor) {
		this.domicilioDoctor = domicilioDoctor;
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

	public Timestamp getFechaNacimientoDoctor() {
		return this.fechaNacimientoDoctor;
	}

	public void setFechaNacimientoDoctor(Timestamp fechaNacimientoDoctor) {
		this.fechaNacimientoDoctor = fechaNacimientoDoctor;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getNombreDoctor() {
		return this.nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public short getTipoDoctor() {
		return this.tipoDoctor;
	}

	public void setTipoDoctor(short tipoDoctor) {
		this.tipoDoctor = tipoDoctor;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public Date getUtilFechaNacimientoDoctor() {
		if(null!=this.fechaNacimientoDoctor) {
			utilFechaNacimientoDoctor = new Date(this.fechaNacimientoDoctor.getTime());
		}
		return utilFechaNacimientoDoctor;
	}

	public void setUtilFechaNacimientoDoctor(Date utilFechaNacimientoDoctor) {
		this.utilFechaNacimientoDoctor = utilFechaNacimientoDoctor;
		this.setFechaNacimientoDoctor(new Timestamp(utilFechaNacimientoDoctor.getTime()));
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