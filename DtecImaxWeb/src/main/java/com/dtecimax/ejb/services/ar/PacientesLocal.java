package com.dtecimax.ejb.services.ar;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.ar.PacientesDto;

@Local
public interface PacientesLocal {

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
