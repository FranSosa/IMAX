package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.CitasDto;

@Local
public interface CitasLocal {

	public void insertCitas(CitasDto pCitasDto);
	
	public List<CitasDto> findSelectItems();
	
	public List<CitasDto> findAll();
	
	public List<CitasDto> findAllByNumDoc(long pNumeroDoctor
			                             ,String pSearchTipoEstu
			                             );
	
	public CitasDto findByNumeroCita(long pNumeroCita); 
	
	public void actualizaCitas(CitasDto pCitasDto,long pNumeroCita);
	
	public void deleteCita(long pNumeroCita); 
	
}
