package com.dtecimax.ejb.backing.as;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import com.dtecimax.ejb.model.as.OrdenesEstudiosDentales;
import com.dtecimax.ejb.services.admin.UbicacionesLocal;
import com.dtecimax.ejb.services.ar.AlergiasPacientesLocal;
import com.dtecimax.ejb.services.ar.PacientesLocal;
import com.dtecimax.ejb.services.as.EstudiosLocal;
import com.dtecimax.ejb.services.as.OrdenesEstudiosLocal;
import com.dtecimax.ejb.services.hr.DoctoresLocal;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;
import com.dtecimax.jpa.dto.ar.PacientesDto;
import com.dtecimax.jpa.dto.as.EstudiosDto;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

@ManagedBean  
@ViewScoped
public class OrdenesDentalesForm {
	@ManagedProperty(value="#{ordenesEstudiosDentales}") 
	private OrdenesEstudiosDentales ordenesEstudiosDentales;

	private String edad; 
	private Date fechaNacimiento;
	private long costoEstudio;
	
	private OrdenesEstudiosDentales ordenesEstudiosDentalesSelected = new OrdenesEstudiosDentales(); 
	private List<OrdenesEstudiosDentales> listOrdenesEstudiosDentales = new ArrayList<OrdenesEstudiosDentales>(); 
	private List<SelectItem> alergiasPacientesItems; 
	private String[] selectedAlergiasPacientes;
	
	public String[] getSelectedAlergiasPacientes() {
		return selectedAlergiasPacientes;
	}
	
	public void setSelectedAlergiasPacientes(String[] selectedAlergiasPacientes) {
		this.selectedAlergiasPacientes = selectedAlergiasPacientes;
	}
	
	@Inject
	PacientesLocal pacientesLocal;
	
	@Inject
	DoctoresLocal doctoresLocal;
	
	@Inject
	UbicacionesLocal ubicacionesLocal; 
	
	@Inject 
	OrdenesEstudiosLocal ordenesEstudiosLocal; 
	
	@Inject 
	AlergiasPacientesLocal alergiasPacientesLocal; 
	
	@Inject 
	EstudiosLocal estudiosLocal; 

	private String searchNumEstu; 
	private String searchNomPaci; 
	private String searchNomDoct; 
	
	
	 @PostConstruct
	 public void init() {
		 alergiasPacientesItems = new ArrayList<SelectItem>();
		 List<AlergiasPacientesDto> listAlergiasPacientes = alergiasPacientesLocal.findSelectItems();
		 Iterator<AlergiasPacientesDto> iterAlergiasPacientes = listAlergiasPacientes.iterator();
		 while(iterAlergiasPacientes.hasNext()) {
			 AlergiasPacientesDto  alergiasPacientesDto = iterAlergiasPacientes.next();
			 SelectItem selectItem = new SelectItem(alergiasPacientesDto.getNumeroAlergia(),alergiasPacientesDto.getNombreAlergia());
			 alergiasPacientesItems.add(selectItem);
		 }
		 refreshEntity();
	 }
	
	public OrdenesEstudiosDentales getOrdenesEstudiosDentales() {
		return ordenesEstudiosDentales;
	}

	public void setOrdenesEstudiosDentales(OrdenesEstudiosDentales ordenesEstudiosDentales) {
		this.ordenesEstudiosDentales = ordenesEstudiosDentales;
	} 
	
	public void handlePacienteChange() {
		PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDentales.getNumeroPaciente());
		if(null!=pacientesDto) {
		if(null!=pacientesDto.getFechaNacimientoPaciente()) {
		fechaNacimiento = new Date(pacientesDto.getFechaNacimientoPaciente().getTime());
		int intMonthsBetween =  differenceInMonths(fechaNacimiento,new Date());
		int intAniosBetween = intMonthsBetween/12;
		edad = intAniosBetween+" anios";
		 }
		}
	}
	
	public void handlePacienteChangeUpd() {
		PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDentalesSelected.getNumeroPaciente());
		if(null!=pacientesDto) {
		if(null!=pacientesDto.getFechaNacimientoPaciente()) {
		ordenesEstudiosDentalesSelected.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());	
		int intMonthsBetween =  differenceInMonths(pacientesDto.getFechaNacimientoPaciente(),new Date());
		int intAniosBetween = intMonthsBetween/12;
		ordenesEstudiosDentalesSelected.setEdad(intAniosBetween+" anios");
		 }
		}
	}
	

	public void insertaOrdenDental() {
	
	  boolean loggedIn = false;
		
	  OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
	  
	  String strselectedAlergiasPacientes = ""; 
	  if(null!=selectedAlergiasPacientes) {
		  for(int i=0;i<selectedAlergiasPacientes.length;i++) {
			  strselectedAlergiasPacientes = strselectedAlergiasPacientes+selectedAlergiasPacientes[i]+",";
		  }
		  strselectedAlergiasPacientes = strselectedAlergiasPacientes.substring(0, strselectedAlergiasPacientes.length()-1);
	  }
	  
	  ordenesEstudiosDto.setNumeroUbicacion(ordenesEstudiosDentales.getNumeroUbicacion());
	  ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosDentales.getNumeroDoctor());
	  ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosDentales.getNumeroPaciente());
	  ordenesEstudiosDto.setTipoOrden((short)4/*Dental*/);
	  ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosDentales.getNumeroEstudio()/* (long)2 Estudio Dummy*/);
	  ordenesEstudiosDto.setNumeroAlergia(strselectedAlergiasPacientes/**Alergia Dummy**/);
	  ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosDentales.getRequiereFactura());
	  ordenesEstudiosDto.setTipoPago(ordenesEstudiosDentales.getTipoPago());
	  ordenesEstudiosDto.setEstatus(ordenesEstudiosDentales.getEstatus());
	  ordenesEstudiosDto.setFechaCreacion(ordenesEstudiosDentales.getFechaCreacion());
	  ordenesEstudiosDto.setUsuarioUltimaActualizacion(ordenesEstudiosDentales.getUsuarioUltimaActualizacion());
	  ordenesEstudiosDto.setFechaUltimaActualizacion(ordenesEstudiosDentales.getFechaUltimaActualizacion());
	  ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosDentales.getIndicacionesDoctor());
	  ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosDentales.getInfoAdicional());
	  
	  ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosDentales.getHoraInicialOrden());
	  ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosDentales.getHoraFinalOrden());
	
	  
	  ordenesEstudiosLocal.insertOrdenesEstudios(ordenesEstudiosDto);
	  refreshEntity();
	  loggedIn = true;
	  PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
	}
	
	private void refreshEntity() {
		listOrdenesEstudiosDentales = new ArrayList<OrdenesEstudiosDentales>(); 
		List<OrdenesEstudiosDto> listOrdenesEstudiosDto = ordenesEstudiosLocal.findAllDentales();
		Iterator<OrdenesEstudiosDto> iterOrdenesEstudiosDto = listOrdenesEstudiosDto.iterator();
		while(iterOrdenesEstudiosDto.hasNext()) {
			OrdenesEstudiosDto ordenesEstudiosDto = iterOrdenesEstudiosDto.next();
			System.out.println(ordenesEstudiosDto.getNumeroPaciente());
			PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			DoctoresDto doctoresDto = doctoresLocal.findByNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			UbicacionesDto ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(ordenesEstudiosDto.getNumeroUbicacion());
			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
			OrdenesEstudiosDentales ordenesEstudiosDentales = new OrdenesEstudiosDentales();
			ordenesEstudiosDentales.setNumeroOrden(ordenesEstudiosDto.getNumeroOrden());
			ordenesEstudiosDentales.setNombrePaciente(pacientesDto.getNombrePaciente());
			ordenesEstudiosDentales.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			ordenesEstudiosDentales.setNombreDoctor(doctoresDto.getNombreDoctor());
			ordenesEstudiosDentales.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
			
			ordenesEstudiosDentales.setNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
			ordenesEstudiosDentales.setCostoEstudio(estudiosDto.getCostoEstudio());
			
			ordenesEstudiosDentales.setNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			ordenesEstudiosDentales.setNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			ordenesEstudiosDentales.setRequiereFactura(ordenesEstudiosDto.getRequiereFactura());
			ordenesEstudiosDentales.setInfoAdicional(ordenesEstudiosDto.getInfoAdicional());
			ordenesEstudiosDentales.setTipoPago(ordenesEstudiosDto.getTipoPago());
			ordenesEstudiosDentales.setEstatus(ordenesEstudiosDto.getEstatus());
			ordenesEstudiosDentales.setFechaCreacion(ordenesEstudiosDto.getFechaCreacion());
			ordenesEstudiosDentales.setUsuarioUltimaActualizacion(ordenesEstudiosDto.getUsuarioUltimaActualizacion());
			ordenesEstudiosDentales.setFechaUltimaActualizacion(ordenesEstudiosDto.getFechaUltimaActualizacion());
			ordenesEstudiosDentales.setIndicacionesDoctor(ordenesEstudiosDto.getIndicacionesDoctor());
			ordenesEstudiosDentales.setNumeroAlergia(ordenesEstudiosDto.getNumeroAlergia());
			
			ordenesEstudiosDentales.setHoraInicialOrden(ordenesEstudiosDto.getHoraInicialOrden());
			ordenesEstudiosDentales.setHoraFinalOrden(ordenesEstudiosDto.getHoraFinalOrden());
			
			listOrdenesEstudiosDentales.add(ordenesEstudiosDentales);
		}
	}
	
	public void selectForUpdate(OrdenesEstudiosDentales pOrdenesEstudiosDentales) {
		
		ordenesEstudiosDentalesSelected = new OrdenesEstudiosDentales();
		
		 ordenesEstudiosDentalesSelected.setNumeroOrden(pOrdenesEstudiosDentales.getNumeroOrden());
		 ordenesEstudiosDentalesSelected.setNumeroUbicacion(pOrdenesEstudiosDentales.getNumeroUbicacion());
		 ordenesEstudiosDentalesSelected.setNumeroDoctor(pOrdenesEstudiosDentales.getNumeroDoctor());
		 ordenesEstudiosDentalesSelected.setNumeroPaciente(pOrdenesEstudiosDentales.getNumeroPaciente());
		 ordenesEstudiosDentalesSelected.setTipoOrden(pOrdenesEstudiosDentales.getTipoOrden());
		 ordenesEstudiosDentalesSelected.setNumeroEstudio(pOrdenesEstudiosDentales.getNumeroEstudio());
		 ordenesEstudiosDentalesSelected.setNumeroAlergia(pOrdenesEstudiosDentales.getNumeroAlergia());
		 ordenesEstudiosDentalesSelected.setRequiereFactura(pOrdenesEstudiosDentales.getRequiereFactura());
		 ordenesEstudiosDentalesSelected.setTipoPago(pOrdenesEstudiosDentales.getTipoPago());
		 ordenesEstudiosDentalesSelected.setEstatus(pOrdenesEstudiosDentales.getEstatus());
		 ordenesEstudiosDentalesSelected.setFechaCreacion(pOrdenesEstudiosDentales.getFechaCreacion());
		 ordenesEstudiosDentalesSelected.setUsuarioUltimaActualizacion(pOrdenesEstudiosDentales.getUsuarioUltimaActualizacion());
		 ordenesEstudiosDentalesSelected.setFechaUltimaActualizacion(pOrdenesEstudiosDentales.getFechaUltimaActualizacion());
		 ordenesEstudiosDentalesSelected.setIndicacionesDoctor(pOrdenesEstudiosDentales.getIndicacionesDoctor());
		 ordenesEstudiosDentalesSelected.setInfoAdicional(pOrdenesEstudiosDentales.getInfoAdicional());
		
		 ordenesEstudiosDentalesSelected.setFechaNacimientoPaciente(pOrdenesEstudiosDentales.getFechaNacimientoPaciente());
		 int intMonthsBetween =  differenceInMonths(new Date(pOrdenesEstudiosDentales.getFechaNacimientoPaciente().getTime()),new Date());
		 int intAniosBetween = intMonthsBetween/12;
		 ordenesEstudiosDentalesSelected.setEdad(intAniosBetween+" anios");	
		 ordenesEstudiosDentalesSelected.setCostoEstudio(pOrdenesEstudiosDentales.getCostoEstudio());
	
		 ordenesEstudiosDentalesSelected.setHoraInicialOrden(pOrdenesEstudiosDentales.getHoraInicialOrden()); 
		 ordenesEstudiosDentalesSelected.setHoraFinalOrden(pOrdenesEstudiosDentales.getHoraFinalOrden());
		 if(null!=pOrdenesEstudiosDentales.getHoraInicialOrden()) {
			 ordenesEstudiosDentalesSelected.setUtilHoraInicialOrden(new Date(pOrdenesEstudiosDentales.getHoraInicialOrden().getTime()));
		 }
		 if(null!=pOrdenesEstudiosDentales.getHoraFinalOrden()) {
			 ordenesEstudiosDentalesSelected.setUtilHoraFinalOrden(new Date(pOrdenesEstudiosDentales.getHoraFinalOrden().getTime()));
		 }
		  
	}
	
   public void selectForDelete(OrdenesEstudiosDentales pOrdenesEstudiosDentales) {
		
		 ordenesEstudiosDentalesSelected = new OrdenesEstudiosDentales();
		
		 ordenesEstudiosDentalesSelected.setNumeroOrden(pOrdenesEstudiosDentales.getNumeroOrden());
		 ordenesEstudiosDentalesSelected.setNumeroUbicacion(pOrdenesEstudiosDentales.getNumeroUbicacion());
		 ordenesEstudiosDentalesSelected.setNumeroDoctor(pOrdenesEstudiosDentales.getNumeroDoctor());
		 ordenesEstudiosDentalesSelected.setNumeroPaciente(pOrdenesEstudiosDentales.getNumeroPaciente());
		 ordenesEstudiosDentalesSelected.setTipoOrden(pOrdenesEstudiosDentales.getTipoOrden());
		 ordenesEstudiosDentalesSelected.setNumeroEstudio(pOrdenesEstudiosDentales.getNumeroEstudio());
		 ordenesEstudiosDentalesSelected.setNumeroAlergia(pOrdenesEstudiosDentales.getNumeroAlergia());
		 ordenesEstudiosDentalesSelected.setRequiereFactura(pOrdenesEstudiosDentales.getRequiereFactura());
		 ordenesEstudiosDentalesSelected.setTipoPago(pOrdenesEstudiosDentales.getTipoPago());
		 ordenesEstudiosDentalesSelected.setEstatus(pOrdenesEstudiosDentales.getEstatus());
		 ordenesEstudiosDentalesSelected.setFechaCreacion(pOrdenesEstudiosDentales.getFechaCreacion());
		 ordenesEstudiosDentalesSelected.setUsuarioUltimaActualizacion(pOrdenesEstudiosDentales.getUsuarioUltimaActualizacion());
		 ordenesEstudiosDentalesSelected.setFechaUltimaActualizacion(pOrdenesEstudiosDentales.getFechaUltimaActualizacion());
		 ordenesEstudiosDentalesSelected.setIndicacionesDoctor(pOrdenesEstudiosDentales.getIndicacionesDoctor());
		 ordenesEstudiosDentalesSelected.setInfoAdicional(pOrdenesEstudiosDentales.getInfoAdicional());
		
	}

    public void actualizaOrdenDental() {
    	
    	boolean updatedIn = false; 
    	OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
    	
     /**	
      System.out.print("ordenesEstudiosDentalesSelected.getSelectedAlergiasPacientes()");
  	  System.out.println(ordenesEstudiosDentalesSelected.getSelectedAlergiasPacientes());
  	  String [] arraySelectedAlergiasPacientes = ordenesEstudiosDentalesSelected.getSelectedAlergiasPacientes();
  	  String strselectedAlergiasPacientes = null; 
  	  if(null!=arraySelectedAlergiasPacientes) {
  		  System.out.println("Length:"+arraySelectedAlergiasPacientes.length);
  		strselectedAlergiasPacientes = "";
  		  for(int i=0;i<arraySelectedAlergiasPacientes.length;i++) {
  			  strselectedAlergiasPacientes = strselectedAlergiasPacientes+arraySelectedAlergiasPacientes[i]+",";
  		  }
  		  System.out.println(strselectedAlergiasPacientes);
  		  strselectedAlergiasPacientes = strselectedAlergiasPacientes.substring(0, strselectedAlergiasPacientes.length()-1);
  		  System.out.println(strselectedAlergiasPacientes);
  	  }
  	  **/
    	
    	ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosDentalesSelected.getNumeroPaciente());
    	ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosDentalesSelected.getNumeroDoctor());
    	ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosDentalesSelected.getIndicacionesDoctor());
    	ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosDentalesSelected.getInfoAdicional());
    	ordenesEstudiosDto.setNumeroAlergia(ordenesEstudiosDentalesSelected.getNumeroAlergia());
    	ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosDentalesSelected.getRequiereFactura());
    	ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosDentalesSelected.getNumeroEstudio());
    	ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosDentalesSelected.getHoraInicialOrden());
    	ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosDentalesSelected.getHoraFinalOrden());
    	
    	ordenesEstudiosLocal.updateOrdenesEstudios(ordenesEstudiosDentalesSelected.getNumeroOrden(), ordenesEstudiosDto);
    	refreshEntity();
    	updatedIn = true;
    	PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
    }
   
    public void delete() {
    	ordenesEstudiosLocal.deleteOrdenesEstudios(ordenesEstudiosDentalesSelected.getNumeroOrden());
    	refreshEntity();
    }
    
    public void handleEstudioChange() {
		EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDentales.getNumeroEstudio());
		if(null!=estudiosDto) {
		setCostoEstudio(estudiosDto.getCostoEstudio());
		}
	}
    
    public void handleEstudioChangeUpd() {
		EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDentalesSelected.getNumeroEstudio());
		if(null!=estudiosDto) {
			ordenesEstudiosDentalesSelected.setCostoEstudio(estudiosDto.getCostoEstudio());
		}
	}
    
    public void search() {
    	if((null!=this.searchNumEstu&&!"".equals(this.searchNumEstu))
    	  ||(null!=this.searchNomPaci&&!"".equals(this.searchNomPaci))
    	  ||(null!=this.searchNomDoct&&!"".equals(this.searchNomDoct))
    	  ) {
    	
    		listOrdenesEstudiosDentales = new ArrayList<OrdenesEstudiosDentales>(); 
    		List<OrdenesEstudiosDto> listOrdenesEstudiosDto = ordenesEstudiosLocal.findBySearch("4"
    				                                                                           ,this.searchNumEstu
    				                                                                           ,this.searchNomPaci
    				                                                                           ,this.searchNomDoct
    				                                                                           );
    		Iterator<OrdenesEstudiosDto> iterOrdenesEstudiosDto = listOrdenesEstudiosDto.iterator();
    		while(iterOrdenesEstudiosDto.hasNext()) {
    			OrdenesEstudiosDto ordenesEstudiosDto = iterOrdenesEstudiosDto.next();
    			System.out.println(ordenesEstudiosDto.getNumeroPaciente());
    			PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
    			DoctoresDto doctoresDto = doctoresLocal.findByNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
    			UbicacionesDto ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(ordenesEstudiosDto.getNumeroUbicacion());
    			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
    			OrdenesEstudiosDentales ordenesEstudiosDentales = new OrdenesEstudiosDentales();
    			ordenesEstudiosDentales.setNumeroOrden(ordenesEstudiosDto.getNumeroOrden());
    			ordenesEstudiosDentales.setNombrePaciente(pacientesDto.getNombrePaciente());
    			ordenesEstudiosDentales.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
    			ordenesEstudiosDentales.setNombreDoctor(doctoresDto.getNombreDoctor());
    			ordenesEstudiosDentales.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
    			
    			ordenesEstudiosDentales.setNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
    			ordenesEstudiosDentales.setCostoEstudio(estudiosDto.getCostoEstudio());
    			
    			ordenesEstudiosDentales.setNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
    			ordenesEstudiosDentales.setNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
    			ordenesEstudiosDentales.setRequiereFactura(ordenesEstudiosDto.getRequiereFactura());
    			ordenesEstudiosDentales.setInfoAdicional(ordenesEstudiosDto.getInfoAdicional());
    			ordenesEstudiosDentales.setTipoPago(ordenesEstudiosDto.getTipoPago());
    			ordenesEstudiosDentales.setEstatus(ordenesEstudiosDto.getEstatus());
    			ordenesEstudiosDentales.setFechaCreacion(ordenesEstudiosDto.getFechaCreacion());
    			ordenesEstudiosDentales.setUsuarioUltimaActualizacion(ordenesEstudiosDto.getUsuarioUltimaActualizacion());
    			ordenesEstudiosDentales.setFechaUltimaActualizacion(ordenesEstudiosDto.getFechaUltimaActualizacion());
    			ordenesEstudiosDentales.setIndicacionesDoctor(ordenesEstudiosDto.getIndicacionesDoctor());
    			ordenesEstudiosDentales.setNumeroAlergia(ordenesEstudiosDto.getNumeroAlergia());
    			
    			ordenesEstudiosDentales.setHoraInicialOrden(ordenesEstudiosDto.getHoraInicialOrden());
    			ordenesEstudiosDentales.setHoraFinalOrden(ordenesEstudiosDto.getHoraFinalOrden());
    			
    			listOrdenesEstudiosDentales.add(ordenesEstudiosDentales);
    		}
    		
    	}
    }
    
	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	private  int differenceInMonths(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(d1);
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(d2);
	    int diff = 0;
	    if (c2.after(c1)) {
	        while (c2.after(c1)) {
	            c1.add(Calendar.MONTH, 1);
	            if (c2.after(c1)) {
	                diff++;
	            }
	        }
	    } else if (c2.before(c1)) {
	        while (c2.before(c1)) {
	            c1.add(Calendar.MONTH, -1);
	            if (c1.before(c2)) {
	                diff--;
	            }
	        }
	    }
	    return diff;
	}

	public List<OrdenesEstudiosDentales> getListOrdenesEstudiosDentales() {
		return listOrdenesEstudiosDentales;
	}

	public void setListOrdenesEstudiosDentales(List<OrdenesEstudiosDentales> listOrdenesEstudiosDentales) {
		this.listOrdenesEstudiosDentales = listOrdenesEstudiosDentales;
	}

	public OrdenesEstudiosDentales getOrdenesEstudiosDentalesSelected() {
		return ordenesEstudiosDentalesSelected;
	}

	public void setOrdenesEstudiosDentalesSelected(OrdenesEstudiosDentales ordenesEstudiosDentalesSelected) {
		this.ordenesEstudiosDentalesSelected = ordenesEstudiosDentalesSelected;
	}

	public List<SelectItem> getAlergiasPacientesItems() {
		return alergiasPacientesItems;
	}

	public void setAlergiasPacientesItems(List<SelectItem> alergiasPacientesItems) {
		this.alergiasPacientesItems = alergiasPacientesItems;
	}

	public long getCostoEstudio() {
		return costoEstudio;
	}

	public void setCostoEstudio(long costoEstudio) {
		this.costoEstudio = costoEstudio;
	}

	public String getSearchNumEstu() {
		return searchNumEstu;
	}

	public void setSearchNumEstu(String searchNumEstu) {
		this.searchNumEstu = searchNumEstu;
	}

	public String getSearchNomPaci() {
		return searchNomPaci;
	}

	public void setSearchNomPaci(String searchNomPaci) {
		this.searchNomPaci = searchNomPaci;
	}

	public String getSearchNomDoct() {
		return searchNomDoct;
	}

	public void setSearchNomDoct(String searchNomDoct) {
		this.searchNomDoct = searchNomDoct;
	}
	
}


