package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.InterpretacionesDto;

public interface InterpretacionesDao {

	public void insertInterpretaciones(InterpretacionesDto pInterpretacionesDto);
	
	public List<InterpretacionesDto> findSelectItems();
	
}
