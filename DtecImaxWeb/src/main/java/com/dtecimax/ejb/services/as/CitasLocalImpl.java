package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.CitasDao;
import com.dtecimax.jpa.dto.as.CitasDto;

@Stateless 
public class CitasLocalImpl implements CitasLocal{

	@Inject
	CitasDao citasDao;
	
	@Override
	public void insertCitas(CitasDto pCitasDto) {
		citasDao.insertCitas(pCitasDto);	
	}

	@Override
	public List<CitasDto> findSelectItems() {
		return citasDao.findSelectItems();
	}

	@Override
	public List<CitasDto> findAll() {
		return citasDao.findAll();
	}

	@Override
	public CitasDto findByNumeroCita(long pNumeroCita) {
		return citasDao.findByNumeroCita(pNumeroCita);
	}

	@Override
	public List<CitasDto> findAllByNumDoc(long pNumeroDoctor
			                             ,String pSearchTipoEstu
			                             ) {
		return citasDao.findAllByNumDoc(pNumeroDoctor
				                       ,pSearchTipoEstu
				                       );
	}

	@Override
	public void actualizaCitas(CitasDto pCitasDto, long pNumeroCita) {
		citasDao.actualizaCitas(pCitasDto, pNumeroCita);
	}

	@Override
	public void deleteCita(long pNumeroCita) {
		citasDao.deleteCita(pNumeroCita);
	}

}
