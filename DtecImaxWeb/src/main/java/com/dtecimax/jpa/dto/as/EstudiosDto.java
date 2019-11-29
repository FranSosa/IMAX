package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ESTUDIOS database table.
 * 
 */
@Entity
@Table(name="ESTUDIOS")
@NamedQuery(name="EstudiosDto.findAll", query="SELECT e FROM EstudiosDto e")
public class EstudiosDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_ESTUDIO")
	private long numeroEstudio;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="COSTO_ESTUDIO")
	private long costoEstudio;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="NOMBRE_ESTUDIO")
	private String nombreEstudio;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="REALIZA_ESTUDIO")
	private long realizaEstudio;

	@Column(name="TIPO_ESTUDIO")
	private String tipoEstudio;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;
	
	@Column(name="COLOR_ESTUDIO")
	private String colorEstudio;

	public EstudiosDto() {
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

	public String getColorEstudio() {
		return colorEstudio;
	}

	public void setColorEstudio(String colorEstudio) {
		this.colorEstudio = colorEstudio;
	}

}