package com.dtecimax.jpa.dao.hr;

import java.util.List;

import com.dtecimax.jpa.dto.hr.DoctoresReferentesDto;

public interface DoctoresReferentesDao {
	
	public void insertDoctoresReferentes(DoctoresReferentesDto pDoctoresReferentesDto);
	
	public List<DoctoresReferentesDto> findSelectItems();
	
	public List<DoctoresReferentesDto> findAll();
	
	public void deleteDoctoresReferentes(long pNumeroDoctorReferentes);
	
	public void updateDoctoresReferentes(long pNumeroDoctorReferentes,DoctoresReferentesDto pDoctoresReferentesDto);
	
	public DoctoresReferentesDto findByNumeroDoctorReferente(long pNumeroDoctorReferentes);

	public List<DoctoresReferentesDto> findBySearch(String pSearchNomDoct
            ,String pSearchApellPatDoc
            ,String pSearchApellMatDoc
            );

}
