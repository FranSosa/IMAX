package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ORD_EST_AGENDADOS_V2")
@NamedQuery(name="OrdEstAgendadosDtoV2.findAll", query="SELECT o FROM OrdEstAgendadosDtoV2 o")
public class OrdEstAgendadosDtoV2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="NOMBRE_ESTUDIO")
	private String nombreEstudio;

	@Column(name="NUMERO_ORDENES")
	private int numeroOrdenes;

	@Id
	@Column(name="[ROWNUM]")
	private long rownum;

	@Column(name="TIPO_ORDEN")
	private String tipoOrden;

	public OrdEstAgendadosDtoV2() {
	}

	public Object getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreEstudio() {
		return this.nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

	public int getNumeroOrdenes() {
		return this.numeroOrdenes;
	}

	public void setNumeroOrdenes(int numeroOrdenes) {
		this.numeroOrdenes = numeroOrdenes;
	}

	public long getRownum() {
		return this.rownum;
	}

	public void setRownum(long rownum) {
		this.rownum = rownum;
	}

	public String getTipoOrden() {
		return this.tipoOrden;
	}

	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

}