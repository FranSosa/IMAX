package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.InterpretacionesDto;

@Local
public interface InterpretacionesLocal {

	public void insertInterpretaciones(InterpretacionesDto pInterpretacionesDto);
	
	public List<InterpretacionesDto> findSelectItems();
	
}
