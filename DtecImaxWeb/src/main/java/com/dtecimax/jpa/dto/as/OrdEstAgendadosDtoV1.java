package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ORD_EST_AGENDADOS_V1 database table.
 * 
 */
@Entity
@Table(name="ORD_EST_AGENDADOS_V1")
@NamedQuery(name="OrdEstAgendadosDtoV1.findAll", query="SELECT o FROM OrdEstAgendadosDtoV1 o")
public class OrdEstAgendadosDtoV1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name="NUMERO_ORDENES")
	private int numeroOrdenes;

	@Id 
	@Column(name="[ROWNUM]")
	private long rownum;

	@Column(name="TIPO_ORDEN")
	private String tipoOrden;

	public OrdEstAgendadosDtoV1() {
	}

	public Object getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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