package com.dtecimax.ejb.services.hr;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.hr.DoctoresDao;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

@Stateless 
public class DoctoresLocalImpl implements DoctoresLocal {

	@Inject 
	DoctoresDao doctoresDao;
	
	@Override
	public void insertDoctores(DoctoresDto pDoctoresDto) {
		doctoresDao.insertDoctores(pDoctoresDto);
	}

	@Override
	public List<DoctoresDto> findSelectItems() {
		return doctoresDao.findSelectItems();
	}

	@Override
	public List<DoctoresDto> findAll() {
		return doctoresDao.findAll();
	}

	@Override
	public void deleteDoctores(long pNumeroDoctor) {
		doctoresDao.deleteDoctores(pNumeroDoctor);
	}

	@Override
	public void updateDoctores(long pNumeroDoctor, DoctoresDto pDoctoresDto) {
		doctoresDao.updateDoctores(pNumeroDoctor, pDoctoresDto);
	}

	@Override
	public DoctoresDto findByNumeroDoctor(long pNumeroDoctor) {
	  return doctoresDao.findByNumeroDoctor(pNumeroDoctor);
	}

	@Override
	public List<DoctoresDto> findBySearch(String pSearchNomDoct
			                             ,String pSearchApellPatDoc
			                             ,String pSearchApellMatDoc
			                             ) {
		return doctoresDao.findBySearch(pSearchNomDoct
				                       ,pSearchApellPatDoc
				                       ,pSearchApellMatDoc
				                       );
	}

}
