package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.NotasCitasDto;

@Local
public interface NotasCitasLocal {

	public void insertNotasCitas(NotasCitasDto pNotasCitasDto);
	
	public List<NotasCitasDto> findAll(); 
	
	public void deleteNotasCitas(long pNumeroNota); 
	
}
