package com.dtecimax.ejb.backing.as;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.dtecimax.ejb.model.as.Citas;
import com.dtecimax.ejb.model.as.NotasCitas;
import com.dtecimax.ejb.model.as.OrdenesEstudiosContrastados;
import com.dtecimax.ejb.model.as.OrdenesEstudiosDentales;
import com.dtecimax.ejb.model.as.OrdenesEstudiosEspeciales;
import com.dtecimax.ejb.model.as.OrdenesEstudiosSimples;
import com.dtecimax.ejb.services.ar.PacientesLocal;
import com.dtecimax.ejb.services.as.CitasLocal;
import com.dtecimax.ejb.services.as.EstudiosLocal;
import com.dtecimax.ejb.services.as.NotasCitasLocal;
import com.dtecimax.ejb.services.as.OrdenesEstudiosLocal;
import com.dtecimax.ejb.services.hr.DoctoresLocal;
import com.dtecimax.jpa.dto.ar.PacientesDto;
import com.dtecimax.jpa.dto.as.CitasDto;
import com.dtecimax.jpa.dto.as.EstudiosDto;
import com.dtecimax.jpa.dto.as.NotasCitasDto;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

@ManagedBean  
@ViewScoped
public class CitasForm {

	@ManagedProperty(value="#{citas}") 
	private Citas citas;
	
	@ManagedProperty(value="#{notasCitas}") 
	private NotasCitas notasCitas; 
	
	private Citas citasSelected = new Citas(); 
	
	private NotasCitas notasCitasSelected = new NotasCitas(); 
	
	private ScheduleModel eventModel;
	
	private List<CitasDto> listCitasDto =new ArrayList<CitasDto>();
	
	private List<NotasCitas> listNotasCitas = new ArrayList<NotasCitas>();
	
	private ScheduleEvent event = new DefaultScheduleEvent();
	 
	@Inject
	CitasLocal citasLocal;
	
	@Inject
	NotasCitasLocal notasCitasLocal;
		
	@Inject
	EstudiosLocal estudiosLocal;

	private long searchNumDoct; 
	private String searchTipoEstu;
	private String tipoOrden; 
	
	/***************************************************************************
	 *************************************************************************** 
	 */
	
	@ManagedProperty(value="#{ordenesEstudiosSimples}") 
	private OrdenesEstudiosSimples ordenesEstudiosSimples;
	
	@ManagedProperty(value="#{ordenesEstudiosEspeciales}") 
	private OrdenesEstudiosEspeciales ordenesEstudiosEspeciales;
	
	@ManagedProperty(value="#{ordenesEstudiosContrastados}") 
	private OrdenesEstudiosContrastados ordenesEstudiosContrastados;
	
	@ManagedProperty(value="#{ordenesEstudiosDentales}") 
	private OrdenesEstudiosDentales ordenesEstudiosDentales;
	
	@Inject
	PacientesLocal pacientesLocal;
	
	@Inject
	DoctoresLocal doctoresLocal; 
	
	@Inject
	OrdenesEstudiosLocal ordenesEstudiosLocal;
	
	private String[] selectedAlergiasPacientes;
	
	@PostConstruct
	public void init() {
		/********************************
		listCitasDto = new ArrayList<CitasDto>();
		eventModel = new DefaultScheduleModel();
		**********************************/
		System.out.println("Entra CitasForm.init()");
		refreshEntity();
		
		refreshEntityNotas(); 
		
	}
	
	
	public void refreshEntity() {
		listCitasDto = new ArrayList<CitasDto>();
		eventModel = new DefaultScheduleModel();
		
		List<CitasDto> listCitasDto  = citasLocal.findAll();
		Iterator<CitasDto> iterCitasDto = listCitasDto.iterator();
		long count = 1; 
		while(iterCitasDto.hasNext()) {
			CitasDto citasDto = iterCitasDto.next();
			long timeFechaInicial = citasDto.getFechaCita().getTime() + citasDto.getHoraInicialCita().getTime();
			long timeFechaFinal = citasDto.getFechaCita().getTime() + citasDto.getHoraFinalCita().getTime();
			/* DefaultScheduleEvent defaultScheduleEvent = new DefaultScheduleEvent("IdCita:"+citasDto.getNumeroCita(),new Date(timeFechaInicial),new Date(timeFechaFinal)); */
			DefaultScheduleEvent defaultScheduleEvent = new DefaultScheduleEvent();
			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(citasDto.getNumeroEstudio());
			defaultScheduleEvent.setTitle(estudiosDto.getNombreEstudio());
			defaultScheduleEvent.setDescription(citasDto.getNumeroCita()+"");
			defaultScheduleEvent.setStartDate(new Date(timeFechaInicial));
			defaultScheduleEvent.setEndDate(new Date(timeFechaFinal));
			defaultScheduleEvent.setStyleClass("dimax"+estudiosDto.getColorEstudio());
			eventModel.addEvent(defaultScheduleEvent);
			count = count+1;
		}
	}
	
	public void refreshEntityNotas() {
        listNotasCitas = new ArrayList<NotasCitas>();
		
		List<NotasCitasDto> listNotasCitasDto =  notasCitasLocal.findAll();
		Iterator<NotasCitasDto> iterNotasCitas = listNotasCitasDto.iterator(); 
		while(iterNotasCitas.hasNext()) {
			NotasCitasDto notasCitasDto = iterNotasCitas.next();
			NotasCitas notasCitas = new NotasCitas();
			notasCitas.setNumeroNota(notasCitasDto.getNumeroNota());
			notasCitas.setFechaNota(notasCitasDto.getFechaNota());
			notasCitas.setTxtNota(notasCitasDto.getTxtNota());
			listNotasCitas.add(notasCitas);
		}
	}
	
	public void refreshEntityByNumDoc(long pNumeroDoctor
			                         ,String pSearchTipoEstu
			                         ) {
		listCitasDto = new ArrayList<CitasDto>();
		eventModel = new DefaultScheduleModel();
		
		List<CitasDto> listCitasDto  = citasLocal.findAllByNumDoc(pNumeroDoctor
				                                                 ,pSearchTipoEstu
				                                                 );
		Iterator<CitasDto> iterCitasDto = listCitasDto.iterator();
		long count = 1; 
		while(iterCitasDto.hasNext()) {
			CitasDto citasDto = iterCitasDto.next();
			long timeFechaInicial = citasDto.getFechaCita().getTime() + citasDto.getHoraInicialCita().getTime();
			long timeFechaFinal = citasDto.getFechaCita().getTime() + citasDto.getHoraFinalCita().getTime();
			/* DefaultScheduleEvent defaultScheduleEvent = new DefaultScheduleEvent("IdCita:"+citasDto.getNumeroCita(),new Date(timeFechaInicial),new Date(timeFechaFinal)); */
			DefaultScheduleEvent defaultScheduleEvent = new DefaultScheduleEvent();
			EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(citasDto.getNumeroEstudio());
			defaultScheduleEvent.setTitle(estudiosDto.getNombreEstudio());
			defaultScheduleEvent.setDescription(citasDto.getNumeroCita()+"");
			defaultScheduleEvent.setStartDate(new Date(timeFechaInicial));
			defaultScheduleEvent.setEndDate(new Date(timeFechaFinal));
			defaultScheduleEvent.setStyleClass("dimax"+estudiosDto.getColorEstudio());
			eventModel.addEvent(defaultScheduleEvent);
			count = count+1;
		}
	}
	
	public void guardar() {
		boolean loggedIn = false;
	    CitasDto citasDto = new CitasDto();
		
		citasDto.setNumeroUbicacion(citas.getNumeroUbicacion());
		citasDto.setNumeroPaciente(citas.getNumeroPaciente());
		citasDto.setNumeroDoctor(citas.getNumeroDoctor());
		citasDto.setNumeroEstudio(citas.getNumeroEstudio());
		citasDto.setFechaCita(citas.getFechaCita());
		citasDto.setHoraInicialCita(citas.getHoraInicialCita());
		citasDto.setHoraFinalCita(citas.getHoraFinalCita());
		citasDto.setEstatus(citas.getEstatus());
		citasDto.setFechaCreacion(citas.getFechaCreacion());
		citasDto.setFechaUltimaActualizacion(citas.getFechaUltimaActualizacion());
		citasDto.setComentarios(citas.getComentarios());
		
		citasLocal.insertCitas(citasDto);
		
		refreshEntity();
		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
	}
	
	public void aplicar() {
		System.out.println("Entra Aplicar"); 
        CitasDto citasDto = new CitasDto();
		
		citasDto.setNumeroUbicacion(citas.getNumeroUbicacion());
		citasDto.setNumeroPaciente(citas.getNumeroPaciente());
		citasDto.setNumeroDoctor(citas.getNumeroDoctor());
		citasDto.setNumeroEstudio(citas.getNumeroEstudio());
		citasDto.setFechaCita(citas.getFechaCita());
		citasDto.setHoraInicialCita(citas.getHoraInicialCita());
		citasDto.setHoraFinalCita(citas.getHoraFinalCita());
		citasDto.setEstatus(citas.getEstatus());
		citasDto.setFechaCreacion(citas.getFechaCreacion());
		citasDto.setFechaUltimaActualizacion(citas.getFechaUltimaActualizacion());
		citasDto.setComentarios(citas.getComentarios());
		
		citasLocal.insertCitas(citasDto);
		refreshEntity();
		citas.setNumeroDoctor(0l);
		citas.setNumeroEstudio(0l);
		citas.setHoraInicialCita(null);
		citas.setHoraFinalCita(null);
		citas.setUtilHoraInicialCita(null);
		citas.setUtilHoraFinalCita(null);
		System.out.println("Sale Aplicar"); 
	}
	
	
	public void guardarNota() {
		boolean loggedInNota = false;
		NotasCitasDto notasCitasDto = new NotasCitasDto();
		notasCitasDto.setFechaNota(notasCitas.getFechaNota());
		notasCitasDto.setTxtNota(notasCitas.getTxtNota());
		notasCitasLocal.insertNotasCitas(notasCitasDto);
		refreshEntityNotas();
		loggedInNota = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedInNota", loggedInNota);
	}

	public void seleccionarFecha(SelectEvent selectEvent) {
		System.out.println((Date) selectEvent.getObject());
		citas.setUtilFechaCita((Date) selectEvent.getObject());
		citas.setUtilHoraInicialCita(null);
		citas.setUtilHoraFinalCita(null);
	}

	public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        String strTitle = event.getTitle();
       /* String strIdCita = strTitle.substring(7); */
        String strIdCita = event.getDescription();
        CitasDto citasDto = citasLocal.findByNumeroCita(Long.parseLong(strIdCita));
        
        citasSelected.setNumeroCita(citasDto.getNumeroCita());
        citasSelected.setNumeroUbicacion(citasDto.getNumeroUbicacion());
        citasSelected.setNumeroDoctor(citasDto.getNumeroDoctor());
        System.out.println("onEventSelect:"+citasDto.getNumeroPaciente());
        citasSelected.setNumeroPaciente(citasDto.getNumeroPaciente());
        citasSelected.setNumeroEstudio(citasDto.getNumeroEstudio());
        System.out.println("citasDto.getFechaCita():"+citasDto.getFechaCita());
        System.out.println("citasDto.getHoraInicialCita():"+citasDto.getHoraInicialCita());
        System.out.println("citasDto.getHoraFinalCita():"+citasDto.getHoraFinalCita());
        
        citasSelected.setUtilFechaCita(new Date(citasDto.getFechaCita().getTime()));
        citasSelected.setUtilHoraInicialCita(new Date(citasDto.getHoraInicialCita().getTime()));
        citasSelected.setUtilHoraFinalCita(new Date(citasDto.getHoraFinalCita().getTime()));
        
	} 
	
	public void actualizaCita() {
		boolean updatedIn = false;
		 CitasDto citasDto = new CitasDto();
		
		 System.out.println("actualizaCita NumeroDoctor:"+citasSelected.getNumeroDoctor());
		 System.out.println("actualizaCita NumeroPaciente:"+citasSelected.getNumeroPaciente());
		 citasDto.setNumeroDoctor(citasSelected.getNumeroDoctor());
		 citasDto.setNumeroPaciente(citasSelected.getNumeroPaciente());
		 citasDto.setNumeroEstudio(citasSelected.getNumeroEstudio());
		 citasDto.setFechaCita(citasSelected.getFechaCita());
		 citasDto.setHoraInicialCita(citasSelected.getHoraInicialCita());
		 citasDto.setHoraFinalCita(citasSelected.getHoraFinalCita());
		 
		 citasLocal.actualizaCitas(citasDto, citasSelected.getNumeroCita());
		 refreshEntity();
		 updatedIn = true;
		 PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void borrarCita() {
		citasLocal.deleteCita(citasSelected.getNumeroCita());
		refreshEntity();
	}
	
	public void handleDoctorChange() {
		if(0!=this.searchNumDoct
		  ||(null!=this.searchTipoEstu&&!"".equals(this.searchTipoEstu))
		  ) {
		 refreshEntityByNumDoc(this.searchNumDoct
				              ,this.searchTipoEstu
				              );
		}else {
		 refreshEntity();
		}
		
	}
	
	public void generarOrden() {
		long lNumeroPaciente  = citasSelected.getNumeroPaciente(); 
		long lNumeroEstudio = citasSelected.getNumeroEstudio(); 
		long lNumeroDoctor = citasSelected.getNumeroDoctor(); 
		
		PacientesDto pacientesDto = pacientesLocal.findByNumeroPaciente(lNumeroPaciente); 
		EstudiosDto estudiosDto = estudiosLocal.findByNumeroEstudio(lNumeroEstudio); 
		DoctoresDto doctoresDto = doctoresLocal.findByNumeroDoctor(lNumeroDoctor); 
		int intMonthsBetween =  differenceInMonths(new Date(pacientesDto.getFechaNacimientoPaciente().getTime()),new Date());
		int intAniosBetween = intMonthsBetween/12;
		 
		 if("OrdenesSimples".equals(tipoOrden)) {
			 ordenesEstudiosSimples.setNumeroPaciente(lNumeroPaciente);
			 ordenesEstudiosSimples.setNombrePaciente(pacientesDto.getNombrePaciente());
			 ordenesEstudiosSimples.setNumeroDoctor(lNumeroDoctor);
			 ordenesEstudiosSimples.setNombreDoctor(doctoresDto.getNombreDoctor());
			 ordenesEstudiosSimples.setEdad(intAniosBetween+" anios");
			 ordenesEstudiosSimples.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			 ordenesEstudiosSimples.setUtilHoraFinalOrden(new Date(citasSelected.getHoraFinalCita().getTime()));
			 ordenesEstudiosSimples.setUtilHoraInicialOrden(new Date(citasSelected.getHoraInicialCita().getTime()));
			 ordenesEstudiosSimples.setNumeroEstudio(citasSelected.getNumeroEstudio());
			 ordenesEstudiosSimples.setNombreEstudio(estudiosDto.getNombreEstudio());
			 ordenesEstudiosSimples.setCostoEstudio(estudiosDto.getCostoEstudio());
		 }else if("OrdenesEspeciales".equals(tipoOrden)) {
			 ordenesEstudiosEspeciales.setNumeroPaciente(lNumeroPaciente);
			 ordenesEstudiosEspeciales.setNombrePaciente(pacientesDto.getNombrePaciente());
			 ordenesEstudiosEspeciales.setNumeroDoctor(lNumeroDoctor);
			 ordenesEstudiosEspeciales.setNombreDoctor(doctoresDto.getNombreDoctor());
			 ordenesEstudiosEspeciales.setEdad(intAniosBetween+" anios");
			 ordenesEstudiosEspeciales.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			 ordenesEstudiosEspeciales.setUtilHoraFinalOrden(new Date(citasSelected.getHoraFinalCita().getTime()));
			 ordenesEstudiosEspeciales.setUtilHoraInicialOrden(new Date(citasSelected.getHoraInicialCita().getTime()));
			 ordenesEstudiosEspeciales.setNumeroEstudio(citasSelected.getNumeroEstudio());
			 ordenesEstudiosEspeciales.setNombreEstudio(estudiosDto.getNombreEstudio());
			 ordenesEstudiosEspeciales.setCostoEstudio(estudiosDto.getCostoEstudio()); 
		 }else if("OrdenesContrastados".equals(tipoOrden)) {
			 ordenesEstudiosContrastados.setNumeroPaciente(lNumeroPaciente);
			 ordenesEstudiosContrastados.setNombrePaciente(pacientesDto.getNombrePaciente());
			 ordenesEstudiosContrastados.setNumeroDoctor(lNumeroDoctor);
			 ordenesEstudiosContrastados.setNombreDoctor(doctoresDto.getNombreDoctor());
			 ordenesEstudiosContrastados.setEdad(intAniosBetween+" anios");
			 ordenesEstudiosContrastados.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			 ordenesEstudiosContrastados.setUtilHoraFinalOrden(new Date(citasSelected.getHoraFinalCita().getTime()));
			 ordenesEstudiosContrastados.setUtilHoraInicialOrden(new Date(citasSelected.getHoraInicialCita().getTime()));
			 ordenesEstudiosContrastados.setNumeroEstudio(citasSelected.getNumeroEstudio());
			 ordenesEstudiosContrastados.setNombreEstudio(estudiosDto.getNombreEstudio());
			 ordenesEstudiosContrastados.setCostoEstudio(estudiosDto.getCostoEstudio()); 
		 }else if("OrdenesDentales".equals(tipoOrden)) {
			 ordenesEstudiosDentales.setNumeroPaciente(lNumeroPaciente);
			 ordenesEstudiosDentales.setNombrePaciente(pacientesDto.getNombrePaciente());
			 ordenesEstudiosDentales.setNumeroDoctor(lNumeroDoctor);
			 ordenesEstudiosDentales.setNombreDoctor(doctoresDto.getNombreDoctor());
			 ordenesEstudiosDentales.setEdad(intAniosBetween+" anios");
			 ordenesEstudiosDentales.setFechaNacimientoPaciente(pacientesDto.getFechaNacimientoPaciente());
			 ordenesEstudiosDentales.setUtilHoraFinalOrden(new Date(citasSelected.getHoraFinalCita().getTime()));
			 ordenesEstudiosDentales.setUtilHoraInicialOrden(new Date(citasSelected.getHoraInicialCita().getTime()));
			 ordenesEstudiosDentales.setNumeroEstudio(citasSelected.getNumeroEstudio());
			 ordenesEstudiosDentales.setNombreEstudio(estudiosDto.getNombreEstudio());
			 ordenesEstudiosDentales.setCostoEstudio(estudiosDto.getCostoEstudio());
		 } 
		 
		 PrimeFaces.current().ajax().addCallbackParam("pAjaxTipoOrden", tipoOrden);
	}
	
	public void insertaOrdenSimple() {
		
		  boolean loggedIn = false;
			
		  OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
		  
		  ordenesEstudiosDto.setNumeroUbicacion(ordenesEstudiosSimples.getNumeroUbicacion());
		  ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosSimples.getNumeroDoctor());
		  ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosSimples.getNumeroPaciente());
		  ordenesEstudiosDto.setTipoOrden((short)1/*Simple*/);
		  ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosSimples.getNumeroEstudio()/*(long)2*/);
		  ordenesEstudiosDto.setNumeroAlergia(null/**Alergia Dummy**/);
		  ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosSimples.getRequiereFactura());
		  ordenesEstudiosDto.setTipoPago(ordenesEstudiosSimples.getTipoPago());
		  ordenesEstudiosDto.setEstatus(ordenesEstudiosSimples.getEstatus());
		  ordenesEstudiosDto.setFechaCreacion(ordenesEstudiosSimples.getFechaCreacion());
		  ordenesEstudiosDto.setUsuarioUltimaActualizacion(ordenesEstudiosSimples.getUsuarioUltimaActualizacion());
		  ordenesEstudiosDto.setFechaUltimaActualizacion(ordenesEstudiosSimples.getFechaUltimaActualizacion());
		  ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosSimples.getIndicacionesDoctor());
		  ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosSimples.getInfoAdicional());
		  ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosSimples.getHoraInicialOrden());
		  ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosSimples.getHoraFinalOrden());
		  
		  ordenesEstudiosLocal.insertOrdenesEstudios(ordenesEstudiosDto);
		  refreshEntity();
		  loggedIn = true;
		  PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
			
		}
	
	public void insertaOrdenEspecial() {
		
		  boolean loggedIn = false;
			
		  OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
		  
		  String strselectedAlergiasPacientes = ""; 
		  if(null!=selectedAlergiasPacientes) {
			  for(int i=0;i<selectedAlergiasPacientes.length;i++) {
				  strselectedAlergiasPacientes = strselectedAlergiasPacientes+selectedAlergiasPacientes[i]+",";
			  }
			  strselectedAlergiasPacientes = strselectedAlergiasPacientes.substring(0, strselectedAlergiasPacientes.length()-1);
		  }
		  
		  ordenesEstudiosDto.setNumeroUbicacion(ordenesEstudiosEspeciales.getNumeroUbicacion());
		  ordenesEstudiosDto.setNumeroDoctor(ordenesEstudiosEspeciales.getNumeroDoctor());
		  ordenesEstudiosDto.setNumeroPaciente(ordenesEstudiosEspeciales.getNumeroPaciente());
		  ordenesEstudiosDto.setTipoOrden((short)2/*Especial*/);
		  ordenesEstudiosDto.setNumeroEstudio(ordenesEstudiosEspeciales.getNumeroEstudio()/* (long)2 Estudio Dummy*/);
		  ordenesEstudiosDto.setNumeroAlergia(strselectedAlergiasPacientes/**Alergia Dummy**/);
		  ordenesEstudiosDto.setRequiereFactura(ordenesEstudiosEspeciales.getRequiereFactura());
		  ordenesEstudiosDto.setTipoPago(ordenesEstudiosEspeciales.getTipoPago());
		  ordenesEstudiosDto.setEstatus(ordenesEstudiosEspeciales.getEstatus());
		  ordenesEstudiosDto.setFechaCreacion(ordenesEstudiosEspeciales.getFechaCreacion());
		  ordenesEstudiosDto.setUsuarioUltimaActualizacion(ordenesEstudiosEspeciales.getUsuarioUltimaActualizacion());
		  ordenesEstudiosDto.setFechaUltimaActualizacion(ordenesEstudiosEspeciales.getFechaUltimaActualizacion());
		  ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudiosEspeciales.getIndicacionesDoctor());
		  ordenesEstudiosDto.setInfoAdicional(ordenesEstudiosEspeciales.getInfoAdicional());
		 
		  ordenesEstudiosDto.setHoraInicialOrden(ordenesEstudiosEspeciales.getHoraInicialOrden());
		  ordenesEstudiosDto.setHoraFinalOrden(ordenesEstudiosEspeciales.getHoraFinalOrden());
		
		  
		  ordenesEstudiosLocal.insertOrdenesEstudios(ordenesEstudiosDto);
		  refreshEntity();
		  loggedIn = true;
		  PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
			
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
	
	public void selectNotasCitasForDelete(NotasCitas pNotasCitas) {
		notasCitasSelected = new NotasCitas();
		notasCitasSelected.setNumeroNota(pNotasCitas.getNumeroNota());
	}
	
	public void deleteNotasCitas() {
		notasCitasLocal.deleteNotasCitas(notasCitasSelected.getNumeroNota());
		refreshEntityNotas();
	}
	
	public Citas getCitas() {
		return citas;
	}

	public void setCitas(Citas citas) {
		this.citas = citas;
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public List<CitasDto> getListCitasDto() {
		return listCitasDto;
	}

	public void setListCitasDto(List<CitasDto> listCitasDto) {
		this.listCitasDto = listCitasDto;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public Citas getCitasSelected() {
		return citasSelected;
	}

	public void setCitasSelected(Citas citasSelected) {
		this.citasSelected = citasSelected;
	}

	public long getSearchNumDoct() {
		return searchNumDoct;
	}

	public void setSearchNumDoct(long searchNumDoct) {
		this.searchNumDoct = searchNumDoct;
	}
	

	public NotasCitas getNotasCitas() {
		return notasCitas;
	}

	public void setNotasCitas(NotasCitas notasCitas) {
		this.notasCitas = notasCitas;
	}

	public List<NotasCitas> getListNotasCitas() {
		return listNotasCitas;
	}

	public void setListNotasCitas(List<NotasCitas> listNotasCitas) {
		this.listNotasCitas = listNotasCitas;
	}


	public NotasCitas getNotasCitasSelected() {
		return notasCitasSelected;
	}


	public void setNotasCitasSelected(NotasCitas notasCitasSelected) {
		this.notasCitasSelected = notasCitasSelected;
	}


	public String getSearchTipoEstu() {
		return searchTipoEstu;
	}


	public void setSearchTipoEstu(String searchTipoEstu) {
		this.searchTipoEstu = searchTipoEstu;
	}


	public String getTipoOrden() {
		return tipoOrden;
	}


	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}


	public OrdenesEstudiosSimples getOrdenesEstudiosSimples() {
		return ordenesEstudiosSimples;
	}

	public void setOrdenesEstudiosSimples(OrdenesEstudiosSimples ordenesEstudiosSimples) {
		this.ordenesEstudiosSimples = ordenesEstudiosSimples;
	}
	
	public OrdenesEstudiosEspeciales getOrdenesEstudiosEspeciales() {
		return ordenesEstudiosEspeciales;
	}

	public void setOrdenesEstudiosEspeciales(OrdenesEstudiosEspeciales ordenesEstudiosEspeciales) {
		this.ordenesEstudiosEspeciales = ordenesEstudiosEspeciales;
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
	
	public String[] getSelectedAlergiasPacientes() {
		return selectedAlergiasPacientes;
	}
	
	public void setSelectedAlergiasPacientes(String[] selectedAlergiasPacientes) {
		this.selectedAlergiasPacientes = selectedAlergiasPacientes;
	}

	public OrdenesEstudiosContrastados getOrdenesEstudiosContrastados() {
		return ordenesEstudiosContrastados;
	}

	public void setOrdenesEstudiosContrastados(OrdenesEstudiosContrastados ordenesEstudiosContrastados) {
		this.ordenesEstudiosContrastados = ordenesEstudiosContrastados;
	}
	
	public OrdenesEstudiosDentales getOrdenesEstudiosDentales() {
		return ordenesEstudiosDentales;
	}

	public void setOrdenesEstudiosDentales(OrdenesEstudiosDentales ordenesEstudiosDentales) {
		this.ordenesEstudiosDentales = ordenesEstudiosDentales;
	} 
	
}
