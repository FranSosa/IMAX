package com.dtecimax.ejb.backing.ar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import com.dtecimax.ejb.model.ar.AlergiasPacientes;
import com.dtecimax.ejb.services.ar.AlergiasPacientesLocal;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;

@ManagedBean  
@ViewScoped
public class AlergiasPacientesForm {
	

	@ManagedProperty(value="#{alergiasPacientes}") 
	private AlergiasPacientes alergiasPacientes;
	
	private AlergiasPacientes alergiasPacientesSelected = new AlergiasPacientes();
	
	private List<AlergiasPacientes> listAlergiasPacientes = new ArrayList<AlergiasPacientes>();
	
	@Inject 
	AlergiasPacientesLocal alergiasPacientesLocal;
	
	@PostConstruct
	public void init() {
		refreshEntity();
	}
	 
	private void refreshEntity() {
		List<AlergiasPacientesDto> listAlergiasPacientesDto = alergiasPacientesLocal.findAll();
		listAlergiasPacientes = new ArrayList<AlergiasPacientes>();
		Iterator<AlergiasPacientesDto> iterAlergiasPacientesDto =  listAlergiasPacientesDto.iterator();
		while(iterAlergiasPacientesDto.hasNext()) {
			AlergiasPacientesDto alergiasPacientesDto = iterAlergiasPacientesDto.next();
			AlergiasPacientes alergiasPacientes = new AlergiasPacientes();
			alergiasPacientes.setNumeroAlergia(alergiasPacientesDto.getNumeroAlergia());
			alergiasPacientes.setNombreAlergia(alergiasPacientesDto.getNombreAlergia());
			alergiasPacientes.setDescripcion(alergiasPacientesDto.getDescripcion());
			listAlergiasPacientes.add(alergiasPacientes);
		}
	}
	
	public void selectForUpdate(AlergiasPacientes pAlergiasPacientes) {
		alergiasPacientesSelected.setNumeroAlergia(pAlergiasPacientes.getNumeroAlergia());
		alergiasPacientesSelected.setNombreAlergia(pAlergiasPacientes.getNombreAlergia());
		alergiasPacientesSelected.setDescripcion(pAlergiasPacientes.getDescripcion());
	}
    
	public void selectForDelete(AlergiasPacientes pAlergiasPacientes) {
		alergiasPacientesSelected.setNumeroAlergia(pAlergiasPacientes.getNumeroAlergia());
		alergiasPacientesSelected.setNombreAlergia(pAlergiasPacientes.getNombreAlergia());
		alergiasPacientesSelected.setDescripcion(pAlergiasPacientes.getDescripcion());
	}

	public void insertaAlergiaPaciente() {
		boolean loggedIn = false;
		AlergiasPacientesDto alergiasPacientesDto = new AlergiasPacientesDto(); 
		alergiasPacientesDto.setNombreAlergia(alergiasPacientes.getNombreAlergia());
		alergiasPacientesDto.setDescripcion(alergiasPacientes.getDescripcion());
		alergiasPacientesLocal.insetAlergiasPacientes(alergiasPacientesDto);
		refreshEntity();
		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
	}
	
	public void updateAlergiasPacientes() {
		boolean updatedIn = false;
		AlergiasPacientesDto alergiasPacientesDto = new AlergiasPacientesDto(); 
		alergiasPacientesDto.setNombreAlergia(alergiasPacientesSelected.getNombreAlergia());
		alergiasPacientesDto.setDescripcion(alergiasPacientesSelected.getDescripcion());
		alergiasPacientesLocal.updateAlergiasPacientes(alergiasPacientesSelected.getNumeroAlergia(), alergiasPacientesDto);
		refreshEntity();
		updatedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void deleteAlergiasPacientes() {
		alergiasPacientesLocal.deleteAlergiasPacientes(alergiasPacientesSelected.getNumeroAlergia());
		refreshEntity();
	}
	
	public List<AlergiasPacientes> getListAlergiasPacientes() {
		return listAlergiasPacientes;
	}

	public void setListAlergiasPacientes(List<AlergiasPacientes> listAlergiasPacientes) {
		this.listAlergiasPacientes = listAlergiasPacientes;
	}

	public AlergiasPacientes getAlergiasPacientes() {
		return alergiasPacientes;
	}

	public void setAlergiasPacientes(AlergiasPacientes alergiasPacientes) {
		this.alergiasPacientes = alergiasPacientes;
	}
	
	public AlergiasPacientes getAlergiasPacientesSelected() {
		return alergiasPacientesSelected;
	}

	public void setAlergiasPacientesSelected(AlergiasPacientes alergiasPacientesSelected) {
		this.alergiasPacientesSelected = alergiasPacientesSelected;
	}

}
