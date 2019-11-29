package com.dtecimax.ejb.services.ar;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.ar.PacientesDao;
import com.dtecimax.jpa.dto.ar.PacientesDto;

@Stateless 
public class PacientesLocalImpl implements PacientesLocal {

	@Inject
	PacientesDao pacientesDao;
	
	@Override
	public void insertPacientes(PacientesDto pPacientesDto) {
		pacientesDao.insertPacientes(pPacientesDto);
	}

	@Override
	public List<PacientesDto> findSelectItems() {
		return pacientesDao.findSelectItems();
	}

	@Override
	public void deletePacientes(long pNumeroPaciente) {
		pacientesDao.deletePacientes(pNumeroPaciente);
	}

	@Override
	public void updatePacientes(long pNumeroPaciente, PacientesDto pPacientesDto) {
		pacientesDao.updatePacientes(pNumeroPaciente, pPacientesDto);
	}

	@Override
	public PacientesDto findByNumeroPaciente(long pNumeroPaciente) {
		return pacientesDao.findByNumeroPaciente(pNumeroPaciente);
	}

	@Override
	public List<PacientesDto> findBySearch(String pSearchNomPaci
			                             , String pSearchApellPatPaci
			                             , String pSearchApellMatPaci) {
		return pacientesDao.findBySearch(pSearchNomPaci
				                       , pSearchApellPatPaci
				                       , pSearchApellMatPaci);
	}

}
