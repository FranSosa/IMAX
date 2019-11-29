package com.dtecimax.jpa.dao.admin;

import java.util.List;

import com.dtecimax.jpa.dto.admin.UbicacionesDto;

public interface UbicacionesDao {

	public void insertUbicaciones(UbicacionesDto pUbicaciones);
	
	public void deleteUbicaciones(long pNumeroUbicacion);
	
	public void updateUbicaciones(long pNumeroUbicacion,UbicacionesDto pUbicaciones);
	
	public List<UbicacionesDto> findAll();
	
	public List<UbicacionesDto> findSelectItems();
	
	public UbicacionesDto findByNumeroUbicacion(long pNumeroUbicacion);
	
}
