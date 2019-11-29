package com.dtecimax.ejb.backing.ar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import com.dtecimax.ejb.model.ar.Pacientes;
import com.dtecimax.ejb.services.ar.PacientesLocal;
import com.dtecimax.jpa.dto.ar.PacientesDto;

@ManagedBean  
@ViewScoped
public class PacientesForm {

	@ManagedProperty(value="#{pacientes}") 
	private Pacientes pacientes;
	
	private List<Pacientes> listPacientes =new ArrayList<Pacientes>();
	
	private Pacientes pacientesSelected = new Pacientes();
	
	@Inject
	PacientesLocal pacientesLocal; 
	
	private String searchNomPaci; 
	private String searchApellPatPaci; 
	private String searchApellMatPaci; 
	
	 @PostConstruct
	 public void init() {
		 refreshEntity(); 
	 }
	 
	public void refreshEntity() {
		listPacientes =new ArrayList<Pacientes>();
		List<PacientesDto> listPacientesDto = pacientesLocal.findSelectItems();
		Iterator<PacientesDto>  iterPacientesDto =  listPacientesDto.iterator();
		while(iterPacientesDto.hasNext()) {
			PacientesDto pacientesDto = iterPacientesDto.next(); 
			Pacientes pacientes = new Pacientes(); 
			
			pacientes.setNumeroPaciente(pacientesDto.getNumeroPaciente());
			pacientes.setNombrePaciente(pacientesDto.getNombrePaciente());
			pacientes.setApellidoPaternoPaciente(pacientesDto.getApellidoPaternoPaciente());
			pacientes.setApellidoMaternoPaciente(pacientesDto.getApellidoMaternoPaciente());
			pacientes.setCelularPaciente(pacientesDto.getCelularPaciente());
			pacientes.setCorreoPaciente(pacientesDto.getCorreoPaciente());
			pacientes.setCurpPaciente(pacientesDto.getCurpPaciente());
			pacientes.setDomicilioPaciente(pacientesDto.getDomicilioPaciente());
			pacientes.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			pacientes.setEstatus(pacientesDto.getEstatus());
			pacientes.setFechaCreacion(pacientesDto.getFechaCreacion());
			pacientes.setFechaUltimaActualizacion(pacientesDto.getFechaUltimaActualizacion());
			pacientes.setComentarios(pacientesDto.getComentarios());
			listPacientes.add(pacientes);	
		}
	}
	
	public void insertPacientes() {
		  boolean loggedIn = false;
		
	      PacientesDto pacientesDto = new PacientesDto();
	      
	      pacientesDto.setNombrePaciente(pacientes.getNombrePaciente());
	      pacientesDto.setApellidoPaternoPaciente(pacientes.getApellidoPaternoPaciente());
	      pacientesDto.setApellidoMaternoPaciente(pacientes.getApellidoMaternoPaciente());
	      pacientesDto.setCelularPaciente(pacientes.getCelularPaciente());
	      pacientesDto.setCorreoPaciente(pacientes.getCorreoPaciente());
	      pacientesDto.setCurpPaciente(pacientes.getCurpPaciente());
	      pacientesDto.setDomicilioPaciente(pacientes.getDomicilioPaciente());
	      pacientesDto.setFechaNacimientoPaciente(pacientes.getFechaNacimientoPaciente());
	      pacientesDto.setEstatus(pacientes.getEstatus());
	      pacientesDto.setFechaCreacion(pacientes.getFechaCreacion());
	      pacientesDto.setFechaUltimaActualizacion(pacientes.getFechaUltimaActualizacion());
	      pacientesDto.setComentarios(pacientes.getComentarios());
			
	      pacientesLocal.insertPacientes(pacientesDto);
	      refreshEntity();
	      loggedIn = true;
	      PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
			
		}
	
	public void selectForUpdate(Pacientes pPacientes) {
		
		pacientesSelected.setNumeroPaciente(pPacientes.getNumeroPaciente());
		pacientesSelected.setNombrePaciente(pPacientes.getNombrePaciente());
		pacientesSelected.setApellidoPaternoPaciente(pPacientes.getApellidoPaternoPaciente());
		pacientesSelected.setApellidoMaternoPaciente(pPacientes.getApellidoMaternoPaciente());
		pacientesSelected.setCelularPaciente(pPacientes.getCelularPaciente());
		pacientesSelected.setCorreoPaciente(pPacientes.getCorreoPaciente());
		pacientesSelected.setCurpPaciente(pPacientes.getCurpPaciente());
		pacientesSelected.setDomicilioPaciente(pPacientes.getDomicilioPaciente());
		pacientesSelected.setFechaNacimientoPaciente(pPacientes.getFechaNacimientoPaciente());
		pacientesSelected.setEstatus(pPacientes.getEstatus());
		pacientesSelected.setFechaCreacion(pPacientes.getFechaCreacion());
		pacientesSelected.setFechaUltimaActualizacion(pPacientes.getFechaUltimaActualizacion());
		pacientesSelected.setComentarios(pPacientes.getComentarios());
	    
	}
	
	public void selectForDelete(Pacientes pPacientes) {
		
		pacientesSelected.setNumeroPaciente(pPacientes.getNumeroPaciente());
		pacientesSelected.setNombrePaciente(pPacientes.getNombrePaciente());
		pacientesSelected.setApellidoPaternoPaciente(pPacientes.getApellidoPaternoPaciente());
		pacientesSelected.setApellidoMaternoPaciente(pPacientes.getApellidoMaternoPaciente());
		pacientesSelected.setCelularPaciente(pPacientes.getCelularPaciente());
		pacientesSelected.setCorreoPaciente(pPacientes.getCorreoPaciente());
		pacientesSelected.setCurpPaciente(pPacientes.getCurpPaciente());
		pacientesSelected.setDomicilioPaciente(pPacientes.getDomicilioPaciente());
		pacientesSelected.setFechaNacimientoPaciente(pPacientes.getFechaNacimientoPaciente());
		pacientesSelected.setEstatus(pPacientes.getEstatus());
		pacientesSelected.setFechaCreacion(pPacientes.getFechaCreacion());
		pacientesSelected.setFechaUltimaActualizacion(pPacientes.getFechaUltimaActualizacion());
		pacientesSelected.setComentarios(pPacientes.getComentarios());
	    
	}
	
	public void delete() {
	 
	 try {
	 pacientesLocal.deletePacientes(pacientesSelected.getNumeroPaciente());
	 }catch(Exception e) {
		 Throwable throwable = e.getCause();
		 while(null!=throwable) {
			 throwable = throwable.getCause();
			 if(null!=throwable) {
				 if(throwable.toString().contains("CITAS_FK_V3")) {
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se puede eliminar un paciente con una cita."));
					 break;
				 }
			 }
		 }
		
	 }
	  refreshEntity(); 
	}
	
	public void update() {
		 boolean updatedIn = false;
		  PacientesDto pacientesDto = new PacientesDto();
	      
	      pacientesDto.setNombrePaciente(pacientesSelected.getNombrePaciente());
	      pacientesDto.setApellidoPaternoPaciente(pacientesSelected.getApellidoPaternoPaciente());
	      pacientesDto.setApellidoMaternoPaciente(pacientesSelected.getApellidoMaternoPaciente());
	      pacientesDto.setCelularPaciente(pacientesSelected.getCelularPaciente());
	      pacientesDto.setCorreoPaciente(pacientesSelected.getCorreoPaciente());
	      pacientesDto.setCurpPaciente(pacientesSelected.getCurpPaciente());
	      pacientesDto.setDomicilioPaciente(pacientesSelected.getDomicilioPaciente());
	      pacientesDto.setFechaNacimientoPaciente(pacientesSelected.getFechaNacimientoPaciente());
	      System.out.println("*"+pacientesSelected.getEstatus());
	      pacientesDto.setEstatus(pacientesSelected.getEstatus());
	      pacientesDto.setFechaCreacion(pacientesSelected.getFechaCreacion());
	      pacientesDto.setFechaUltimaActualizacion(pacientesSelected.getFechaUltimaActualizacion());
	      pacientesDto.setComentarios(pacientesSelected.getComentarios());
	      pacientesLocal.updatePacientes(pacientesSelected.getNumeroPaciente(), pacientesDto);
	      refreshEntity(); 
	      updatedIn = true;
		  PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void search() {
		
	System.out.println("searchNomPaci:"+searchNomPaci);
	System.out.println("searchApellPatPaci:"+searchApellPatPaci);
	System.out.println("searchApellMatPaci:"+searchApellMatPaci);
	if((null!=this.searchNomPaci&&!"".equals(this.searchNomPaci))
	 ||(null!=this.searchApellPatPaci&&!"".equals(this.searchApellPatPaci))
	 ||(null!=this.searchApellMatPaci&&!"".equals(this.searchApellMatPaci))
	 ) {
		
		listPacientes =new ArrayList<Pacientes>();
		List<PacientesDto> listPacientesDto = pacientesLocal.findBySearch(this.searchNomPaci
				                                                        , this.searchApellPatPaci
				                                                        , this.searchApellMatPaci
				                                                        );
		Iterator<PacientesDto>  iterPacientesDto =  listPacientesDto.iterator();
		while(iterPacientesDto.hasNext()) {
			PacientesDto pacientesDto = iterPacientesDto.next(); 
			Pacientes pacientes = new Pacientes(); 
			
			pacientes.setNumeroPaciente(pacientesDto.getNumeroPaciente());
			pacientes.setNombrePaciente(pacientesDto.getNombrePaciente());
			pacientes.setApellidoPaternoPaciente(pacientesDto.getApellidoPaternoPaciente());
			pacientes.setApellidoMaternoPaciente(pacientesDto.getApellidoMaternoPaciente());
			pacientes.setCelularPaciente(pacientesDto.getCelularPaciente());
			pacientes.setCorreoPaciente(pacientesDto.getCorreoPaciente());
			pacientes.setCurpPaciente(pacientesDto.getCurpPaciente());
			pacientes.setDomicilioPaciente(pacientesDto.getDomicilioPaciente());
			pacientes.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			pacientes.setEstatus(pacientesDto.getEstatus());
			pacientes.setFechaCreacion(pacientesDto.getFechaCreacion());
			pacientes.setFechaUltimaActualizacion(pacientesDto.getFechaUltimaActualizacion());
			pacientes.setComentarios(pacientesDto.getComentarios());
			listPacientes.add(pacientes);	
		}
		
	}
		
	}
	
	
	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public List<Pacientes> getListPacientes() {
		return listPacientes;
	}

	public void setListPacientes(List<Pacientes> listPacientes) {
		this.listPacientes = listPacientes;
	}

	public Pacientes getPacientesSelected() {
		return pacientesSelected;
	}

	public void setPacientesSelected(Pacientes pacientesSelected) {
		this.pacientesSelected = pacientesSelected;
	}

	public String getSearchNomPaci() {
		return searchNomPaci;
	}

	public void setSearchNomPaci(String searchNomPaci) {
		this.searchNomPaci = searchNomPaci;
	}

	public String getSearchApellPatPaci() {
		return searchApellPatPaci;
	}

	public void setSearchApellPatPaci(String searchApellPatPaci) {
		this.searchApellPatPaci = searchApellPatPaci;
	}

	public String getSearchApellMatPaci() {
		return searchApellMatPaci;
	}

	public void setSearchApellMatPaci(String searchApellMatPaci) {
		this.searchApellMatPaci = searchApellMatPaci;
	}
	
}
