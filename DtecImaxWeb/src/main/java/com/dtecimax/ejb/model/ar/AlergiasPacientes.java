package com.dtecimax.ejb.model.ar;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean  
@ViewScoped
public class AlergiasPacientes implements Serializable {
	private static final long serialVersionUID = 1L;

	private long numeroAlergia;
	private String descripcion;
	private String nombreAlergia;

	public AlergiasPacientes() {
	}

	public long getNumeroAlergia() {
		return this.numeroAlergia;
	}

	public void setNumeroAlergia(long numeroAlergia) {
		this.numeroAlergia = numeroAlergia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreAlergia() {
		return this.nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

}