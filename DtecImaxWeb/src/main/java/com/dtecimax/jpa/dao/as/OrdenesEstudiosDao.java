package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;

public interface OrdenesEstudiosDao {

	public void insertOrdenesEstudios(OrdenesEstudiosDto pOrdenesEstudiosDto);

	public List<OrdenesEstudiosDto> findSelectItems();
	
	public List<OrdenesEstudiosDto> findAllDesc();
	
	public  List<OrdenesEstudiosDto> findAllEspeciales();
	
	public  List<OrdenesEstudiosDto> findAllContrastados();
	
	public  List<OrdenesEstudiosDto> findAllDentales();
	
	public void deleteOrdenesEstudios(long pNumeroOrdenEstudio);
	
	public void updateOrdenesEstudios(long pNumeroOrden,OrdenesEstudiosDto pOrdenesEstudiosDto);
	
	public List<OrdenesEstudiosDto> findBySearch(String pSearchTipo 
			                                    ,String pSeacrhNumEstu
								                ,String pSearchNomPaci
								                ,String pSearchNomDoct
								                );
	
}
