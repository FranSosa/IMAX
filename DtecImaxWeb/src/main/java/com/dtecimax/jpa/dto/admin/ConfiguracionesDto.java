package com.dtecimax.jpa.dto.admin;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CONFIGURACIONES database table.
 * 
 */
@Entity
@Table(name="dbo.CONFIGURACIONES")
@NamedQuery(name="ConfiguracionesDto.findAll", query="SELECT u FROM ConfiguracionesDto u")
public class ConfiguracionesDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_CONFIGURACION", nullable=false)
	private long numeroConfiguracion;
	
	@Column(name="VALOR_1", nullable=false)
	private BigInteger valor_1;
	
	@Column(name="VALOR_2", nullable=false)
	private BigInteger valor_2;
	
	@Column(name="VALOR_3", nullable=false)
	private BigInteger valor_3;
	
	@Column(name="VALOR_4", nullable=false)
	private BigInteger valor_4;
	
	@Column(name="VALOR_5", nullable=false)
	private BigInteger valor_5;
	
	@Column(name="VALOR_6", nullable=false)
	private String valor_6;
	
	@Column(name="VALOR_7", nullable=false)
	private String valor_7;
	
	@Column(name="VALOR_8", nullable=false)
	private String valor_8;
	
	@Column(name="VALOR_9", nullable=false)
	private String valor_9;
	
	@Column(name="VALOR_10", nullable=false)
	private String valor_10;
	

	@Column(name="COMENTARIOS",length=200)
	private String comentarios;


	@Column(name="ESTATUS",nullable=false)
	private boolean estatus;

	@Column(name="FECHA_CREACION",nullable=false)
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION",nullable=false)
	private Timestamp fechaUltimaActualizacion;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION",nullable=false)
	private long usuarioUltimaActualizacion;

	public ConfiguracionesDto() {
	}

	public BigInteger getValor_1() {
		return this.valor_1;
	}

	public void setValor_1(BigInteger valor_1) {
		this.valor_1 = valor_1;
	}
	
	public BigInteger getValor_2() {
		return this.valor_2;
	}

	public void setValor_2(BigInteger valor_2) {
		this.valor_2 = valor_2;
	}
	
	
	public BigInteger getValor_3() {
		return this.valor_3;
	}

	public void setValor_3(BigInteger valor_3) {
		this.valor_3 = valor_3;
	}
	
	
	public BigInteger getValor_4() {
		return this.valor_4;
	}

	public void setValor_4(BigInteger valor_4) {
		this.valor_4 = valor_4;
	}
	
	
	public BigInteger getValor_5() {
		return this.valor_5;
	}

	public void setValor_5(BigInteger valor_5) {
		this.valor_5 = valor_5;
	}
	
	public String getValor_6() {
		return this.valor_6;
	}

	public void setValor_6(String valor_6) {
		this.valor_6 = valor_6;
	}
	
	public String getValor_7() {
		return this.valor_7;
	}

	public void setValor_7(String valor_7) {
		this.valor_7 = valor_7;
	}
	
	public String getValor_8() {
		return this.valor_8;
	}

	public void setValor_8(String valor_8) {
		this.valor_8 = valor_8;
	}
	
	public String getValor_9() {
		return this.valor_9;
	}

	public void setValor_9(String valor_9) {
		this.valor_9 = valor_9;
	}
	
	public String getValor_10() {
		return this.valor_10;
	}

	public void setValor_10(String valor_10) {
		this.valor_10 = valor_10;
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


	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public long getNumeroConfiguracion() {
		return numeroConfiguracion;
	}

	public void setNumeroConfiguracion(long numeroConfiguracion) {
		this.numeroConfiguracion = numeroConfiguracion;
	}

}