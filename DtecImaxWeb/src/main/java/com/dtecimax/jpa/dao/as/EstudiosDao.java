package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.EstudiosDto;

public interface EstudiosDao {

	 public void insertEstudios(EstudiosDto pEstudiosDto);
	 
	 public List<EstudiosDto> findSelectItems();
	 
	 public List<EstudiosDto> findAll();
	
	 public void updateEstudios(long pNumeroEstudio
                               ,EstudiosDto pEstudiosDto
                               );

     public void deleteEstudios(long pNumeroEstudio);
     
     public EstudiosDto findByNumeroEstudio(long pNumeroEstudio);
     
     public String findEstudioByNumero(long pNumeroEstudio);
     
     public List<EstudiosDto> findBySearch(String pSearchNomEstu);
     
     public List<String> findColorsEstudio(); 

}
