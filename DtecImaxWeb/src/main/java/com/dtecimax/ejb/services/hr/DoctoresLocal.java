package com.dtecimax.ejb.services.hr;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.hr.DoctoresDto;

@Local
public interface DoctoresLocal {
	
	public void insertDoctores(DoctoresDto pDoctoresDto);
	
	public List<DoctoresDto> findSelectItems();
	
	public List<DoctoresDto> findAll();
	
    public void deleteDoctores(long pNumeroDoctor);
	
	public void updateDoctores(long pNumeroDoctor,DoctoresDto pDoctoresDto);
	
	public DoctoresDto findByNumeroDoctor(long pNumeroDoctor); 
	
	public List<DoctoresDto> findBySearch(String pSearchNomDoct
			                             ,String pSearchApellPatDoc
			                             ,String pSearchApellMatDoc
			                             );
	
}
