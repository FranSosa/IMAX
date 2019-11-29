package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.OrdenesEstudiosVDto;

@Local
public interface OrdenesEstudiosVLocal {

	public List<OrdenesEstudiosVDto> findOneYearOld(); 
	
}
