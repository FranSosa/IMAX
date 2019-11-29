package com.dtecimax.jpa.dao.hr;

import java.util.List;

import com.dtecimax.jpa.dto.hr.DoctoresDto;

public interface DoctoresDao {
	
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
