package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.EstudiosDto;

@Local
public interface EstudiosLocal {
	 public void insertEstudios(EstudiosDto pEstudiosDto);
	 
	 public List<EstudiosDto> findSelectItems();
		
		public void updateEstudios(long pNumeroEstudio, EstudiosDto pEstudiosDto);
		
		public List<EstudiosDto> findAll();
		
		public void deleteEstudios(long pNumeroEstudio); 
		
		public String findEstudioByNumero(long pNumeroEstudio);
		
		public EstudiosDto findByNumeroEstudio(long pNumeroEstudio); 
		
		public List<EstudiosDto> findBySearch(String pSearchNomEstu);
		
		 public List<String> findColorsEstudio(); 
		
}
