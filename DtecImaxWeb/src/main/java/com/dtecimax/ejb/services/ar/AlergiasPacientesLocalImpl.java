package com.dtecimax.ejb.services.ar;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.ar.AlergiasPacientesDao;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;

@Stateless 
public class AlergiasPacientesLocalImpl implements AlergiasPacientesLocal {

	@Inject 
	AlergiasPacientesDao alergiasPacientesDao;
	
	@Override
	public void insetAlergiasPacientes(AlergiasPacientesDto pAlergiasPacientesDto) {
		alergiasPacientesDao.insetAlergiasPacientes(pAlergiasPacientesDto);
	}

	@Override
	public List<AlergiasPacientesDto> findSelectItems() {
		return alergiasPacientesDao.findSelectItems();
	}

	@Override
	public List<AlergiasPacientesDto> findAll() {
		return alergiasPacientesDao.findAll();
	}

	@Override
	public void updateAlergiasPacientes(long pNumeroAlergia, AlergiasPacientesDto pAlergiasPacientesDto) {
		alergiasPacientesDao.updateAlergiasPacientes(pNumeroAlergia, pAlergiasPacientesDto);	
	}

	@Override
	public void deleteAlergiasPacientes(long pNumeroAlergia) {
		alergiasPacientesDao.deleteAlergiasPacientes(pNumeroAlergia);
	}

}
