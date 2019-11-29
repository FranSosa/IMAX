package com.dtecimax.ejb.services.hr;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.hr.DoctoresReferentesDao;
import com.dtecimax.jpa.dto.hr.DoctoresReferentesDto;

@Stateless 
public class DoctoresReferentesLocalImpl implements DoctoresReferentesLocal {

	@Inject 
	DoctoresReferentesDao doctoresReferentesDao;
	
	

	@Override
	public List<DoctoresReferentesDto> findSelectItems() {
		return doctoresReferentesDao.findSelectItems();
	}

	@Override
	public List<DoctoresReferentesDto> findAll() {
		return doctoresReferentesDao.findAll();
	}

	@Override
	public void deleteDoctoresReferentes(long pNumeroDoctorReferente) {
		doctoresReferentesDao.deleteDoctoresReferentes(pNumeroDoctorReferente);
	}

	@Override
	public void updateDoctoresReferentes(long pNumeroDoctorReferentes, DoctoresReferentesDto pDoctoresReferentesDto) {
		doctoresReferentesDao.updateDoctoresReferentes(pNumeroDoctorReferentes, pDoctoresReferentesDto);
	}

	@Override
	public DoctoresReferentesDto findByNumeroDoctorReferente(long pNumeroDoctorReferente) {
	  return doctoresReferentesDao.findByNumeroDoctorReferente(pNumeroDoctorReferente);
	}

	@Override
	public void insertDoctoresReferentes(DoctoresReferentesDto pDoctoresReferentesDto) {
		doctoresReferentesDao.insertDoctoresReferentes(pDoctoresReferentesDto);
		
	}
	@Override
	public List<DoctoresReferentesDto> findBySearch(String pSearchNomDoct
			                             ,String pSearchApellPatDoc
			                             ,String pSearchApellMatDoc
			                             ) {
		return doctoresReferentesDao.findBySearch(pSearchNomDoct
				                       ,pSearchApellPatDoc
				                       ,pSearchApellMatDoc
				                       );
	}


}
