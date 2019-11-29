package com.dtecimax.ejb.backing.admin;

import java.util.Locale;
import java.util.TimeZone;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import com.dtecimax.ejb.model.admin.Configuraciones;
import com.dtecimax.ejb.model.admin.PermisosUsuarios;
import com.dtecimax.ejb.model.admin.Ubicaciones;
import com.dtecimax.ejb.model.admin.Usuarios;
import com.dtecimax.ejb.model.ar.AlergiasPacientes;
import com.dtecimax.ejb.model.ar.Pacientes;
import com.dtecimax.ejb.model.as.Citas;
import com.dtecimax.ejb.model.as.Estudios;
import com.dtecimax.ejb.model.as.HistorialClinico;
import com.dtecimax.ejb.model.as.Interpretaciones;
import com.dtecimax.ejb.model.as.OrdenesEstudios;
import com.dtecimax.ejb.model.hr.Doctores;
import com.dtecimax.ejb.services.admin.ConfiguracionesLocal;
import com.dtecimax.ejb.services.admin.PermisosUsuariosLocal;
import com.dtecimax.ejb.services.admin.UbicacionesLocal;
import com.dtecimax.ejb.services.admin.UsuariosLocal;
import com.dtecimax.ejb.services.ar.AlergiasPacientesLocal;
import com.dtecimax.ejb.services.ar.PacientesLocal;
import com.dtecimax.ejb.services.as.CitasLocal;
import com.dtecimax.ejb.services.as.EstudiosLocal;
import com.dtecimax.ejb.services.as.HistorialClinicoLocal;
import com.dtecimax.ejb.services.as.InterpretacionesLocal;
import com.dtecimax.ejb.services.as.OrdenesEstudiosLocal;
import com.dtecimax.ejb.services.hr.DoctoresLocal;
import com.dtecimax.jpa.dto.admin.ConfiguracionesDto;
import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;
import com.dtecimax.jpa.dto.admin.UsuariosDto;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;
import com.dtecimax.jpa.dto.ar.PacientesDto;
import com.dtecimax.jpa.dto.as.CitasDto;
import com.dtecimax.jpa.dto.as.EstudiosDto;
import com.dtecimax.jpa.dto.as.HistorialClinicoDto;
import com.dtecimax.jpa.dto.as.InterpretacionesDto;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;
import com.dtecimax.jpa.dto.hr.DoctoresDto;


@ManagedBean  
@RequestScoped
public class IndexForm {

	@ManagedProperty(value="#{ubicaciones}") 
	private Ubicaciones ubicaciones;
	
	@ManagedProperty(value="#{usuarios}") 
	private Usuarios usuarios;
	
	@ManagedProperty(value="#{permisosUsuarios}")
	private PermisosUsuarios permisosUsuarios;
	
	@ManagedProperty(value="#{pacientes}")
	private Pacientes pacientes;
	

	@ManagedProperty(value="#{doctores}")
	private Doctores doctores;
	
	@ManagedProperty(value="#{estudios}")
	private Estudios estudios;
	
	@ManagedProperty(value="#{configuraciones}") 
	private Configuraciones configuraciones;
	
	@ManagedProperty(value="#{citas}") 
	private Citas citas;
	
	@ManagedProperty(value="#{alergiasPacientes}") 
	private AlergiasPacientes alergiasPacientes;
	
	@ManagedProperty(value="#{ordenesEstudios}") 
	private OrdenesEstudios ordenesEstudios;
	
	@ManagedProperty(value="#{interpretaciones}") 
	private Interpretaciones interpretaciones;

	@ManagedProperty(value="#{historialClinico}") 
	private HistorialClinico historialClinico;
	
	@Inject
	UbicacionesLocal ubicacionesLocal;
	
	@Inject
	UsuariosLocal usuariosLocal;
	
	@Inject
	PermisosUsuariosLocal permisosUsuariosLocal;
	
	@Inject
	PacientesLocal pacientesLocal;
	
	@Inject
	DoctoresLocal doctoresLocal;
	
	@Inject
	EstudiosLocal estudiosLocal;
	
	@Inject
	ConfiguracionesLocal configuracionesLocal;
	
	@Inject
	CitasLocal citasLocal;
	
	@Inject
	AlergiasPacientesLocal alergiasPacientesLocal;

	@Inject
	OrdenesEstudiosLocal ordenesEstudiosLocal;
	
	@Inject
	InterpretacionesLocal interpretacionesLocal;
	
	@Inject 
	HistorialClinicoLocal historialClinicoLocal;
	
	public void insertaUbicacion() {
		  
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
	}

	
	public void insertUsuarios() {
		UsuariosDto usuariosDto = new UsuariosDto();
		
		usuariosDto.setNumeroUbicacion(usuarios.getNumeroUbicacion());
		usuariosDto.setClaveUsuario(usuarios.getClaveUsuario());
		usuariosDto.setNombreUsuario(usuarios.getNombreUsuario());
		usuariosDto.setApellidoPaternoUsuario(usuarios.getApellidoPaternoUsuario());
		usuariosDto.setApellidoMaternoUsuario(usuarios.getApellidoMaternoUsuario());
		usuariosDto.setContrasenaUsuario(usuarios.getContrasenaUsuario());
		usuariosDto.setEstatus(usuarios.getEstatus());
		usuariosDto.setFechaCreacion(usuarios.getFechaCreacion());
		usuariosDto.setFechaUltimaActualizacion(usuarios.getFechaUltimaActualizacion());
		usuariosDto.setComentarios(usuarios.getComentarios());
		
		usuariosLocal.insertUsuarios(usuariosDto);
	}
	
	public void insertPermisosUsuarios() {
		PermisosUsuariosDto permisosUsuariosDto = new PermisosUsuariosDto();
		
		permisosUsuariosDto.setNumeroUsuario(permisosUsuarios.getNumeroUsuario());
		permisosUsuariosDto.setNumeroUbicacion(permisosUsuarios.getNumeroUbicacion());
		permisosUsuariosDto.setEstatus(permisosUsuarios.getEstatus());
		permisosUsuariosDto.setFechaCreacion(permisosUsuarios.getFechaCreacion());
		permisosUsuariosDto.setFechaUltimaActualizacion(permisosUsuarios.getFechaUltimaActualizacion());
		permisosUsuariosDto.setComentarios(permisosUsuarios.getComentarios());
		
		//permisosUsuariosLocal.insertPermisosUsuario(permisosUsuariosDto);
	}

	public void insertPacientes() {
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
	}
	
	public void insertDoctores() {
		
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

	}

	public void insertEstudios() {
		EstudiosDto estudiosDto = new EstudiosDto();
		estudiosDto.setNumeroUbicacion(estudios.getNumeroUbicacion());
		estudiosDto.setNombreEstudio(estudios.getNombreEstudio());
		estudiosDto.setTipoEstudio(estudios.getTipoEstudio());
		estudiosDto.setCostoEstudio(estudios.getCostoEstudio());
		estudiosDto.setRealizaEstudio(estudios.getRealizaEstudio());
		estudiosDto.setEstatus(estudios.getEstatus());
		
		estudiosDto.setFechaCreacion(estudios.getFechaCreacion());
		estudiosDto.setFechaUltimaActualizacion(estudios.getFechaUltimaActualizacion());
		estudiosDto.setComentarios(estudios.getComentarios());
		
		estudiosLocal.insertEstudios(estudiosDto);
	}
	
	public void insertConfiguraciones() {
		ConfiguracionesDto configuracionesDto = new ConfiguracionesDto();
		
		
		configuracionesDto.setValor_1(configuraciones.getValor_1());
		configuracionesDto.setValor_2(configuraciones.getValor_2());
		configuracionesDto.setValor_3(configuraciones.getValor_3());
		configuracionesDto.setValor_4(configuraciones.getValor_4());
		configuracionesDto.setValor_5(configuraciones.getValor_5());
		configuracionesDto.setValor_6(configuraciones.getValor_6());
		configuracionesDto.setValor_7(configuraciones.getValor_7());
		configuracionesDto.setValor_8(configuraciones.getValor_8());
		configuracionesDto.setValor_9(configuraciones.getValor_9());
		configuracionesDto.setValor_10(configuraciones.getValor_10());
		configuracionesDto.setEstatus(configuraciones.getEstatus());
		configuracionesDto.setFechaCreacion(configuraciones.getFechaCreacion());
		configuracionesDto.setFechaUltimaActualizacion(configuraciones.getFechaUltimaActualizacion());
		configuracionesDto.setComentarios(configuraciones.getComentarios());
		
		
		configuracionesLocal.insertConfiguraciones(configuracionesDto);
	}
	
	public void insertCitas() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = facesContext.getViewRoot();
		Locale locale = viewRoot.getLocale();
		System.out.println(locale);
		System.out.println(TimeZone.getDefault().getDisplayName());
		
		CitasDto citasDto = new CitasDto();
		
		citasDto.setNumeroUbicacion(citas.getNumeroUbicacion());
		citasDto.setNumeroPaciente(citas.getNumeroPaciente());
		citasDto.setNumeroDoctor(citas.getNumeroDoctor());
		
		System.out.println("citas.getNumeroEstudio():"+citas.getNumeroEstudio());
		
		citasDto.setNumeroEstudio(citas.getNumeroEstudio());
		
		citasDto.setFechaCita(citas.getFechaCita());
		citasDto.setHoraInicialCita(citas.getHoraInicialCita());
		citasDto.setHoraFinalCita(citas.getHoraFinalCita());
		
		citasDto.setEstatus(citas.getEstatus());
		citasDto.setFechaCreacion(citas.getFechaCreacion());
		citasDto.setFechaUltimaActualizacion(citas.getFechaUltimaActualizacion());
		citasDto.setComentarios(citas.getComentarios());
		
		citasLocal.insertCitas(citasDto);
	}
	
	public void insertAlergiasPacientes() {
		
		AlergiasPacientesDto alergiasPacientesDto = new AlergiasPacientesDto();
		
		alergiasPacientesDto.setNombreAlergia(alergiasPacientes.getNombreAlergia());
		alergiasPacientesDto.setDescripcion(alergiasPacientes.getDescripcion());
		
		alergiasPacientesLocal.insetAlergiasPacientes(alergiasPacientesDto);
	}
	
	public void insertOrdenesEstudios() {
		OrdenesEstudiosDto ordenesEstudiosDto = new OrdenesEstudiosDto();
		
		ordenesEstudiosDto.setNumeroUbicacion(ordenesEstudios.getNumeroUbicacion());
		ordenesEstudiosDto.setNumeroCita(ordenesEstudios.getNumeroCita());
		ordenesEstudiosDto.setNumeroPaciente(ordenesEstudios.getNumeroPaciente());
		ordenesEstudiosDto.setNumeroDoctor(ordenesEstudios.getNumeroDoctor());
		ordenesEstudiosDto.setNumeroEstudio(ordenesEstudios.getNumeroEstudio());
		ordenesEstudiosDto.setTipoOrden(ordenesEstudios.getTipoOrden());
		ordenesEstudiosDto.setTipoPago(ordenesEstudios.getTipoPago());
		ordenesEstudiosDto.setNumeroAlergia(ordenesEstudios.getNumeroAlergia());
		ordenesEstudiosDto.setRequiereFactura(ordenesEstudios.getRequiereFactura());
		ordenesEstudiosDto.setEstatus(ordenesEstudios.getEstatus());
		ordenesEstudiosDto.setFechaCreacion(ordenesEstudios.getFechaCreacion());
		ordenesEstudiosDto.setFechaUltimaActualizacion(ordenesEstudios.getFechaUltimaActualizacion());
		ordenesEstudiosDto.setIndicacionesDoctor(ordenesEstudios.getIndicacionesDoctor());
		ordenesEstudiosDto.setInfoAdicional(ordenesEstudios.getInfoAdicional());
		
		ordenesEstudiosLocal.insertOrdenesEstudios(ordenesEstudiosDto);
		
	}
	
	public void insertInterpretaciones() {
		InterpretacionesDto interpretacionesDto = new InterpretacionesDto();
		
		interpretacionesDto.setNumeroUbicacion(interpretaciones.getNumeroUbicacion());
		interpretacionesDto.setNumeroOrden(interpretaciones.getNumeroOrden());
		interpretacionesDto.setNumeroCita(interpretaciones.getNumeroCita());
		interpretacionesDto.setNumeroEstudio(interpretaciones.getNumeroEstudio());
		interpretacionesDto.setNumeroPaciente(interpretaciones.getNumeroPaciente());
		interpretacionesDto.setNumeroDoctor(interpretaciones.getNumeroDoctor());
		interpretacionesDto.setEstatus(interpretaciones.getEstatus());
		interpretacionesDto.setFechaCreacion(interpretaciones.getFechaCreacion());
		interpretacionesDto.setFechaUltimaActualizacion(interpretaciones.getFechaUltimaActualizacion());
		interpretacionesDto.setInterpretacion(interpretaciones.getInterpretacion());
		
		interpretacionesLocal.insertInterpretaciones(interpretacionesDto);
	}
	
	public void insertHistorialClinico() {
		
        HistorialClinicoDto historialClinicoDto = new HistorialClinicoDto();
		
        historialClinicoDto.setNumeroInterpretacion(historialClinico.getNumeroInterpretacion());
		historialClinicoDto.setNumeroUbicacion(historialClinico.getNumeroUbicacion());
		historialClinicoDto.setNumeroOrden(historialClinico.getNumeroOrden());
		historialClinicoDto.setNumeroCita(historialClinico.getNumeroCita());
		historialClinicoDto.setNumeroEstudio(historialClinico.getNumeroEstudio());
		historialClinicoDto.setNumeroPaciente(historialClinico.getNumeroPaciente());
		historialClinicoDto.setNumeroDoctor(historialClinico.getNumeroDoctor());
		historialClinicoDto.setEstatus(historialClinico.getEstatus());
		historialClinicoDto.setFechaCreacion(historialClinico.getFechaCreacion());
		historialClinicoDto.setFechaUltimaActualizacion(historialClinico.getFechaUltimaActualizacion());
		
		historialClinicoLocal.insertHistorialClinico(historialClinicoDto);
		
	}
	
	public void valueChangeUsuario(ValueChangeEvent e){
		String strNewvalue = e.getNewValue().toString();
		Long lNumeroUsuario = new Long(strNewvalue);
		System.out.println("strNewvalue:"+strNewvalue);
		
		UsuariosDto usuariosDto = new UsuariosDto(); 
		usuariosDto = usuariosLocal.findUbicacionByNumUser(lNumeroUsuario);
		permisosUsuarios.setNumeroUbicacion(usuariosDto.getNumeroUbicacion());
		System.out.println("*");
		UbicacionesDto ubicacionesDto = new UbicacionesDto();
		
		ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(usuariosDto.getNumeroUbicacion());
		System.out.println(ubicacionesDto.getNombreUbicacion());
		permisosUsuarios.setNombreUbicacion(ubicacionesDto.getNombreUbicacion());
	}
	
	
	public Ubicaciones getUbicaciones() {
		return ubicaciones;
	}


	public void setUbicaciones(Ubicaciones ubicaciones) {
		this.ubicaciones = ubicaciones;
	}


	public Usuarios getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}


	public PermisosUsuarios getPermisosUsuarios() {
		return permisosUsuarios;
	}


	public void setPermisosUsuarios(PermisosUsuarios permisosUsuarios) {
		this.permisosUsuarios = permisosUsuarios;
	}

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}


	public Doctores getDoctores() {
		return doctores;
	}


	public void setDoctores(Doctores doctores) {
		this.doctores = doctores;
	}

	public Estudios getEstudios() {
		return estudios;
	}


	public void setEstudios(Estudios estudios) {
		this.estudios = estudios;
	}

	public Configuraciones getConfiguraciones() {
		return configuraciones;
	}


	public void setConfiguraciones(Configuraciones configuraciones) {
		this.configuraciones = configuraciones;
	}


	public Citas getCitas() {
		return citas;
	}


	public void setCitas(Citas citas) {
		this.citas = citas;
	}


	public AlergiasPacientes getAlergiasPacientes() {
		return alergiasPacientes;
	}


	public void setAlergiasPacientes(AlergiasPacientes alergiasPacientes) {
		this.alergiasPacientes = alergiasPacientes;
	}
	
	public OrdenesEstudios getOrdenesEstudios() {
		return ordenesEstudios;
	}

	public void setOrdenesEstudios(OrdenesEstudios ordenesEstudios) {
		this.ordenesEstudios = ordenesEstudios;
	}
	
	public Interpretaciones getInterpretaciones() {
		return interpretaciones;
	}

	public void setInterpretaciones(Interpretaciones interpretaciones) {
		this.interpretaciones = interpretaciones;
	}


	public HistorialClinico getHistorialClinico() {
		return historialClinico;
	}


	public void setHistorialClinico(HistorialClinico historialClinico) {
		this.historialClinico = historialClinico;
	}
	
	
}
