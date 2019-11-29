package com.dtecimax.ejb.model.admin;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean  
@ViewScoped
public class Configuraciones implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date sysdate = new Date();
	
	private long numeroConfiguracion;
	
	private BigInteger valor_1 = new BigInteger("1");
	private BigInteger valor_2 = new BigInteger("2");
	private BigInteger valor_3 = new BigInteger("3");	
	private BigInteger valor_4;	
	private BigInteger valor_5;	
	private String valor_6;
	private String valor_7;
	private String valor_8;
	private String valor_9;
	private String valor_10;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private long usuarioUltimaActualizacion;
	private String comentarios ="mmmmm";
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;
	

	public Configuraciones() {
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

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
		this.setFechaCreacion(new Timestamp(utilFechaCreacion.getTime()));
	}

	public Date getUtilFechaUltimaActualizacion() {
		return utilFechaUltimaActualizacion;
	}

	public void setUtilFechaUltimaActualizacion(Date utilFechaUltimaActualizacion) {
		this.utilFechaUltimaActualizacion = utilFechaUltimaActualizacion;
		this.setFechaUltimaActualizacion(new Timestamp(utilFechaUltimaActualizacion.getTime()));
	}

	public long getNumeroConfiguracion() {
		return numeroConfiguracion;
	}

	public void setNumeroConfiguracion(long numeroConfiguracion) {
		this.numeroConfiguracion = numeroConfiguracion;
	}

}
