package com.dtecimax.ejb.backing.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import com.dtecimax.ejb.model.admin.Ubicaciones;
import com.dtecimax.ejb.services.admin.UbicacionesLocal;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;

@ManagedBean  
@ViewScoped
public class UbicacionesForm {

	@ManagedProperty(value="#{ubicaciones}") 
	private Ubicaciones ubicaciones;

	private Ubicaciones ubicacionesSelected;
	
	private List<Ubicaciones> listUbicaciones = new ArrayList<Ubicaciones>();
	
	@Inject
	UbicacionesLocal ubicacionesLocal;

	
	 @PostConstruct
	 public void init() {
		 System.out.println("UbicacionesForm init()");
		 
		 List<UbicacionesDto> listUbicacionesDto = ubicacionesLocal.findAll();
		 Iterator<UbicacionesDto> iterUbicacionesDto = listUbicacionesDto.iterator();
		 while(iterUbicacionesDto.hasNext()) {
			 UbicacionesDto ubicacionesDto = iterUbicacionesDto.next();
			 Ubicaciones ubicaciones = new Ubicaciones();
			 
			 ubicaciones.setNumeroUbicacion(ubicacionesDto.getNumeroUbicacion());
			 ubicaciones.setDomicilioUbicacion(ubicacionesDto.getDomicilioUbicacion());
			 ubicaciones.setCorreoUbicacion(ubicacionesDto.getCorreoUbicacion());
			 ubicaciones.setTelefonoUbicacion(ubicacionesDto.getTelefonoUbicacion());
			 ubicaciones.setHorarioUbicacion(ubicacionesDto.getHorarioUbicacion());
			 ubicaciones.setEstatus(ubicacionesDto.getEstatus());
			 ubicaciones.setComentarios(ubicacionesDto.getComentarios());
			 ubicaciones.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
			 
			 listUbicaciones.add(ubicaciones);
		 }
		 	 
	 }

	
	public void insertaUbicacion() {
		
		boolean loggedIn = false;
		System.out.println("Comienza insertaUbicacion");
		
		
		UbicacionesDto ubicacionesDto = new UbicacionesDto();
		
		ubicacionesDto.setNombreUbicacion(ubicaciones.getNombreUbicacion());
		ubicacionesDto.setDomicilioUbicacion(ubicaciones.getDomicilioUbicacion());
		ubicacionesDto.setCorreoUbicacion(ubicaciones.getCorreoUbicacion());
		ubicacionesDto.setTelefonoUbicacion(ubicaciones.getTelefonoUbicacion());
		ubicacionesDto.setHorarioUbicacion(ubicaciones.getHorarioUbicacion());
		ubicacionesDto.setEstatus(ubicaciones.getEstatus());
		ubicacionesDto.setFechaCreacion(ubicaciones.getFechaCreacion());
		ubicacionesDto.setFechaUltimaActualizacion(ubicaciones.getFechaUltimaActualizacion());
		ubicacionesDto.setComentarios(ubicaciones.getComentarios());
		
		ubicacionesLocal.insertUbicaciones(ubicacionesDto);

		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
		refreshEntity();
		this.ubicaciones.clean();
	}
	
	public void selectForDelete(Ubicaciones pUbicaciones) {
		System.out.println("Entra  selectForDelete Ubicaciones Form");
		System.out.println(pUbicaciones);
		ubicacionesSelected = pUbicaciones;	
	}
	
	public void selectForUpdate(Ubicaciones pUbicaciones) {
		System.out.println("Entra selectForUpdate");
		System.out.println(pUbicaciones);
		
		ubicacionesSelected = new Ubicaciones();
		
		ubicacionesSelected.setNumeroUbicacion(pUbicaciones.getNumeroUbicacion());
		ubicacionesSelected.setNombreUbicacion(pUbicaciones.getNombreUbicacion());
		ubicacionesSelected.setDomicilioUbicacion(pUbicaciones.getDomicilioUbicacion());
		ubicacionesSelected.setCorreoUbicacion(pUbicaciones.getCorreoUbicacion());
		ubicacionesSelected.setTelefonoUbicacion(pUbicaciones.getTelefonoUbicacion());
		ubicacionesSelected.setHorarioUbicacion(pUbicaciones.getHorarioUbicacion());
		ubicacionesSelected.setComentarios(pUbicaciones.getComentarios());
		ubicacionesSelected.setEstatus(pUbicaciones.getEstatus());
		
	}
	
	public void delete() {
		System.out.println("Entra Delete Ubicaciones Form");
		System.out.println(this.ubicacionesSelected);
		if(null!=ubicacionesSelected) {
			ubicacionesLocal.deleteUbicaciones(ubicacionesSelected.getNumeroUbicacion());
			refreshEntity();
		}
	}
	
	 public void actualizaUbicacion() {
	    	System.out.println("Entra actualizaUbicacion Form");
			System.out.println(this.ubicacionesSelected);
			boolean updatedIn = false;
			
			UbicacionesDto ubicacionesDto = new UbicacionesDto();
			
			ubicacionesDto.setNombreUbicacion(ubicacionesSelected.getNombreUbicacion());
			ubicacionesDto.setDomicilioUbicacion(ubicacionesSelected.getDomicilioUbicacion());
			ubicacionesDto.setCorreoUbicacion(ubicacionesSelected.getCorreoUbicacion());
			ubicacionesDto.setHorarioUbicacion(ubicacionesSelected.getHorarioUbicacion());
			ubicacionesDto.setTelefonoUbicacion(ubicacionesSelected.getTelefonoUbicacion());
			ubicacionesDto.setComentarios(ubicacionesSelected.getComentarios());
			ubicacionesDto.setEstatus(ubicacionesSelected.getEstatus());
			
			ubicacionesLocal.updateUbicaciones(ubicacionesSelected.getNumeroUbicacion(), ubicacionesDto);
			refreshEntity();
			updatedIn = true;
			PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	    }		
	
	public Ubicaciones getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(Ubicaciones ubicaciones) {
		this.ubicaciones = ubicaciones;
	}


	public List<Ubicaciones> getListUbicaciones() {
		return listUbicaciones;
	}


	public void setListUbicaciones(List<Ubicaciones> listUbicaciones) {
		this.listUbicaciones = listUbicaciones;
	}


	public Ubicaciones getUbicacionesSelected() {
		System.out.println("getUbicacionesSelected:"+ubicacionesSelected);
		return ubicacionesSelected;
	}


	public void setUbicacionesSelected(Ubicaciones ubicacionesSelected) {
		this.ubicacionesSelected = ubicacionesSelected;
	}
	
	private void refreshEntity() {
		 List<UbicacionesDto> listUbicacionesDto = ubicacionesLocal.findAll();
		 Iterator<UbicacionesDto> iterUbicacionesDto = listUbicacionesDto.iterator();
		 listUbicaciones = new ArrayList<Ubicaciones>();
		 while(iterUbicacionesDto.hasNext()) {
			 UbicacionesDto ubicacionesDto = iterUbicacionesDto.next();
			 Ubicaciones ubicaciones = new Ubicaciones();
			 
			 ubicaciones.setNumeroUbicacion(ubicacionesDto.getNumeroUbicacion());
			 ubicaciones.setDomicilioUbicacion(ubicacionesDto.getDomicilioUbicacion());
			 ubicaciones.setCorreoUbicacion(ubicacionesDto.getCorreoUbicacion());
			 ubicaciones.setTelefonoUbicacion(ubicacionesDto.getTelefonoUbicacion());
			 ubicaciones.setHorarioUbicacion(ubicacionesDto.getHorarioUbicacion());
			 ubicaciones.setEstatus(ubicacionesDto.getEstatus());
			 ubicaciones.setComentarios(ubicacionesDto.getComentarios());
			 ubicaciones.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
			 
			 listUbicaciones.add(ubicaciones);
		 }
		 
	}

}
