package com.dtecimax.ejb.services.admin;


import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.UbicacionesDao;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;

@Stateless 
public class UbicacionesLocalImpl implements UbicacionesLocal {

	@Inject
	UbicacionesDao ubicacionesDao;
	
	public void insertUbicaciones(UbicacionesDto pUbicaciones) {
		ubicacionesDao.insertUbicaciones(pUbicaciones);
	}
	
	@Override
	public void deleteUbicaciones(long pNumeroUbicacion) {
		ubicacionesDao.deleteUbicaciones(pNumeroUbicacion);
	}
	
	@Override
	public void updateUbicaciones(long pNumeroUbicacion, UbicacionesDto pUbicaciones) {
		ubicacionesDao.updateUbicaciones(pNumeroUbicacion, pUbicaciones);
	}
	
	@Override
	public List<UbicacionesDto> findAll() {
		return ubicacionesDao.findSelectItems();
	}

	@Override
	public List<UbicacionesDto> findSelectItems() {
		return ubicacionesDao.findSelectItems();
	}

	@Override
	public UbicacionesDto findByNumeroUbicacion(long pNumeroUbicacion) {
		return ubicacionesDao.findByNumeroUbicacion(pNumeroUbicacion);
	}



}
