package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="NOTAS_CITAS")
@NamedQuery(name="NotasCitasDto.findAll", query="SELECT c FROM NotasCitasDto c")
public class NotasCitasDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849485973262320742L;
	
	@Id
	@Column(name="NUMERO_NOTA")
	private long numeroNota; 
	
	@Column(name="FECHA_NOTA")
	private Timestamp fechaNota; 
	
	@Column(name="TXT_NOTA")
	private String txtNota;
	
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

}
