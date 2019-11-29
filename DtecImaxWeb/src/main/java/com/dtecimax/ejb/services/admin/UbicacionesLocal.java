package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Local;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;

@Local
public interface UbicacionesLocal {

	public void insertUbicaciones(UbicacionesDto pUbicaciones); 
	
	public void deleteUbicaciones(long pNumeroUbicacion);
	
	public void updateUbicaciones(long pNumeroUbicacion, UbicacionesDto pUbicaciones);
	
	public List<UbicacionesDto> findAll(); 
	
	public List<UbicacionesDto> findSelectItems();
	
	public UbicacionesDto findByNumeroUbicacion(long pNumeroUbicacion);
	
}
