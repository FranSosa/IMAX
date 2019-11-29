package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.CitasDto;

public interface CitasDao {

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
