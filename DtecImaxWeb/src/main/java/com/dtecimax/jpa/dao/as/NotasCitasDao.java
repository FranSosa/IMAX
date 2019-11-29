package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.NotasCitasDto;

public interface NotasCitasDao {
	
	public void insertNotasCitas(NotasCitasDto pNotasCitasDto);
	
	public List<NotasCitasDto> findAll(); 
	
	public void deleteNotasCitas(long pNumeroNota);

}
