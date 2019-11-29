package com.dtecimax.jpa.dao.ar;

import java.util.List;

import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;

public interface AlergiasPacientesDao {
	
	public void insetAlergiasPacientes(AlergiasPacientesDto pAlergiasPacientesDto);
	
	public void updateAlergiasPacientes(long pNumeroAlergia
			                           ,AlergiasPacientesDto pAlergiasPacientesDto);
	
	public void deleteAlergiasPacientes(long pNumeroAlergia);
	
	public List<AlergiasPacientesDto> findSelectItems();
	
	public List<AlergiasPacientesDto> findAll();

}
