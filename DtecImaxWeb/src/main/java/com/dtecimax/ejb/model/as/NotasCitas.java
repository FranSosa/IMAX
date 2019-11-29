package com.dtecimax.ejb.model.as;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class NotasCitas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6824579032892654720L;

	private long numeroNota; 
	private Timestamp fechaNota; 
	private String txtNota;
	private Date utilFechaNota; 
	
	public long getNumeroNota() {
		return numeroNota;
	}
	public void setNumeroNota(long numeroNota) {
		this.numeroNota = numeroNota;
	}
	public Timestamp getFechaNota() {
		return fechaNota;
	}
	public void setFechaNota(Timestamp fechaNota) {
		this.fechaNota = fechaNota;
	}
	public String getTxtNota() {
		return txtNota;
	}
	public void setTxtNota(String txtNota) {
		this.txtNota = txtNota;
	}
	public Date getUtilFechaNota() {
		return utilFechaNota;
	}
	public void setUtilFechaNota(Date utilFechaNota) {
		if(null!=utilFechaNota) {
			this.setFechaNota(new java.sql.Timestamp(utilFechaNota.getTime()));
		}
		this.utilFechaNota = utilFechaNota;
	} 
	
}
