package com.dtecimax.ejb.services.as;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.HistorialClinicoDto;

@Local
public interface HistorialClinicoLocal {

	public void insertHistorialClinico(HistorialClinicoDto pHistorialClinicoDto);
	
}
