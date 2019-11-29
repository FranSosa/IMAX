package com.dtecimax.ejb.backing.hr;

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

import com.dtecimax.ejb.model.hr.Doctores;
import com.dtecimax.ejb.services.hr.DoctoresLocal;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

@ManagedBean  
@ViewScoped
public class DoctoresForm {

	@ManagedProperty(value="#{doctores}")
	private Doctores doctores;
	
	private Doctores doctoresSelected = new Doctores(); 
	
	private List<Doctores> listDoctores = new ArrayList<Doctores>();
	
	private String searchNomDoct; 
	private String searchApellPatDoct; 
	private String searchApellMatDoct; 
	
	
	@Inject
	DoctoresLocal doctoresLocal;

	@PostConstruct
	public void init() {
		refreshEntity();
	}
	
	private void refreshEntity() {
		listDoctores = new ArrayList<Doctores>();
		List<DoctoresDto> listDoctoresDto = doctoresLocal.findAll();
		Iterator<DoctoresDto> iterDoctoresDto =  listDoctoresDto.iterator();
		while(iterDoctoresDto.hasNext()) {
			DoctoresDto doctoresDto = iterDoctoresDto.next();
			Doctores doctores = new Doctores();
			doctores.setNumeroDoctor(doctoresDto.getNumeroDoctor());
			doctores.setNombreDoctor(doctoresDto.getNombreDoctor());
			doctores.setNumeroUbicacion(doctoresDto.getNumeroUbicacion());
			doctores.setApellidoMaternoDoctor(doctoresDto.getApellidoMaternoDoctor());
			doctores.setApellidoPaternoDoctor(doctoresDto.getApellidoPaternoDoctor());
			doctores.setFechaNacimientoDoctor(doctoresDto.getFechaNacimientoDoctor());
			doctores.setCedulaDoctor(doctoresDto.getCedulaDoctor());
			doctores.setCelularDoctor(doctoresDto.getCelularDoctor());
			doctores.setCurpDoctor(doctoresDto.getCurpDoctor());
			doctores.setDomicilioDoctor(doctoresDto.getDomicilioDoctor());
			doctores.setTipoDoctor(doctoresDto.getTipoDoctor());
			doctores.setCorreoDoctor(doctoresDto.getCorreoDoctor());
			doctores.setEstatus(doctoresDto.getEstatus());
			doctores.setFechaCreacion(doctoresDto.getFechaCreacion());
			doctores.setFechaUltimaActualizacion(doctoresDto.getFechaUltimaActualizacion());
			doctores.setComentarios(doctoresDto.getComentarios());
			listDoctores.add(doctores);
		}
		
	}
	 
	public void insertDoctores() {
		
		boolean loggedIn = false; 
		
		DoctoresDto doctoresDto = new DoctoresDto();
		
		doctoresDto.setNombreDoctor(doctores.getNombreDoctor());
		doctoresDto.setNumeroUbicacion(doctores.getNumeroUbicacion());
		doctoresDto.setApellidoMaternoDoctor(doctores.getApellidoMaternoDoctor());
		doctoresDto.setApellidoPaternoDoctor(doctores.getApellidoPaternoDoctor());
		doctoresDto.setFechaNacimientoDoctor(doctores.getFechaNacimientoDoctor());
		doctoresDto.setCedulaDoctor(doctores.getCedulaDoctor());
		doctoresDto.setCelularDoctor(doctores.getCelularDoctor());
		doctoresDto.setCurpDoctor(doctores.getCurpDoctor());
		doctoresDto.setDomicilioDoctor(doctores.getDomicilioDoctor());
		doctoresDto.setTipoDoctor(doctores.getTipoDoctor());
		doctoresDto.setCorreoDoctor(doctores.getCorreoDoctor());
		doctoresDto.setEstatus(doctores.getEstatus());
		doctoresDto.setFechaCreacion(doctores.getFechaCreacion());
		doctoresDto.setFechaUltimaActualizacion(doctores.getFechaUltimaActualizacion());
		doctoresDto.setComentarios(doctores.getComentarios());
		
		doctoresLocal.insertDoctores(doctoresDto);
		refreshEntity();
		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);

	}
	
	public void selectForUpdate(Doctores pDoctores) {
		doctoresSelected.setNumeroDoctor(pDoctores.getNumeroDoctor());
		doctoresSelected.setNombreDoctor(pDoctores.getNombreDoctor());
		doctoresSelected.setNumeroUbicacion(pDoctores.getNumeroUbicacion());
		doctoresSelected.setApellidoMaternoDoctor(pDoctores.getApellidoMaternoDoctor());
		doctoresSelected.setApellidoPaternoDoctor(pDoctores.getApellidoPaternoDoctor());
		doctoresSelected.setFechaNacimientoDoctor(pDoctores.getFechaNacimientoDoctor());
		doctoresSelected.setCedulaDoctor(pDoctores.getCedulaDoctor());
		doctoresSelected.setCelularDoctor(pDoctores.getCelularDoctor());
		doctoresSelected.setCurpDoctor(pDoctores.getCurpDoctor());
		doctoresSelected.setDomicilioDoctor(pDoctores.getDomicilioDoctor());
		doctoresSelected.setTipoDoctor(pDoctores.getTipoDoctor());
		doctoresSelected.setCorreoDoctor(pDoctores.getCorreoDoctor());
		doctoresSelected.setEstatus(pDoctores.getEstatus());
		doctoresSelected.setFechaCreacion(pDoctores.getFechaCreacion());
		doctoresSelected.setFechaUltimaActualizacion(pDoctores.getFechaUltimaActualizacion());
		doctoresSelected.setComentarios(pDoctores.getComentarios());
	}
	
	public void selectForDelete(Doctores pDoctores) {
		doctoresSelected.setNumeroDoctor(pDoctores.getNumeroDoctor());
		doctoresSelected.setNombreDoctor(pDoctores.getNombreDoctor());
		doctoresSelected.setNumeroUbicacion(pDoctores.getNumeroUbicacion());
		doctoresSelected.setApellidoMaternoDoctor(pDoctores.getApellidoMaternoDoctor());
		doctoresSelected.setApellidoPaternoDoctor(pDoctores.getApellidoPaternoDoctor());
		doctoresSelected.setFechaNacimientoDoctor(pDoctores.getFechaNacimientoDoctor());
		doctoresSelected.setCedulaDoctor(pDoctores.getCedulaDoctor());
		doctoresSelected.setCelularDoctor(pDoctores.getCelularDoctor());
		doctoresSelected.setCurpDoctor(pDoctores.getCurpDoctor());
		doctoresSelected.setDomicilioDoctor(pDoctores.getDomicilioDoctor());
		doctoresSelected.setTipoDoctor(pDoctores.getTipoDoctor());
		doctoresSelected.setCorreoDoctor(pDoctores.getCorreoDoctor());
		doctoresSelected.setEstatus(pDoctores.getEstatus());
		doctoresSelected.setFechaCreacion(pDoctores.getFechaCreacion());
		doctoresSelected.setFechaUltimaActualizacion(pDoctores.getFechaUltimaActualizacion());
		doctoresSelected.setComentarios(pDoctores.getComentarios());
	}
	
	public void delete() {
		try {
		doctoresLocal.deleteDoctores(doctoresSelected.getNumeroDoctor());
		refreshEntity();
		}catch(Exception e) {
			Throwable throwable = e.getCause();
			 while(null!=throwable) {
				 throwable = throwable.getCause();
				 if(null!=throwable) {
					 if(throwable.toString().contains("CITAS_FK_V2")) {
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se puede eliminar un doctor con una cita."));
						 break;
					 }
				 }
			 }
		}
		
	}
	
	public void updateDoctores() {
		boolean updatedIn = false;
		DoctoresDto doctoresDto = new DoctoresDto();
		
		doctoresDto.setNombreDoctor(doctoresSelected.getNombreDoctor());
		doctoresDto.setNumeroUbicacion(doctoresSelected.getNumeroUbicacion());
		doctoresDto.setApellidoMaternoDoctor(doctoresSelected.getApellidoMaternoDoctor());
		doctoresDto.setApellidoPaternoDoctor(doctoresSelected.getApellidoPaternoDoctor());
		doctoresDto.setFechaNacimientoDoctor(doctoresSelected.getFechaNacimientoDoctor());
		doctoresDto.setCedulaDoctor(doctoresSelected.getCedulaDoctor());
		doctoresDto.setCelularDoctor(doctoresSelected.getCelularDoctor());
		doctoresDto.setCurpDoctor(doctoresSelected.getCurpDoctor());
		doctoresDto.setDomicilioDoctor(doctoresSelected.getDomicilioDoctor());
		doctoresDto.setTipoDoctor(doctoresSelected.getTipoDoctor());
		doctoresDto.setCorreoDoctor(doctoresSelected.getCorreoDoctor());
		doctoresDto.setEstatus(doctoresSelected.getEstatus());
		doctoresDto.setFechaCreacion(doctoresSelected.getFechaCreacion());
		doctoresDto.setFechaUltimaActualizacion(doctoresSelected.getFechaUltimaActualizacion());
		doctoresDto.setComentarios(doctoresSelected.getComentarios());
		
		doctoresLocal.updateDoctores(doctoresSelected.getNumeroDoctor(), doctoresDto);
		refreshEntity();
		updatedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void search() {
      System.out.println("Entra search");
      System.out.println(this.searchNomDoct);
      if(null!=this.searchNomDoct&&!"".equals(this.searchNomDoct)
        ||(null!=this.searchApellPatDoct&&!"".equals(this.searchApellPatDoct))
        ||(null!=this.searchApellMatDoct&&!"".equals(this.searchApellMatDoct))
        ) {
    	  
    	listDoctores = new ArrayList<Doctores>();
  		List<DoctoresDto> listDoctoresDto = doctoresLocal.findBySearch(this.searchNomDoct
  				                                                      ,this.searchApellPatDoct
  				                                                      ,this.searchApellMatDoct
  				                                                      ); 
  		Iterator<DoctoresDto> iterDoctoresDto =  listDoctoresDto.iterator();
  		while(iterDoctoresDto.hasNext()) {
  			DoctoresDto doctoresDto = iterDoctoresDto.next();
  			Doctores doctores = new Doctores();
  			doctores.setNumeroDoctor(doctoresDto.getNumeroDoctor());
  			doctores.setNombreDoctor(doctoresDto.getNombreDoctor());
  			doctores.setNumeroUbicacion(doctoresDto.getNumeroUbicacion());
  			doctores.setApellidoMaternoDoctor(doctoresDto.getApellidoMaternoDoctor());
  			doctores.setApellidoPaternoDoctor(doctoresDto.getApellidoPaternoDoctor());
  			doctores.setFechaNacimientoDoctor(doctoresDto.getFechaNacimientoDoctor());
  			doctores.setCedulaDoctor(doctoresDto.getCedulaDoctor());
  			doctores.setCelularDoctor(doctoresDto.getCelularDoctor());
  			doctores.setCurpDoctor(doctoresDto.getCurpDoctor());
  			doctores.setDomicilioDoctor(doctoresDto.getDomicilioDoctor());
  			doctores.setTipoDoctor(doctoresDto.getTipoDoctor());
  			doctores.setCorreoDoctor(doctoresDto.getCorreoDoctor());
  			doctores.setEstatus(doctoresDto.getEstatus());
  			doctores.setFechaCreacion(doctoresDto.getFechaCreacion());
  			doctores.setFechaUltimaActualizacion(doctoresDto.getFechaUltimaActualizacion());
  			doctores.setComentarios(doctoresDto.getComentarios());
  			listDoctores.add(doctores);
  		}
      }
      
      System.out.println("Sale search");
	}
	
	public Doctores getDoctores() {
		return doctores;
	}

	public void setDoctores(Doctores doctores) {
		this.doctores = doctores;
	}

	public Doctores getDoctoresSelected() {
		return doctoresSelected;
	}

	public void setDoctoresSelected(Doctores doctoresSelected) {
		this.doctoresSelected = doctoresSelected;
	}

	public List<Doctores> getListDoctores() {
		return listDoctores;
	}

	public void setListDoctores(List<Doctores> listDoctores) {
		this.listDoctores = listDoctores;
	}

	public String getSearchNomDoct() {
		return searchNomDoct;
	}

	public void setSearchNomDoct(String searchNomDoct) {
		this.searchNomDoct = searchNomDoct;
	}

	public String getSearchApellPatDoct() {
		return searchApellPatDoct;
	}

	public void setSearchApellPatDoct(String searchApellPatDoct) {
		this.searchApellPatDoct = searchApellPatDoct;
	}

	public String getSearchApellMatDoct() {
		return searchApellMatDoct;
	}

	public void setSearchApellMatDoct(String searchApellMatDoct) {
		this.searchApellMatDoct = searchApellMatDoct;
	}
	
}
