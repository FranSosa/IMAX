package com.dtecimax.ejb.backing.as;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;
import com.dtecimax.ejb.model.as.Estudios;
import com.dtecimax.ejb.services.as.EstudiosLocal;
import com.dtecimax.jpa.dto.as.EstudiosDto;




@ManagedBean  
@ViewScoped
public class EstudiosForm {

	@ManagedProperty(value="#{estudios}") 
	private Estudios estudios;

	private Estudios estudiosSelected;
	
	private List<Estudios> listEstudios = new ArrayList<Estudios>();
	
	@Inject
	EstudiosLocal estudiosLocal;

	private String searchNomEstu; 
	


	
	 @PostConstruct
	 public void init() {
		 refreshEntity();
	 }
		 	 
	  private void refreshEntity() { 
		  listEstudios = new ArrayList<Estudios>();	  
		  List<EstudiosDto> listEstudiosDto = estudiosLocal.findSelectItems(); 
		  Iterator<EstudiosDto> iterEstudiosDto = listEstudiosDto.iterator();
		  while(iterEstudiosDto.hasNext()) { 
			  EstudiosDto estudiosDto =iterEstudiosDto.next(); 
			  Estudios estudios = new Estudios();
			 
			  estudios.setNumeroEstudio(estudiosDto.getNumeroEstudio());
			  estudios.setNombreEstudio(estudiosDto.getNombreEstudio());
			  estudios.setTipoEstudio(estudiosDto.getTipoEstudio());
			  estudios.setCostoEstudio(estudiosDto.getCostoEstudio());
			  estudios.setRealizaEstudio(estudiosDto.getRealizaEstudio());
			  estudios.setNumeroUbicacion(estudiosDto.getNumeroUbicacion());
			  estudios.setComentarios(estudiosDto.getComentarios());
			  estudios.setEstatus(estudiosDto.getEstatus());
			  estudios.setFechaCreacion(estudiosDto.getFechaCreacion());
			  estudios.setFechaUltimaActualizacion(estudiosDto.getFechaUltimaActualizacion());
			  estudios.setColorEstudio(estudiosDto.getColorEstudio());
			  
			  listEstudios.add(estudios); 
		  }
	  }
	 

	
	public void insertaEstudios() {
		
		boolean loggedIn = false;
		System.out.println("Comienza insertaEstudios");
		
		
		EstudiosDto estudiosDto = new EstudiosDto();
		
		estudiosDto.setNombreEstudio(estudios.getNombreEstudio());
		estudiosDto.setTipoEstudio(estudios.getTipoEstudio());
		estudiosDto.setCostoEstudio(estudios.getCostoEstudio());
		estudiosDto.setRealizaEstudio(estudios.getRealizaEstudio());
		estudiosDto.setNumeroUbicacion(estudios.getNumeroUbicacion());
		estudiosDto.setEstatus(estudios.getEstatus());
		estudiosDto.setComentarios(estudios.getComentarios());
		estudiosDto.setFechaCreacion(estudios.getFechaCreacion());
		estudiosDto.setFechaUltimaActualizacion(estudios.getFechaUltimaActualizacion());
		estudiosDto.setColorEstudio(estudios.getColorEstudio());
		
		estudiosLocal.insertEstudios(estudiosDto);

		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
		refreshEntity();
	}
	
	public void selectForDelete(Estudios pEstudios) {
		System.out.println("Entra  selectForDelete Estudios Form");
	    System.out.println(pEstudios); estudiosSelected = pEstudios;
														 
	}
	
	public void selectForUpdate(Estudios pEstudios) {
		System.out.println("Entra selectForUpdate");
		System.out.println(pEstudios);
		
		estudiosSelected = new Estudios();
		
		estudiosSelected.setNumeroEstudio(pEstudios.getNumeroEstudio());
		estudiosSelected.setNombreEstudio(pEstudios.getNombreEstudio());
		estudiosSelected.setTipoEstudio(pEstudios.getTipoEstudio());
		estudiosSelected.setCostoEstudio(pEstudios.getCostoEstudio());
		estudiosSelected.setRealizaEstudio(pEstudios.getRealizaEstudio());
		estudiosSelected.setNumeroUbicacion(pEstudios.getNumeroUbicacion());
		estudiosSelected.setComentarios(pEstudios.getComentarios());
		estudiosSelected.setEstatus(pEstudios.getEstatus());
		estudiosSelected.setColorEstudio(pEstudios.getColorEstudio());
	}
	
	public void delete() {
		System.out.println("Entra Delete Estudios Form");
		System.out.println(this.estudiosSelected);
		if(null!=estudiosSelected) {
			estudiosLocal.deleteEstudios(estudiosSelected.getNumeroEstudio());
			refreshEntity();
		}
	}
	
	 public void actualizaEstudio() {
	    	System.out.println("Entra actualizaEstudio Form");
			System.out.println(this.estudiosSelected);
			boolean updatedIn = false;
			
			EstudiosDto estudiosDto = new EstudiosDto();
			estudiosDto.setNombreEstudio(estudiosSelected.getNombreEstudio());
			estudiosDto.setTipoEstudio(estudiosSelected.getTipoEstudio());
			estudiosDto.setCostoEstudio(estudiosSelected.getCostoEstudio());
			estudiosDto.setRealizaEstudio(estudiosSelected.getRealizaEstudio());
			estudiosDto.setNumeroUbicacion(estudiosSelected.getNumeroUbicacion());
			estudiosDto.setComentarios(estudiosSelected.getComentarios());
			estudiosDto.setEstatus(estudiosSelected.getEstatus());
			estudiosDto.setFechaUltimaActualizacion(estudiosSelected.getFechaUltimaActualizacion());
			estudiosDto.setColorEstudio(estudiosSelected.getColorEstudio());
			
			estudiosLocal.updateEstudios(estudiosSelected.getNumeroEstudio(), estudiosDto);
			refreshEntity();
			updatedIn = true;
			PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	    }		
	 
    public void search() {
    	if(null!=this.searchNomEstu&&!"".equals(this.searchNomEstu)) {
    	   	
    	  listEstudios = new ArrayList<Estudios>();	  
   		  List<EstudiosDto> listEstudiosDto = estudiosLocal.findBySearch(this.searchNomEstu);
   		  Iterator<EstudiosDto> iterEstudiosDto = listEstudiosDto.iterator();
   		  while(iterEstudiosDto.hasNext()) { 
   			  EstudiosDto estudiosDto =iterEstudiosDto.next(); 
   			  Estudios estudios = new Estudios();
   			 
   			  estudios.setNumeroEstudio(estudiosDto.getNumeroEstudio());
   			  estudios.setNombreEstudio(estudiosDto.getNombreEstudio());
   			  estudios.setTipoEstudio(estudiosDto.getTipoEstudio());
   			  estudios.setCostoEstudio(estudiosDto.getCostoEstudio());
   			  estudios.setRealizaEstudio(estudiosDto.getRealizaEstudio());
   			  estudios.setNumeroUbicacion(estudiosDto.getNumeroUbicacion());
   			  estudios.setComentarios(estudiosDto.getComentarios());
   			  estudios.setEstatus(estudiosDto.getEstatus());
   			  estudios.setFechaCreacion(estudiosDto.getFechaCreacion());
   			  estudios.setFechaUltimaActualizacion(estudiosDto.getFechaUltimaActualizacion());
   			  estudios.setColorEstudio(estudiosDto.getColorEstudio());
   			  
   			  listEstudios.add(estudios); 
   		  }
    		
    	}
    } 
    
	public Estudios getEstudios() {
		return estudios;
	}

	public void setEstudios(Estudios estudios) {
		this.estudios = estudios;
	}


	public List<Estudios> getListEstudios() {
		return listEstudios;
	}


	public void setListEstudios(List<Estudios> listEstudios) {
		this.listEstudios = listEstudios;
	}


	public Estudios getEstudiosSelected() {
		System.out.println("getEstudiosSelected:"+estudiosSelected);
		return estudiosSelected;
	}


	public void setEstudiosSelected(Estudios estudiosSelected) {
		this.estudiosSelected = estudiosSelected;
	}

	public String getSearchNomEstu() {
		return searchNomEstu;
	}

	public void setSearchNomEstu(String searchNomEstu) {
		this.searchNomEstu = searchNomEstu;
	}

	



}
