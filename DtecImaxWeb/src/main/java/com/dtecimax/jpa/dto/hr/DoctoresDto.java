package com.dtecimax.jpa.dto.hr;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DOCTORES database table.
 * 
 */
@Entity
@Table(name="DOCTORES")
@NamedQuery(name="DoctoresDto.findAll", query="SELECT d FROM DoctoresDto d")
public class DoctoresDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_DOCTOR")
	private long numeroDoctor;

	@Column(name="APELLIDO_MATERNO_DOCTOR")
	private String apellidoMaternoDoctor;

	@Column(name="APELLIDO_PATERNO_DOCTOR")
	private String apellidoPaternoDoctor;

	@Column(name="CEDULA_DOCTOR")
	private String cedulaDoctor;

	@Column(name="CELULAR_DOCTOR")
	private String celularDoctor;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="CORREO_DOCTOR")
	private String correoDoctor;

	@Column(name="CURP_DOCTOR")
	private String curpDoctor;

	@Column(name="DOMICILIO_DOCTOR")
	private String domicilioDoctor;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_NACIMIENTO_DOCTOR")
	private Timestamp fechaNacimientoDoctor;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NOMBRE_DOCTOR")
	private String nombreDoctor;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="TIPO_DOCTOR")
	private short tipoDoctor;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;

	public DoctoresDto() {
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

}