package com.dtecimax.ejb.services.hr;

import java.util.List;
import javax.ejb.Local;

import com.dtecimax.jpa.dto.hr.DoctoresReferentesDto;

@Local
public interface DoctoresReferentesLocal {
	
	public void insertDoctoresReferentes(DoctoresReferentesDto pDoctoresReferentesDto);
	
	public List<DoctoresReferentesDto> findSelectItems();
	
	public List<DoctoresReferentesDto> findAll();
	
    public void deleteDoctoresReferentes(long pNumeroDoctorReferente);
	
	public void updateDoctoresReferentes(long pNumeroDoctorReferente,DoctoresReferentesDto pDoctoresReferentesDto);
	
	public DoctoresReferentesDto findByNumeroDoctorReferente(long pNumeroDoctorReferente);

	public List<DoctoresReferentesDto> findBySearch(String pSearchNomDoct
			                             ,String pSearchApellPatDoc
			                             ,String pSearchApellMatDoc
			                             );
	
}
