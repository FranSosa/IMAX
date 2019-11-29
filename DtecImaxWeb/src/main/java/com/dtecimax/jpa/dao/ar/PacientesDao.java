package com.dtecimax.jpa.dao.ar;

import java.util.List;

import com.dtecimax.jpa.dto.ar.PacientesDto;

public interface PacientesDao {
   
	public void insertPacientes(PacientesDto pPacientesDto);
	
	public void deletePacientes(long pNumeroPaciente);
	
	public void updatePacientes(long pNumeroPaciente,PacientesDto pPacientesDto);
	
	public List<PacientesDto> findSelectItems();
	
	public PacientesDto findByNumeroPaciente(long pNumeroPaciente);
	
	public List<PacientesDto> findBySearch(String pSearchNomPaci
										  ,String pSearchApellPatPaci
									      ,String pSearchApellMatPaci
										    );
	
}
