package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.EstudiosDao;
import com.dtecimax.jpa.dto.as.EstudiosDto;



@Stateless 
public class EstudiosLocalImpl implements EstudiosLocal {

	@Inject
	EstudiosDao estudiosDao;
	
	@Override
	public void insertEstudios(EstudiosDto pEstudiosDto) {
		estudiosDao.insertEstudios(pEstudiosDto);
	}
	
	@Override
	public List<EstudiosDto> findSelectItems() {
		return estudiosDao.findSelectItems();
	}

	

	@Override
	public void deleteEstudios(long pNumeroEstudio) {
		estudiosDao.deleteEstudios(pNumeroEstudio);
	}

	@Override
	public void updateEstudios(long pNumeroEstudio, EstudiosDto pEstudiosDto) {
		estudiosDao.updateEstudios(pNumeroEstudio, pEstudiosDto);
	}

	@Override
	public List<EstudiosDto> findAll() {
		return null;
	}

	@Override
	public String findEstudioByNumero(long pNumeroEstudio) {
		return estudiosDao.findEstudioByNumero(pNumeroEstudio);
	}

	@Override
	public EstudiosDto findByNumeroEstudio(long pNumeroEstudio) {
		return estudiosDao.findByNumeroEstudio(pNumeroEstudio);
	}

	@Override
	public List<EstudiosDto> findBySearch(String pSearchNomEstu) {
		return estudiosDao.findBySearch(pSearchNomEstu);
	}

	@Override
	public List<String> findColorsEstudio() {
		return estudiosDao.findColorsEstudio();
	}

	
}
