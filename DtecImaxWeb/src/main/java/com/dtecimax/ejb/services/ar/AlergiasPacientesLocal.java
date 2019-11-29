package com.dtecimax.ejb.services.ar;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;

@Local
public interface AlergiasPacientesLocal {

	public void insetAlergiasPacientes(AlergiasPacientesDto pAlergiasPacientesDto);
	
	public void updateAlergiasPacientes(long pNumeroAlergia
                                       ,AlergiasPacientesDto pAlergiasPacientesDto);

    public void deleteAlergiasPacientes(long pNumeroAlergia);

	
	public List<AlergiasPacientesDto> findSelectItems();
	
	public List<AlergiasPacientesDto> findAll();
	
}
