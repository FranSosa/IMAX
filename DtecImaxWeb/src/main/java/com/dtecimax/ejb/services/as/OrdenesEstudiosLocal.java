package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;

@Local
public interface OrdenesEstudiosLocal {
	public void insertOrdenesEstudios(OrdenesEstudiosDto pOrdenesEstudiosDto);

	public List<OrdenesEstudiosDto> findSelectItems();
	
	public List<OrdenesEstudiosDto> findAllDesc();
	
	public  List<OrdenesEstudiosDto> findAllEspeciales();
	
	public  List<OrdenesEstudiosDto> findAllContrastados();
	
	public List<OrdenesEstudiosDto> findAllDentales();
	
	public void deleteOrdenesEstudios(long pNumeroOrdenEstudio);
	public void updateOrdenesEstudios(long pNumeroOrden
                                     ,OrdenesEstudiosDto pOrdenesEstudiosDto
                                      );
	
	public List<OrdenesEstudiosDto> findBySearch(String pSearchTipo 
									            ,String pSeacrhNumEstu
									            ,String pSearchNomPaci
									            ,String pSearchNomDoct
									            );
}
