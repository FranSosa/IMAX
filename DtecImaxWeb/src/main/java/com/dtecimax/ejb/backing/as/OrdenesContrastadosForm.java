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

import com.dtecimax.ejb.model.as.OrdenesEstudiosContrastados;
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
public class OrdenesContrastadosForm {
	@ManagedProperty(value="#{ordenesEstudiosContrastados}") 
	private OrdenesEstudiosContrastados ordenesEstudiosContrastados;

	private String edad; 
	private Date fechaNacimiento;
	private long costoEstudio;
	
	private OrdenesEstudiosContrastados ordenesEstudiosContrastadosSelected = new OrdenesEstudiosContrastados(); 
	private List<OrdenesEstudiosContrastados> listOrdenesEstudiosContrastados = new ArrayList<OrdenesEstudiosContrastados>(); 
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
	
	public OrdenesEstudiosContrastados getOrdenesEstudiosContrastados() {
		return ordenesEstudiosContrastados;
	}

	public void setOrdenesEstudiosContrastados(OrdenesEstudiosContrastados ordenesEstudiosContrastados) {
		this.ordenesEstudiosContrastados = ordenesEstudiosContrastados;
	} 
	
	public void handlePacienteChange() {
		PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosContrastados.getNumeroPaciente());
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
		PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosContrastadosSelected.getNumeroPaciente());
		if(null!=pacientesDto) {
		if(null!=pacientesDto.getFechaNacimientoPaciente()) {
		ordenesEstudiosContrastadosSelected.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());	
		int intMonthsBetween =  differenceInMonths(pacientesDto.getFechaNacimientoPaciente(),new Date());
		int intAniosBetween = intMonthsBetween/12;
		ordenesEstudiosContrastadosSelected.setEdad(intAniosBetween+" anios");
		 }
		}
	}
	

	public void insertaOrdenContrastado() {
	
	  boolean loggedIn = false;
		
	  OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
	  
	  String strselectedAlergiasPacientes = ""; 
	  if(null!=selectedAlergiasPacientes) {
		  for(int i=0;i<selectedAlergiasPacientes.length;i++) {
			  strselectedAlergiasPacientes = strselectedAlergiasPacientes+selectedAlergiasPacientes[i]+",";
		  }
		  strselectedAlergiasPacientes = strselectedAlergiasPacientes.substring(0, strselectedAlergiasPacientes.length()-1);
	  }
	  
	  ordenesEstudiosDto.setNumeroUbicacion(ordenesEstudiosContrastados.getNumeroUbicacion());
	  ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosContrastados.getNumeroDoctor());
	  ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosContrastados.getNumeroPaciente());
	  ordenesEstudiosDto.setTipoOrden((short)3/*Contrastado*/);
	  ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosContrastados.getNumeroEstudio()/*(long)2 Estudio Dummy*/);
	  ordenesEstudiosDto.setNumeroAlergia(strselectedAlergiasPacientes/**Alergia Dummy**/);
	  ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosContrastados.getRequiereFactura());
	  ordenesEstudiosDto.setTipoPago(ordenesEstudiosContrastados.getTipoPago());
	  ordenesEstudiosDto.setEstatus(ordenesEstudiosContrastados.getEstatus());
	  ordenesEstudiosDto.setFechaCreacion(ordenesEstudiosContrastados.getFechaCreacion());
	  ordenesEstudiosDto.setUsuarioUltimaActualizacion(ordenesEstudiosContrastados.getUsuarioUltimaActualizacion());
	  ordenesEstudiosDto.setFechaUltimaActualizacion(ordenesEstudiosContrastados.getFechaUltimaActualizacion());
	  ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosContrastados.getIndicacionesDoctor());
	  ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosContrastados.getInfoAdicional());
	  
	  ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosContrastados.getHoraInicialOrden());
	  ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosContrastados.getHoraFinalOrden());
	
	  
	  ordenesEstudiosLocal.insertOrdenesEstudios(ordenesEstudiosDto);
	  refreshEntity();
	  loggedIn = true;
	  PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
	}
	
	private void refreshEntity() {
		listOrdenesEstudiosContrastados = new ArrayList<OrdenesEstudiosContrastados>(); 
		List<OrdenesEstudiosDto> listOrdenesEstudiosDto = ordenesEstudiosLocal.findAllContrastados();
		Iterator<OrdenesEstudiosDto> iterOrdenesEstudiosDto = listOrdenesEstudiosDto.iterator();
		while(iterOrdenesEstudiosDto.hasNext()) {
			OrdenesEstudiosDto ordenesEstudiosDto = iterOrdenesEstudiosDto.next();
			System.out.println(ordenesEstudiosDto.getNumeroPaciente());
			PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			DoctoresDto doctoresDto = doctoresLocal.findByNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			UbicacionesDto ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(ordenesEstudiosDto.getNumeroUbicacion());
			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio()); 
			OrdenesEstudiosContrastados ordenesEstudiosContrastados = new OrdenesEstudiosContrastados();
			ordenesEstudiosContrastados.setNumeroOrden(ordenesEstudiosDto.getNumeroOrden());
			ordenesEstudiosContrastados.setNombrePaciente(pacientesDto.getNombrePaciente());
			ordenesEstudiosContrastados.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			ordenesEstudiosContrastados.setNombreDoctor(doctoresDto.getNombreDoctor());
			ordenesEstudiosContrastados.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
			
			ordenesEstudiosContrastados.setNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
			ordenesEstudiosContrastados.setCostoEstudio(estudiosDto.getCostoEstudio());
			
			ordenesEstudiosContrastados.setNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			ordenesEstudiosContrastados.setNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			ordenesEstudiosContrastados.setRequiereFactura(ordenesEstudiosDto.getRequiereFactura());
			ordenesEstudiosContrastados.setInfoAdicional(ordenesEstudiosDto.getInfoAdicional());
			ordenesEstudiosContrastados.setTipoPago(ordenesEstudiosDto.getTipoPago());
			ordenesEstudiosContrastados.setEstatus(ordenesEstudiosDto.getEstatus());
			ordenesEstudiosContrastados.setFechaCreacion(ordenesEstudiosDto.getFechaCreacion());
			ordenesEstudiosContrastados.setUsuarioUltimaActualizacion(ordenesEstudiosDto.getUsuarioUltimaActualizacion());
			ordenesEstudiosContrastados.setFechaUltimaActualizacion(ordenesEstudiosDto.getFechaUltimaActualizacion());
			ordenesEstudiosContrastados.setIndicacionesDoctor(ordenesEstudiosDto.getIndicacionesDoctor());
			ordenesEstudiosContrastados.setNumeroAlergia(ordenesEstudiosDto.getNumeroAlergia());
			
			ordenesEstudiosContrastados.setHoraInicialOrden(ordenesEstudiosDto.getHoraInicialOrden());
			ordenesEstudiosContrastados.setHoraFinalOrden(ordenesEstudiosDto.getHoraFinalOrden());
			
			listOrdenesEstudiosContrastados.add(ordenesEstudiosContrastados);
		}
	}
	
	public void selectForUpdate(OrdenesEstudiosContrastados pOrdenesEstudiosContrastados) {
		
		ordenesEstudiosContrastadosSelected = new OrdenesEstudiosContrastados();
		
		 ordenesEstudiosContrastadosSelected.setNumeroOrden(pOrdenesEstudiosContrastados.getNumeroOrden());
		 ordenesEstudiosContrastadosSelected.setNumeroUbicacion(pOrdenesEstudiosContrastados.getNumeroUbicacion());
		 ordenesEstudiosContrastadosSelected.setNumeroDoctor(pOrdenesEstudiosContrastados.getNumeroDoctor());
		 ordenesEstudiosContrastadosSelected.setNumeroPaciente(pOrdenesEstudiosContrastados.getNumeroPaciente());
		 ordenesEstudiosContrastadosSelected.setTipoOrden(pOrdenesEstudiosContrastados.getTipoOrden());
		 ordenesEstudiosContrastadosSelected.setNumeroEstudio(pOrdenesEstudiosContrastados.getNumeroEstudio());
		 ordenesEstudiosContrastadosSelected.setNumeroAlergia(pOrdenesEstudiosContrastados.getNumeroAlergia());
		 ordenesEstudiosContrastadosSelected.setRequiereFactura(pOrdenesEstudiosContrastados.getRequiereFactura());
		 ordenesEstudiosContrastadosSelected.setTipoPago(pOrdenesEstudiosContrastados.getTipoPago());
		 ordenesEstudiosContrastadosSelected.setEstatus(pOrdenesEstudiosContrastados.getEstatus());
		 ordenesEstudiosContrastadosSelected.setFechaCreacion(pOrdenesEstudiosContrastados.getFechaCreacion());
		 ordenesEstudiosContrastadosSelected.setUsuarioUltimaActualizacion(pOrdenesEstudiosContrastados.getUsuarioUltimaActualizacion());
		 ordenesEstudiosContrastadosSelected.setFechaUltimaActualizacion(pOrdenesEstudiosContrastados.getFechaUltimaActualizacion());
		 ordenesEstudiosContrastadosSelected.setIndicacionesDoctor(pOrdenesEstudiosContrastados.getIndicacionesDoctor());
		 ordenesEstudiosContrastadosSelected.setInfoAdicional(pOrdenesEstudiosContrastados.getInfoAdicional());
		
		 ordenesEstudiosContrastadosSelected.setFechaNacimientoPaciente(pOrdenesEstudiosContrastados.getFechaNacimientoPaciente());
		 int intMonthsBetween =  differenceInMonths(new Date(pOrdenesEstudiosContrastados.getFechaNacimientoPaciente().getTime()),new Date());
		 int intAniosBetween = intMonthsBetween/12;
		 ordenesEstudiosContrastadosSelected.setEdad(intAniosBetween+" anios");	
		 ordenesEstudiosContrastadosSelected.setCostoEstudio(pOrdenesEstudiosContrastados.getCostoEstudio());
	
		 ordenesEstudiosContrastadosSelected.setHoraInicialOrden(pOrdenesEstudiosContrastados.getHoraInicialOrden()); 
		 ordenesEstudiosContrastadosSelected.setHoraFinalOrden(pOrdenesEstudiosContrastados.getHoraFinalOrden());
		 if(null!=pOrdenesEstudiosContrastados.getHoraInicialOrden()) {
			 ordenesEstudiosContrastadosSelected.setUtilHoraInicialOrden(new Date(pOrdenesEstudiosContrastados.getHoraInicialOrden().getTime()));
		 }
		 if(null!=pOrdenesEstudiosContrastados.getHoraFinalOrden()) {
			 ordenesEstudiosContrastadosSelected.setUtilHoraFinalOrden(new Date(pOrdenesEstudiosContrastados.getHoraFinalOrden().getTime()));
		 }
	
	}
	
   public void selectForDelete(OrdenesEstudiosContrastados pOrdenesEstudiosContrastados) {
		
		 ordenesEstudiosContrastadosSelected = new OrdenesEstudiosContrastados();
		
		 ordenesEstudiosContrastadosSelected.setNumeroOrden(pOrdenesEstudiosContrastados.getNumeroOrden());
		 ordenesEstudiosContrastadosSelected.setNumeroUbicacion(pOrdenesEstudiosContrastados.getNumeroUbicacion());
		 ordenesEstudiosContrastadosSelected.setNumeroDoctor(pOrdenesEstudiosContrastados.getNumeroDoctor());
		 ordenesEstudiosContrastadosSelected.setNumeroPaciente(pOrdenesEstudiosContrastados.getNumeroPaciente());
		 ordenesEstudiosContrastadosSelected.setTipoOrden(pOrdenesEstudiosContrastados.getTipoOrden());
		 ordenesEstudiosContrastadosSelected.setNumeroEstudio(pOrdenesEstudiosContrastados.getNumeroEstudio());
		 ordenesEstudiosContrastadosSelected.setNumeroAlergia(pOrdenesEstudiosContrastados.getNumeroAlergia());
		 ordenesEstudiosContrastadosSelected.setRequiereFactura(pOrdenesEstudiosContrastados.getRequiereFactura());
		 ordenesEstudiosContrastadosSelected.setTipoPago(pOrdenesEstudiosContrastados.getTipoPago());
		 ordenesEstudiosContrastadosSelected.setEstatus(pOrdenesEstudiosContrastados.getEstatus());
		 ordenesEstudiosContrastadosSelected.setFechaCreacion(pOrdenesEstudiosContrastados.getFechaCreacion());
		 ordenesEstudiosContrastadosSelected.setUsuarioUltimaActualizacion(pOrdenesEstudiosContrastados.getUsuarioUltimaActualizacion());
		 ordenesEstudiosContrastadosSelected.setFechaUltimaActualizacion(pOrdenesEstudiosContrastados.getFechaUltimaActualizacion());
		 ordenesEstudiosContrastadosSelected.setIndicacionesDoctor(pOrdenesEstudiosContrastados.getIndicacionesDoctor());
		 ordenesEstudiosContrastadosSelected.setInfoAdicional(pOrdenesEstudiosContrastados.getInfoAdicional());
		
	}

    public void actualizaOrdenContrastado() {
    	
    	boolean updatedIn = false; 
    	OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
    	
     /**	
      System.out.print("ordenesEstudiosContrastadosSelected.getSelectedAlergiasPacientes()");
  	  System.out.println(ordenesEstudiosContrastadosSelected.getSelectedAlergiasPacientes());
  	  String [] arraySelectedAlergiasPacientes = ordenesEstudiosContrastadosSelected.getSelectedAlergiasPacientes();
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
    	
    	ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosContrastadosSelected.getNumeroPaciente());
    	ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosContrastadosSelected.getNumeroDoctor());
    	ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosContrastadosSelected.getIndicacionesDoctor());
    	ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosContrastadosSelected.getInfoAdicional());
    	ordenesEstudiosDto.setNumeroAlergia(ordenesEstudiosContrastadosSelected.getNumeroAlergia());
    	ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosContrastadosSelected.getRequiereFactura());
    	ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosContrastadosSelected.getNumeroEstudio());
    	ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosContrastadosSelected.getHoraInicialOrden());
    	ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosContrastadosSelected.getHoraFinalOrden());
    	
    	ordenesEstudiosLocal.updateOrdenesEstudios(ordenesEstudiosContrastadosSelected.getNumeroOrden(), ordenesEstudiosDto);
    	refreshEntity();
    	updatedIn = true;
    	PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
    }
   
    public void delete() {
    	ordenesEstudiosLocal.deleteOrdenesEstudios(ordenesEstudiosContrastadosSelected.getNumeroOrden());
    	refreshEntity();
    }
    
    public void handleEstudioChange() {
		EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosContrastados.getNumeroEstudio());
		if(null!=estudiosDto) {
		setCostoEstudio(estudiosDto.getCostoEstudio());
		}
	}
    
    public void handleEstudioChangeUpd() {
		EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosContrastadosSelected.getNumeroEstudio());
		if(null!=estudiosDto) {
			ordenesEstudiosContrastadosSelected.setCostoEstudio(estudiosDto.getCostoEstudio());
		}
	}
    
    public void search() {
     	if((null!=this.searchNumEstu&&!"".equals(this.searchNumEstu))
     	    	  ||(null!=this.searchNomPaci&&!"".equals(this.searchNomPaci))
     	    	  ||(null!=this.searchNomDoct&&!"".equals(this.searchNomDoct))
     	    	  ) {
     	   
    	listOrdenesEstudiosContrastados = new ArrayList<OrdenesEstudiosContrastados>(); 
		List<OrdenesEstudiosDto> listOrdenesEstudiosDto = ordenesEstudiosLocal.findBySearch("3"
				                                                                          , this.searchNumEstu
				                                                                          , this.searchNomPaci
				                                                                          , this.searchNomDoct
				                                                                          );
		
		Iterator<OrdenesEstudiosDto> iterOrdenesEstudiosDto = listOrdenesEstudiosDto.iterator();
		while(iterOrdenesEstudiosDto.hasNext()) {
			OrdenesEstudiosDto ordenesEstudiosDto = iterOrdenesEstudiosDto.next();
			System.out.println(ordenesEstudiosDto.getNumeroPaciente());
			PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			DoctoresDto doctoresDto = doctoresLocal.findByNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			UbicacionesDto ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(ordenesEstudiosDto.getNumeroUbicacion());
			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio()); 
			OrdenesEstudiosContrastados ordenesEstudiosContrastados = new OrdenesEstudiosContrastados();
			ordenesEstudiosContrastados.setNumeroOrden(ordenesEstudiosDto.getNumeroOrden());
			ordenesEstudiosContrastados.setNombrePaciente(pacientesDto.getNombrePaciente());
			ordenesEstudiosContrastados.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			ordenesEstudiosContrastados.setNombreDoctor(doctoresDto.getNombreDoctor());
			ordenesEstudiosContrastados.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
			
			ordenesEstudiosContrastados.setNumeroEstudio(ordenesEstudiosDto.getNumeroEstudio());
			ordenesEstudiosContrastados.setCostoEstudio(estudiosDto.getCostoEstudio());
			
			ordenesEstudiosContrastados.setNumeroPaciente(ordenesEstudiosDto.getNumeroPaciente());
			ordenesEstudiosContrastados.setNumeroDoctor(ordenesEstudiosDto.getNumeroDoctor());
			ordenesEstudiosContrastados.setRequiereFactura(ordenesEstudiosDto.getRequiereFactura());
			ordenesEstudiosContrastados.setInfoAdicional(ordenesEstudiosDto.getInfoAdicional());
			ordenesEstudiosContrastados.setTipoPago(ordenesEstudiosDto.getTipoPago());
			ordenesEstudiosContrastados.setEstatus(ordenesEstudiosDto.getEstatus());
			ordenesEstudiosContrastados.setFechaCreacion(ordenesEstudiosDto.getFechaCreacion());
			ordenesEstudiosContrastados.setUsuarioUltimaActualizacion(ordenesEstudiosDto.getUsuarioUltimaActualizacion());
			ordenesEstudiosContrastados.setFechaUltimaActualizacion(ordenesEstudiosDto.getFechaUltimaActualizacion());
			ordenesEstudiosContrastados.setIndicacionesDoctor(ordenesEstudiosDto.getIndicacionesDoctor());
			ordenesEstudiosContrastados.setNumeroAlergia(ordenesEstudiosDto.getNumeroAlergia());
			
			ordenesEstudiosContrastados.setHoraInicialOrden(ordenesEstudiosDto.getHoraInicialOrden());
			ordenesEstudiosContrastados.setHoraFinalOrden(ordenesEstudiosDto.getHoraFinalOrden());
			
			listOrdenesEstudiosContrastados.add(ordenesEstudiosContrastados);
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

	public List<OrdenesEstudiosContrastados> getListOrdenesEstudiosContrastados() {
		return listOrdenesEstudiosContrastados;
	}

	public void setListOrdenesEstudiosContrastados(List<OrdenesEstudiosContrastados> listOrdenesEstudiosContrastados) {
		this.listOrdenesEstudiosContrastados = listOrdenesEstudiosContrastados;
	}

	public OrdenesEstudiosContrastados getOrdenesEstudiosContrastadosSelected() {
		return ordenesEstudiosContrastadosSelected;
	}

	public void setOrdenesEstudiosContrastadosSelected(OrdenesEstudiosContrastados ordenesEstudiosContrastadosSelected) {
		this.ordenesEstudiosContrastadosSelected = ordenesEstudiosContrastadosSelected;
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

