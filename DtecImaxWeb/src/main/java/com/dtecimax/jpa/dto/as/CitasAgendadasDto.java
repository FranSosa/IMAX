package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Date;

public class CitasAgendadasDto  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3977210718606730517L;

	private long numeroCitas;
	private Date fechaCita; 

	public long getNumeroCitas() {
		return numeroCitas;
	}

	public void setNumeroCitas(long numeroCitas) {
		this.numeroCitas = numeroCitas;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	} 
	
	@Override
	public String toString() {
		return "numeroCitas:"+numeroCitas+", fechaCita:"+fechaCita; 
	}
	
}
